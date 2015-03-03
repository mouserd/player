package com.pixelus.player;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    @RequestMapping("/hello")
    String home() {
        return "Hello World!";
    }
}
