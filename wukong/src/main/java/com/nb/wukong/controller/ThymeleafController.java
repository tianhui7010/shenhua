package com.nb.wukong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

/**
 * themplate 模板
 */
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @Autowired
    private MessageSource messageSource;

    /**
     * 测试
     * （1）themplate 是否集成成功
     * （2）国际化
     */
    @RequestMapping("thymeleaf")
    public String testThymeleaf(ModelMap modelMap){
        Locale locale = LocaleContextHolder.getLocale();
        modelMap.addAttribute("msg", "齐天大圣!");
        modelMap.addAttribute("message", messageSource.getMessage("message", null, locale));
        return "thymeleaf";
    }

}
