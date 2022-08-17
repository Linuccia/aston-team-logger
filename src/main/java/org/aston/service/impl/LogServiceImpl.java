package org.aston.service.impl;

import org.aston.model.Log;
import org.aston.repository.LogRepository;
import org.aston.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class LogServiceImpl implements LogService {

    private final LogRepository logRepository;
    
    @Autowired
    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log getLog(Long id) {
        return logRepository.getById(id);
    }

    @Override
    public List<Log> getLogsByStudentId(Long studentId) {
        return logRepository.getAllByStudentId(studentId);
    }

    @Override
    public Log addLog(Log log) {
    	log.setDate(LocalDate.now());
        return logRepository.save(log);
    }

    @Override
    public Log updateLog(Log log) {
        return logRepository.update(log);
    }

    @Override
    public Log deleteLog(Long id) {
        return logRepository.deleteById(id);
    }

}
