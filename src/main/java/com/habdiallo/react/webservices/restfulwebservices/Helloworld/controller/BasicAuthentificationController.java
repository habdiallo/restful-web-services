package com.habdiallo.react.webservices.restfulwebservices.Helloworld.controller;

import com.habdiallo.react.webservices.restfulwebservices.Helloworld.model.AuthentificationBean;
import org.springframework.web.bind.annotation.*;

//Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthentificationController {
    @GetMapping(path = "/basicauth")
    public AuthentificationBean HelloWorldBean(){
        return new AuthentificationBean("You are authenticated");
    }
}
