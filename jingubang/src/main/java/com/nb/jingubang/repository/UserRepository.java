package com.nb.jingubang.repository;


import com.nb.jingubang.entity.SysUser;
import com.nb.jingubang.frame.RepositoryBase;
import org.springframework.stereotype.Repository;

/**
 * Created by 52613 on 2019/3/6.
 */
@Repository
public interface UserRepository extends RepositoryBase<SysUser,Long> {

    SysUser getByUserName(String userName);

}
