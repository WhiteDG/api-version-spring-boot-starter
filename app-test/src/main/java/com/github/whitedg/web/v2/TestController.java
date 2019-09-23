package com.github.whitedg.web.v2;

import com.github.whitedg.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author White
 */
@ApiVersion(2)
@RestController
public class TestController {

    @GetMapping("foo1")
    public String foo1() {
        return "方法没有注解使用类注解";
    }

    @GetMapping("foo2")
    @ApiVersion(2)
    public String foo2() {
        return "方法有注解使用方法注解";
    }

}
