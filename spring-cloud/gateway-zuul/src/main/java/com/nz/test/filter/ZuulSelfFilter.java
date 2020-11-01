package com.nz.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nz
 */
public class ZuulSelfFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulSelfFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        if (request.getParameter("new-movie") != null) {
            ZuulSelfFilter.log.info(String.format("方法是 %s,路径是 %s", request.getMethod(), request.getRequestURL().toString()));
        } else {
            ZuulSelfFilter.log.info(String.format("路径是 %s,方法是 %s", request.getRequestURL().toString(), request.getMethod()));
        }
        return null;
    }
}
