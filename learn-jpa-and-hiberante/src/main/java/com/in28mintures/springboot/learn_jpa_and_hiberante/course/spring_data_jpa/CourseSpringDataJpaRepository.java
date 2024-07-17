package com.in28mintures.springboot.learn_jpa_and_hiberante.course.spring_data_jpa;

import com.in28mintures.springboot.learn_jpa_and_hiberante.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
