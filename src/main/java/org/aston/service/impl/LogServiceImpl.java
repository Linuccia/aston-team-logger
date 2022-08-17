package org.aston.service.impl;

import org.aston.model.Log;
import org.aston.repository.LogRepository;
import org.aston.repository.StudentRepository;
import org.aston.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository, StudentRepository studentRepository) {
        this.logRepository = logRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Log getLog(Long id, Long studentId) {
        return null;
    }

    @Override
    public List<Log> getLogsByStudentId(Long studentId) {
        return null;
    }

    @Override
    public Log addLog(Long studentId, Log log) {
        return null;
    }

    @Override
    public Log updateLog(Long studentId, Long id, Log log) {
        return null;
    }

    @Override
    public Log deleteLog(Long id) {
        return null;
    }

}
