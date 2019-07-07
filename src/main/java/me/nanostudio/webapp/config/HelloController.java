package me.nanostudio.webapp.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.nanostudio.webapp.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private HelloService helloService;

    @GetMapping
    public String hello() {
        return "Hello," + helloService.getMyName();
    }

    @PostMapping("/greeting")
    public Greeting greeting(HttpServletRequest request, @RequestParam Integer id, @RequestParam("name") String guestName){


        return new Greeting(id, guestName);
    }

    class Greeting {
        private Integer id;
        private String to;
        private final String nothing = "helloWorld";

        public Greeting(Integer id, String to) {
            this.id = id;
            this.to = to;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }
    }
}
