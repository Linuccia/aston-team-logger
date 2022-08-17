package org.aston.repository.impl;

import org.aston.model.Log;
import org.aston.repository.LogRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogRepositoryImpl implements LogRepository {
	
    private final SessionFactory sessionFactory;

    @Autowired
    public LogRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    private final SessionFactory sessionFactory;

    @Autowired
    public LogRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Log getById(Long id) {
        return sessionFactory.getCurrentSession().get(Log.class, id);
    }

    @Override
    public List<Log> getAllByStudentId(Long studentId) {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT l FROM Log l WHERE l.student.id = ?1", Log.class)
                .setParameter(1, studentId).getResultList();
    }

    @Override
    public Log save(Log log) {
        sessionFactory.getCurrentSession().save(log);
        return log;
    }

    @Override
    public Log update(Log log) {
        sessionFactory.getCurrentSession().update(log);
        return log;
    }

    @Override
    public Log deleteById(Long id) {
        Log log = sessionFactory.getCurrentSession().get(Log.class, id);
        if (log != null) {
            sessionFactory.getCurrentSession().delete(log);
        }
        return log;
    }

}
