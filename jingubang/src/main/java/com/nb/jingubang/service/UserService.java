package com.nb.jingubang.service;

import com.nb.jingubang.entity.SysUser;

/**
 * Created by 52613 on 2019/3/8.
 */
public interface UserService {

    SysUser getByUserName(String userName);

}
