package org.aston.service;


import org.aston.model.Log;

import java.util.List;

public interface LogService {

    Log getLog(Long id, String studentId);

    List<Log> getLogsByStudentId(Long studentId);

    Log addLog(Long studentId, Log log);

    Log updateLog(Long studentId, Long id, Log log);

    Log deleteLog(Long id);

}
