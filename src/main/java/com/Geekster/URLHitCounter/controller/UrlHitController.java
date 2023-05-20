package com.Geekster.URLHitCounter.controller;

import com.Geekster.URLHitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {

    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("count")
    public ResponseEntity<Integer> getHitCount() {
        int hitCount = urlHitService.getHitCount();
        return ResponseEntity.ok(hitCount);
    }

    @GetMapping("username/{username}/count")
    public Map<String, Object> getHitCount(@PathVariable String username) {
        return urlHitService.getHitCount(username);
    }
}

