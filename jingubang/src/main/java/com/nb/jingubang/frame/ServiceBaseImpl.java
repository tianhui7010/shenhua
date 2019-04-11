package com.nb.jingubang.frame;

import com.nb.jingubang.entity.EntityBase;
import com.nb.jingubang.utils.Page;
import com.nb.jingubang.utils.Pageable;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

/**
 * T entity
 * R repository
 * S specification
 */
public class ServiceBaseImpl<R extends RepositoryBase, S extends SpecificationBase>  implements ServiceBase{

    @Autowired
    private S specification;

    @Autowired
    private R repository;

    @Override
    public void save(EntityBase o) {
        repository.save( o );
    }

    @Override
    public EntityBase getOne(Long id) {
        return (EntityBase) repository.findOne( id );
    }

    @Override
    public List<EntityBase> getAll(ConditionBase condition) {

        Specification<EntityBase> predicates = specification.getSpecification( condition );

        List<EntityBase> list = repository.findAll( predicates );

        return list;
    }
    @Override
    public Page<EntityBase> getAll(ConditionBase condition,Pageable pageable) {

        Specification<EntityBase> predicates = specification.getSpecification( condition );

        org.springframework.data.domain.Page jpaPage = repository.findAll( predicates, pageable );

        Page<EntityBase> page = new Page<EntityBase>(jpaPage.getTotalElements(), jpaPage.getTotalPages(), jpaPage.getContent(), jpaPage.getNumber(), jpaPage.getSize() );
        return page;
    }

}
