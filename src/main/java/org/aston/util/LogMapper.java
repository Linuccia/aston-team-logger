package org.aston.util;

import org.aston.dto.request.LogRequestDTO;
import org.aston.dto.response.LogResponseDTO;
import org.aston.model.Log;
import org.springframework.stereotype.Component;

@Component
public class LogMapper {

    public LogResponseDTO toDto(Log log) {
        return new LogResponseDTO(log.getDate(), log.getMessage());
    }

    public Log toLog(LogRequestDTO logDto) {
        Log log = new Log();
        log.setMessage(logDto.getMessage());
        return log;
    }

}
