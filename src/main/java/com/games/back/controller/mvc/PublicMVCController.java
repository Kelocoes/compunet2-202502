package com.games.back.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mvc/public")
public class PublicMVCController {
    
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
