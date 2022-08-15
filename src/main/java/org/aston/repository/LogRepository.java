package org.aston.repository;

import org.aston.model.Log;

import java.util.List;

public interface LogRepository {

    Log getById(Long id);

    List<Log> getAllByStudentId(Long studentId);

    Log save(Log log);

    Log update(Log log);

    Log deleteById(Long id);

}
