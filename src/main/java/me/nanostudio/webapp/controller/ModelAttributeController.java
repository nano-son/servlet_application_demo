package me.nanostudio.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/model_attr")
public class ModelAttributeController {

    @GetMapping("/path/{age}/{name}")
    @ResponseBody
    public Person bindWithPath(@ModelAttribute Person person) {
        return person;
    }

    @GetMapping("/query")
    @ResponseBody
    public Person bindWithQueryParam(@ModelAttribute Person person) {
        return person;
    }

    @PostMapping("/form_data")
    @ResponseBody
    public Person bindWithForm(@ModelAttribute Person person) {
        return person;
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
