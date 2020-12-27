package com.nz.test.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author nz
 */
@Component
public class ZuulSelfFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(ZuulSelfFilter.class);

    @Override
    public String filterType() {
        logger.info("#### 在路由之前进行过滤");
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        logger.info("#### 3");
        return 3;
    }

    @Override
    public boolean shouldFilter() {
        logger.info("#### 过滤的核心逻辑");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("#### 通过过滤");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("#### {} {}", request.getSession().getId(), request.getServletPath());
        if (request.getParameter("new-movie") != null) {
            logger.info(String.format("方法是 %s, 路径是 %s", request.getMethod(), request.getRequestURL().toString()));
        } else {
            logger.info(String.format("路径是 %s, 方法是 %s", request.getRequestURL().toString(), request.getMethod()));
        }
        // 获取请求的输入流
        InputStream stream = ctx.getResponseDataStream();
        try {
            String body = StreamUtils.copyToString(stream, StandardCharsets.UTF_8);
            System.out.println("返回数据：");
            System.out.println(body);
            logger.info("#### body {}", body);
            ctx.setResponseDataStream(new ByteArrayInputStream(body.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
