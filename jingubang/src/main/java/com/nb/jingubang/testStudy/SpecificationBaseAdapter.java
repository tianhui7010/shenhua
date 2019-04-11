package com.nb.jingubang.testStudy;

import com.nb.jingubang.frame.SpecificationBase;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by 52613 on 2019/4/4.
 */
public abstract class SpecificationBaseAdapter<T, C> implements SpecificationBase {


    /**
     * 获取父类的泛型
     */
    public Type getTofAdapter() {
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type type = genericSuperclass.getActualTypeArguments()[0];
        return type;
    }

    /**
     * 获取接口的泛型
     **/
    Type getTofInterface() {
        Type[] types = this.getClass().getGenericInterfaces();
        Type type = types[0];
        return type;
    }


}
