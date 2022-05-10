package com.TherapistFinder.TherapistFinder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/visitor")
public class VisitorControl {

    @GetMapping("/test")
    public ResponseEntity<String> helloVisitor(){
        return ResponseEntity.ok("Hello Visitor");
    }
}
