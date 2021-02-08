package com.jack.api.common.utils;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BeanCopyUtil extends BeanUtils {
    /**
     * 集合数据的拷贝
     * @param sources：数据源类
     * @param target：目标类::new(eg:UserV0::new)
     * @return list
     */
    public static <S, T> T copyProperties(S sources, Supplier<T> target){
        if (sources == null){
            return null;
        }
        if (target == null){
            return null;
        }
        T t = target.get();
        copyProperties(sources, t);
        return t;
    }

    /**
     * 集合数据的拷贝
     * @param sources: 数据源类
     * @param target：目标类::new(eg:UserVO::new)
     * @return  list
     */
    public static <S, T> T copyProperties(S sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack){
        if (sources == null){
            return null;
        }
        if (target == null){
            return null;
        }
        T t = target.get();
        copyProperties(sources, t);
        if (callBack != null){
            callBack.callBack(sources, t);
        }
        return t;
    }

    /**
     * 集合数据的拷贝
     * @param sources: 数据源类
     * @param target：目标类::new(eg:UserVO::new)
     * @return  list
     */
    public static <S, T>List<T> copyListProperties(List<S> sources, Supplier<T> target){
        return copyListProperties(sources, target, null);
    }

    /**
     * 带回调函数的集合数据的拷贝（课自定义字段拷贝规则）
     * @param sources: 数据源类
     * @param target：目标类::new(eg:UserVO::new)
     * @param callBack: 回调函数
     * @return  list
     */
    public static <S, T>List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack){
        if (sources == null || sources.isEmpty()){
            return Lists.newArrayList();
        }
        if (target == null){
            return Lists.newArrayList();
        }
        List<T> list = new ArrayList<>(sources.size());
        for (S source: sources){
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null){
                callBack.callBack(source, t);
            }
        }
        return list;
    }
}
