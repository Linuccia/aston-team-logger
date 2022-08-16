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

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/{id}")
    public Log getLog(@PathVariable Long id) {
        return logService.getLog(id);
    }

    @GetMapping
    public List<Log> getLogsByStudentId(@PathVariable Long studentId) {
        return logService.getLogsByStudentId(studentId);
    }

    @PostMapping
    public Log addLog(@PathVariable Long studentId, @RequestBody Log log) {
        return logService.addLog(studentId, log);
    }

    @PutMapping("/{studentId}")
    public Log updateLog(@PathVariable Long studentId, @RequestBody Log log) {
        return logService.updateLog(studentId, log);
    }
}
