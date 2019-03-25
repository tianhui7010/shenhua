package com.nb.wukong.controller;

import com.nb.wukong.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件控制器
 */
@RestController
@RequestMapping("mail")
public class MailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mail.fromMail.sender}")
    private String sender;
    @Value("${mail.fromMail.receiver}")
    private String receiver;
    @Value("${spring.mail.password}")
    private String password;
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送简单邮件
     */
    @RequestMapping("sendMail")
    public Response sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject("田辉的程序(简单邮件)");
        message.setText("2019 加油！");
        Response response = null;
        String sendResult = null;
        try {
            javaMailSender.send(message);
            sendResult = "邮件发送成功";
            System.out.println(sendResult);
            response = Response.success(sendResult);
        } catch (Exception ex) {
            sendResult = "邮件发送异常！";
            System.out.println(sendResult);
            response = Response.error(sendResult);
        }
        return response;
    }

    /**
     * 发送html邮件
     */
    @RequestMapping("sendHtmlMail")
    public Response sendHtmlMail() {
        String content = "<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        Response response = null;
        String sendResult = null;
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("田辉的程序（html）");
            helper.setText(content, true);
            javaMailSender.send(mimeMessage);
            sendResult = "html 邮件发送成功";
            System.out.println(sendResult);
            response = Response.success(sendResult);
        } catch (MessagingException e) {
            sendResult = "mail 邮件发送失败";
            System.out.println(sendResult);
            response = Response.error(sendResult);
        }
        return response;
    }

    /**
     * 发送附件邮件
     */
    @RequestMapping("sendFilesMail")
    public Response sendFilesMail() {
        String filePath="F:\\springboot\\mail\\2019美好的开始.txt";
        MimeMessage message = javaMailSender.createMimeMessage();
        Response response = null;
        String sendResult = null;
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("田辉的程序(附件邮件)");
            helper.setText("测试发送带附件的邮件", true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);

            javaMailSender.send(message);
            sendResult = "附件邮件发送成功！";
            System.out.println(sendResult);
            response = Response.success(sendResult);
        } catch (MessagingException e) {
            sendResult = "附件邮件发送失败！";
            System.out.println(sendResult);
            response = Response.error(sendResult);
        }
        return response;
    }

    /**
     * 发送带图片的邮件
     */
    @RequestMapping("sendInlineResourceMail")
    public Response sendInlineResourceMail() {
        String Id = "田辉Id";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + Id + "\' ></body></html>";
        String imgPath = "F:\\springboot\\mail\\员工.jpg";
        MimeMessage message = javaMailSender.createMimeMessage();
        Response response =null;
        String sendResult = null;
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(receiver);
            helper.setSubject("这是有图片的邮件");
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(Id, res);

            javaMailSender.send(message);
            sendResult = "图片邮件发送成功！";
            System.out.println(sendResult);
            response = Response.success(sendResult);
        } catch (MessagingException e) {
            sendResult = "图片邮件发送失败！";
            System.out.println(sendResult);
            Response.error(sendResult);
        }
        return response;
    }

}
