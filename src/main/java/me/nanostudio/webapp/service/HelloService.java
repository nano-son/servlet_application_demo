package me.nanostudio.webapp.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getMyName() {
        return "nanoStudio";
    }
}
