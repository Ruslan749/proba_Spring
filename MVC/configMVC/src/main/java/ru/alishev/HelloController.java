package ru.alishev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Neil Alishev
 */
@Controller
public class HelloController {
    @GetMapping("/hello-world")
    public String sayHello() {
        return "index";
    }
}
