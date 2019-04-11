package com.nb.jingubang.repository.specification;

import com.nb.jingubang.entity.SysUser;
import com.nb.jingubang.frame.SpecificationBase;
import com.nb.jingubang.repository.condition.UserCondition;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by 52613 on 2019/4/4.
 */
public class UserSpecification implements SpecificationBase<SysUser,UserCondition> {


    @Override
    public Specification<SysUser> getSpecification(UserCondition condition) {
        return null;
    }
}
