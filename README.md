# api-version-spring-boot-starter

在用 SpringBoot 开发 RESTful API 时，如果你的 API 版本控制是在 url 中完成的，那么现在你可以尝试使用 ```@ApiVersion``` 注解帮你完成这项工作。

## ```@ApiVersion``` 功能特性

- 支持在类或者方法上使用
    - 优先级：方法 > 类
    - 如果同时在类和方法上都加上了 ```@ApiVersion```,那么方法上指定的版本号会生效
- 同个类或方法支持多版本同时生效
    - ```@ApiVersion``` 的参数是数组，可以同时配置多个版本，例如 ```@ApiVersion({1,2})```，这样配置之后通过 v1 或者 v2 都可以访问。
- 可配置前缀、后缀
    - 默认前缀是 ‘v’，可以通过配置项 ```api-version.prefix``` 修改前缀。
    - 默认不带后缀，可以通过配置项```api-version.suffix```修改后缀。
- 使用方便，只需要一个注解


## 使用步骤
1. 引入依赖
    - maven
    ```xml
    <dependency>
    	<groupId>io.github.whitedg</groupId>
    	<artifactId>api-version-spring-boot-starter</artifactId>
    	<version>1.1</version>
    </dependency>
    ```
    - Gradle
    ```
    compile group: 'io.github.whitedg', name: 'api-version-spring-boot-starter', version: '1.1'
    ```

2. 使用 ```@ApiVersion``` 注解


```java

@ApiVersion(1)
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

    @GetMapping("foo3")
    @ApiVersion({1, 2})
    public String foo3() {
        return "注解支持多版本";
    }
}
```

3. 完成

## swagger2 文档展示

![image](https://github.com/WhiteDG/api-version-spring-boot-starter/blob/develop/image/swagger-ui2.jpg)

## Demo 测试
1. 下载源码
2. 启动 AppTestApplication
3. curl 调用接口测试，调用结果如下
``` bash
$ curl http://localhost:9090/foo
不使用版本注解%

$ curl http://localhost:9090/foo1
{"timestamp":"2019-08-03T09:34:45.621+0000","status":404,"error":"Not Found","message":"No message available","path":"/foo1"}%

$ curl http://localhost:9090/v1/foo1
方法没有注解使用类注解%

$ curl http://localhost:9090/v2/foo2
方法有注解使用方法注解%

$ curl http://localhost:9090/v1/foo3
注解支持多版本%

$ curl http://localhost:9090/v2/foo3
注解支持多版本%
```

## LICENSE
```
Copyright 2019 WhiteDG

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```