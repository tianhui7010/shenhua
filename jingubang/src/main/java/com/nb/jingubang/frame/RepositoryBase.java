package com.nb.jingubang.frame;

import com.nb.jingubang.entity.City;
import com.nb.jingubang.entity.EntityBase;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * RepositoryBase
 * @param <T>：对应的entity
 * @param <ID>：ID类型
 * @NoRepositoryBean使用该注解的接口不会被单独创建实例，而是作为其他接口的父接口来使用
 */
@NoRepositoryBean
public interface RepositoryBase<T,ID extends Serializable> extends  JpaRepository<T,ID> ,JpaSpecificationExecutor<T> {

}
