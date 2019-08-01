package io.github.whitedg.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author White
 */
@RestController
public class NoVersionController {

    @GetMapping("foo")
    public String foo() {
        return "不使用版本注解";
    }
}
