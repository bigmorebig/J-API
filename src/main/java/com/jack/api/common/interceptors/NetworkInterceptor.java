package com.jack.api.common.interceptors;

import com.jack.api.common.utils.NetworkUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class NetworkInterceptor implements HandlerInterceptor {
//    /**
//     * handler方法执行之前执行该方法
//     */
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.getWriter().write("测试异常");
//        return true;
//    }
//
//    /**
//     * handler执行完业务逻辑，但是还没有跳转到页面执行该方法
//     */
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    /**
//     * 页面已经渲染完之后执行
//     */
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
}
