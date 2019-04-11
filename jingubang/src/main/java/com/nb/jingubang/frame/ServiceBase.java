package com.nb.jingubang.frame;


import com.nb.jingubang.entity.EntityBase;
import com.nb.jingubang.utils.Page;
import com.nb.jingubang.utils.Pageable;

import java.util.List;

/**
 * ServiceBase
 *
 * @param <T>:限定entity
 * @param <R>：entity的repository
 * @param <S>：entity的specification
 */
public interface ServiceBase<R extends RepositoryBase, S extends SpecificationBase> {

    void save(EntityBase t);

    EntityBase getOne(Long id);

    List<EntityBase> getAll(ConditionBase condition);

    Page<EntityBase> getAll(ConditionBase condition, Pageable pageable);

}
