package org.aston.service.impl;

import org.aston.model.Log;
import org.aston.repository.LogRepository;
import org.aston.repository.StudentRepository;
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
    private final StudentRepository studentRepository;

    @Autowired
    public LogServiceImpl(LogRepository logRepository, StudentRepository studentRepository) {
        this.logRepository = logRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Log getLog(Long id) {
        Log log = logRepository.getById(id);
        return log != null ? log : new Log();
    }

    @Override
    public List<Log> getLogsByStudentId(Long studentId) {
        return logRepository.getAllByStudentId(studentId);
    }

    @Override
    public Log addLog(Long studentId, Log log) {
        log.setStudent(studentRepository.getById(studentId));
        log.setDate(LocalDate.now());
        return logRepository.save(log);
    }

    @Override
    public Log updateLog(Long id, Log log) {
        Log updated = logRepository.getById(id);
        if (updated != null) {
            updated.setMessage(log.getMessage());
            return logRepository.update(updated);
        }
        return new Log();
    }

    @Override
    public Log deleteLog(Long id) {
        Log log = logRepository.getById(id);
        return log != null ? logRepository.deleteById(id) : new Log();
    }

}
