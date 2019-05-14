package com.whis.two.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by whis on 2019-05-14
 */
@FeignClient(value = "eureka-client-one")
public interface TestFeignService {

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    String test(@RequestParam("name") String name);


}
