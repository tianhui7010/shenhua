package com.nb.jingubang.frame;

import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Type;

/**
 * @param <T>：entity 返回结果类型
 * @param <C>：condition 前台传入的条件
 */
public interface SpecificationBase<T,C> {

    Specification<T> getSpecification(C condition);

}
