package com.whis.client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ProductController
 * @description:
 * @author: whis
 * @create: 2020-04-26 09:47
 **/
@RestController
@RequestMapping("product/1")
public class ProductController {

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list() {
        return "productList";
    }
}
