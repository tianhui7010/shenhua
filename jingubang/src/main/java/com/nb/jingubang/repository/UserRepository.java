package com.nb.jingubang.repository;


import com.nb.jingubang.entity.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 52613 on 2019/3/6.
 */
@Repository
public interface UserRepository extends CrudRepository<SysUser,Long> {

    SysUser getByUserName(String userName);

}
