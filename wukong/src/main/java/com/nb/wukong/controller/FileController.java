package com.nb.wukong.controller;

import com.nb.wukong.utils.Response;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.util.List;

/**
 * 文件的上传下载
 */
@RestController
@RequestMapping("file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    /**
     * 上传
     */
    @RequestMapping("upload")
    public Response upload(@RequestParam("file") MultipartFile file){
        try {
            if (file.isEmpty()) {
                return Response.error("文件为空");
            }
            //获取文件名
            String fileName = file.getOriginalFilename();
            System.out.println("上传的文件名是：" + fileName);
            logger.debug("logger fileName is : ()", fileName);

            //获取后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));

            //设置文件路径
            String filePath = "F:\\springboot\\fileUpLoadPath\\";
            String path = filePath + fileName;
            File dest = new File(path);

            //检测目录是否存在
            if (!dest.getParentFile().exists()) {
                //新建文件夹
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return Response.success("上传成功");

        } catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return Response.error("上传失败");
    }

    @PostMapping("batch")
    public Response batch(HttpServletRequest request){
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i =0;i<files.size();i++){
            file = files.get(i);
            String filePath = "F:\\springboot\\fileUpLoadPath\\";
            if(!file.isEmpty()){
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File (filePath+file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                }catch (Exception e) {
                    stream = null;
                    return Response.error("第 " + i + " 个文件上传失败 ==> "
                            + e.getMessage());
                }
            }else {
                return Response.error( "第 " + i
                        + " 个文件上传失败因为文件为空");
            }
        }
        return Response.success("上传成功");
    }

    @RequestMapping("downLoad")
    public Response downLoad(HttpServletRequest request, HttpServletResponse response){

        String fileName = "员工.jpg";
        if (fileName != null) {

            File file = new File("F:\\springboot\\fileUpLoadPath\\员工.jpg");
            if(file.exists()){
                //设置强制下载不打开
                response.setContentType("application/force-download");
                response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
                byte [] buffer = new  byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return Response.success("下载成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return Response.SUCCESS;
    }

    /**
     * 跳转至FileController
     */
    @RequestMapping("file")
    public String index()
    {
        return "file";
    }

}
