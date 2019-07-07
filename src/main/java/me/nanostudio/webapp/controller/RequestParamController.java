package me.nanostudio.webapp.controller;


import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/request_param")
public class RequestParamController {

    @GetMapping("/query")
    @ResponseBody
    public Person bindWithQueryParam(@RequestParam int age,
                                     @RequestParam String name) {
        return new Person(age, name);
    }

    @PostMapping(value = "/form_data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public Person bindWithFormData(@RequestParam(required = false) Integer age,
                                   @RequestParam String name) {
        return new Person(age, name);
    }

    @GetMapping("/map")
    @ResponseBody
    public Person bindWithRequestMap(@RequestParam Map<String, String> params) {
        return new Person(Integer.parseInt(params.get("age")),
                          params.get("name"));
    }

    static class Person {
        private Integer age;
        private String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
