package com.example.StorageApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TelegramController {

    @GetMapping("/")
    public String homepage()
    {
        return "homepage";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
