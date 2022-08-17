package org.aston.service.impl;

import org.aston.model.Log;
import org.aston.repository.LogRepository;
import org.aston.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    
    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    @Transactional
    public Log getLog(Long id) {
        return logRepository.getById(id);
    }

    @Override
    @Transactional
    public List<Log> getLogsByStudentId(Long studentId) {
        return logRepository.getAllByStudentId(studentId);
    }

    @Override
    @Transactional
    public Log addLog(Log log) {
        return logRepository.save(log);
    }

    @Override
    @Transactional
    public Log updateLog(Log log) {
        return logRepository.update(log);
    }

    @Override
    @Transactional
    public Log deleteLog(Long id) {
        return logRepository.deleteById(id);
    }

}
