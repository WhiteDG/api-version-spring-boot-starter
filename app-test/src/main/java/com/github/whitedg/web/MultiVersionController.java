package com.github.whitedg.web;

import com.github.whitedg.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author White
 */
@RestController
public class MultiVersionController {

    @GetMapping("foo3")
    @ApiVersion({1, 2})
    public String foo3() {
        return "注解支持多版本";
    }
}
