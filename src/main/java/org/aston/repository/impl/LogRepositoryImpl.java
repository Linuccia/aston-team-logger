package org.aston.repository.impl;

import org.aston.model.Log;
import org.aston.repository.LogRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogRepositoryImpl implements LogRepository {

    @Override
    public Log getById(Long id) {
        return null;
    }

    @Override
    public List<Log> getAllByStudentId(Long studentId) {
        return null;
    }

    @Override
    public Log save(Log log) {
        return null;
    }

    @Override
    public Log update(Log log) {
        return null;
    }

    @Override
    public Log deleteById(Long id) {
        return null;
    }

}
