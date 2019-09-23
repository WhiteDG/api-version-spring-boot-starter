/*
 * Copyright 2019
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.github.whitedg.web.v1;

import com.github.whitedg.annotation.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author White
 */
@ApiVersion(1)
@RestController
public class TestController {

    @GetMapping("foo1")
    public String foo1() {
        return "方法没有注解使用类注解";
    }

    @GetMapping("foo2")
    public String foo2() {
        return "方法有注解使用方法注解";
    }

}
