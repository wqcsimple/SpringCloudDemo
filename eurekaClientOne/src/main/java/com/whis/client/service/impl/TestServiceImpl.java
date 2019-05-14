package com.whis.client.service.impl;

import com.whis.client.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by whis on 2019-05-14
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
        return "sorry " + name;
    }
}
