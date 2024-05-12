package com.dat.repository.impl;

import com.dat.pojo.Course;
import com.dat.pojo.Teacher;
import com.dat.pojo.User;
import com.dat.repository.TeacherRepository;
import org.hibernate.Session;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class TeacherRepositoryImpl
        extends BaseRepositoryImpl<Teacher, Integer>
        implements TeacherRepository {

    public TeacherRepositoryImpl(LocalSessionFactoryBean factory, Environment env) {
        super(factory, env);
    }

    @Override
    protected Integer getId(Teacher teacher) {
        return teacher.getId();
    }

    @Override
    protected List<Predicate> filterByParams(Map<String, String> params, CriteriaBuilder b, Root<User> root) {
        return null;
    }

    @Override
    public List<Teacher> getAll() {
        Session s = factory.getObject().openSession();
        return s.createQuery("SELECT t FROM Teacher t", Teacher.class).list();
    }
}