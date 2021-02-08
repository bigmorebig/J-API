package com.jack.api.common.utils;

@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T> {
    void callBack(S s, T t);
}
