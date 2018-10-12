package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaojie.Ma on 2018/2/24.
 */
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * filterOrder() must also be defined for a filter. Filters may have the same  filterOrder if precedence is not
     * important for a filter. filterOrders do not need to be sequential.
     *
     * @return the int order of a filter
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * a "true" return from this method means that the run() method should be invoked
     *
     * @return true if the run() method should be invoked. false will not invoke the run() method
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * if shouldFilter() is true, this method will be invoked. this method is the core method of a ZuulFilter
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取HttpServletRequest对象
        HttpServletRequest request = requestContext.getRequest();
        String accessToken = request.getParameter("accessToken");

        //判断客户端是否传入accessToken
        if(accessToken == null || "".equals(accessToken)) {
            //拒绝路由服务
            requestContext.setSendZuulResponse(false);
            //设置HTTP响应码
            requestContext.setResponseStatusCode(401);
        }
        return null;
    }

}
