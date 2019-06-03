package com.abevilacqua.techstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @GetMapping("/")
    public ResponseEntity helloStore() {
        return new ResponseEntity<>("Hey there from TechStore!!!", HttpStatus.OK);
    }
}
