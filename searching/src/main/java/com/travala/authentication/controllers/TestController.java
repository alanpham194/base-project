package com.travala.authentication.controllers;

import commons.dto.ResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class TestController {
    @RequestMapping
    public Object testController() {
        return new ResponseDTO();
    }
}
