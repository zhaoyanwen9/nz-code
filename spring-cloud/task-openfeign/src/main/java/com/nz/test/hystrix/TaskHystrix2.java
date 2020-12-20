package com.nz.test.hystrix;

import com.nz.test.UserFeign;
import feign.hystrix.FallbackFactory;

public class UserHystrix implements FallbackFactory<UserFeign> {

    @Override
    public UserFeign create(Throwable throwable) {
        return null;
    }
}
