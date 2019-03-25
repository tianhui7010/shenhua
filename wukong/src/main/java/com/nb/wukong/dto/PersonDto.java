package com.nb.wukong.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * 人物
 */
@Data
public class PersonDto {

    /**姓名**/
    @NotEmpty(message="用户名不能为空")
    @Length(min = 2,max = 3,message = "姓名必须为2-3个字")
    private String userName;
    /**密码**/
    @Length(min = 6,max = 12,message = "密码必须为6-12位")
    private String passWord;
    /**身份证**/
    @Pattern(regexp = "^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message = "身份证格式错误")
    private String idCard;
    /**邮箱**/
    @Email(message = "邮箱格式错误")
    private String email;

}
