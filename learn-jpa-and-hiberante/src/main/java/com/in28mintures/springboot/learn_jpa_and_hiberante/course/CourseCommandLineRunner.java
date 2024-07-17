package com.in28mintures.springboot.learn_jpa_and_hiberante.course;

import com.in28mintures.springboot.learn_jpa_and_hiberante.course.jpa.CourseJpaRepository;
import com.in28mintures.springboot.learn_jpa_and_hiberante.course.spring_data_jpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    //The JDBC Repository Object
//    @Autowired
//    private CourseJdbcRepository repository;

    //The JPA Repository Object
//    @Autowired
//    private CourseJpaRepository repository;

    //The Spring data JPA Repository object
    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //save, deleteById and findById are database operations available in the Spring JPA.
        //findByAuthor and findByName are custom database operations created in the CourseSpringDataJpaRepository file
        repository.save(new Course(1, "Learn AWS JPA", "in28minutes"));
        repository.save(new Course(2, "Learn Azure JPA", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps JPA", "in28minutes"));
        repository.deleteById(3l);
        System.out.println(repository.findById(1l));
        System.out.println(repository.findById(2l));
        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));
        System.out.println(repository.findByName("Learn AWS"));
        //JDBC: This will throw error: org.springframework.dao.EmptyResultDataAccessException: Incorrect result size: expected 1, actual 0
//        System.out.println(repository.SelectQueryById(3));
    }
}
