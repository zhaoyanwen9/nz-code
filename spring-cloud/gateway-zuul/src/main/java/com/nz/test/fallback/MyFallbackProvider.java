package com.nz.test.fallback;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * zuul网关内部默认集成了Hystrix、Ribbon
 *
 * @author nz
 */
@Component
public class MyFallbackProvider { // implements FallbackProvider

//    /**
//     * @return
//     */
//    @Override
//    public String getRoute() {
//        return "*";
//    }
//
//    @Override
//    public ClientHttpResponse fallbackResponse(String s, Throwable throwable) {
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return HttpStatus.OK;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return 200;
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return "ok";
//            }
//
//            @Override
//            public void close() {
//
//            }
//
//            @Override
//            public InputStream getBody() throws IOException {
//                JSONObject r = new JSONObject();
//                try {
//                    r.put("state", "9999");
//                    r.put("msg", "系统错误，请求失败");
//                } catch (JSONException e) {
//
//                }
////                return new ByteArrayInputStream(r.toString().getBytes("UTF-8"));
//                return new ByteArrayInputStream((getRoute() + " :fallback").getBytes());
//            }
//
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
//                headers.setContentType(mt);
//                return headers;
//            }
//        };
//    }
}

