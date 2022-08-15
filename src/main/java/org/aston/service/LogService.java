package org.aston.service;


import org.aston.model.Log;

import java.util.List;

public interface LogService {

    Log getLog(Long id);

    List<Log> getLogsByStudentId(Long studentId);

    Log addLog(Log log);

    Log updateLog(Log log);

    Log deleteLog(Long id);

}
