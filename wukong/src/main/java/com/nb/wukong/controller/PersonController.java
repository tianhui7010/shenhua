package com.nb.wukong.controller;

import com.nb.wukong.dto.PersonDto;
import com.nb.wukong.utils.Response;
import com.nb.wukong.utils.anno.Login;
import com.nb.wukong.utils.exception.DtoException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("person")
public class PersonController {

    /**
     * 注册：测试参数校验 @Valid
     */
    @RequestMapping("registered")
    public Response registered(@Valid PersonDto dto, BindingResult bindingResult) {

        StringBuffer validResult = new StringBuffer();
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            for (ObjectError objectError : list) {
                validResult.append(objectError.getDefaultMessage());
                validResult.append("---");
            }
        }
        return  Response.error(validResult != null ? validResult.toString() : "");
    }

    /**
     * 注册：测试全局捕获dto异常
     */
    @RequestMapping("registeredTextException")
    public void registeredTextException(@Valid PersonDto dto, BindingResult bindingResult) throws DtoException {
        if (bindingResult.hasErrors()) {
            throw new DtoException("传参有误，请检查参数");
        }
    }

    /**
     * 测试拦截器
     */
    @Login
    @RequestMapping("testInter")
    public Response testInter(){
        return null;
    }
}
