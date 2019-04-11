package com.nb.jingubang.repository.specification;

import com.nb.jingubang.entity.City;
import com.nb.jingubang.entity.SysUser;
import com.nb.jingubang.frame.SpecificationBase;
import com.nb.jingubang.repository.condition.CityCondition;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52613 on 2019/4/3.
 */
@Repository
public class CitySpecification implements SpecificationBase<City,CityCondition> {



    @Override
    public Specification<City> getSpecification(final CityCondition condition) {

        return new Specification<City>() {

            @Override
            public Predicate toPredicate(Root<City> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();

                Long id = condition.getId();
                if (!"".equals( id ) && !(id ==null)) {
                    predicates.add( cb.equal( root.get( "id" ).as( String.class ), id ) );
                }
                String name = condition.getName();
                if (!"".equals( name )&& !(name==null)) {
                    predicates.add( cb.equal( root.get( "name" ).as( String.class ), name ) );
                }

                Predicate[] predicateArr = predicates.toArray( new Predicate[predicates.size()] );
                System.out.println("============aaa");
                return cb.and( predicateArr );
            }
        };

    }
}
