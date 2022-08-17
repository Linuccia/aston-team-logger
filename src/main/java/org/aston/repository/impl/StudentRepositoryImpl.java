package org.aston.repository.impl;

import org.aston.model.Student;
import org.aston.repository.StudentRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getById(Long id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
       // return session.createQuery("SELECT a FROM Student a", Student.class).list();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        criteriaQuery.from(Student.class);
        return session.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Student save(Student student) {
        sessionFactory.getCurrentSession().save(student);
        return student;
    }

    @Override
    public Student deleteById(Long id) {
        Student student = sessionFactory.getCurrentSession().get(Student.class, id);
        if (student != null) {
            sessionFactory.getCurrentSession().delete(student);
        }
        return student;
    }

}
