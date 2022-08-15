package org.aston.controller;

import org.aston.model.Log;
import org.aston.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/logs")
public class LogController {

    private final LogService service;

    @Autowired
    public LogController(LogService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Log getLog(@PathVariable Long id) {
        return null;
    }

    @GetMapping
    public List<Log> getLogs(@PathVariable Long studentId) {
        return null;
    }

    @PostMapping
    public Log addLog(@PathVariable Long studentId, @RequestBody Log log) {
        return null;
    }

    @PutMapping("/{id}")
    public Log updateLog(@PathVariable Long id, @RequestBody Log log) {
        return null;
    }


}
