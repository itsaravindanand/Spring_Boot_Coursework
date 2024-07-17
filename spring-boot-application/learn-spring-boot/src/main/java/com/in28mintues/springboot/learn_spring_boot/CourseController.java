package com.in28mintues.springboot.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


//Build a rest API
//Create an API for returning the Course with ID, name and author
@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "Learn AWS", "in28minutes"),
                new Course(2, "Learn DevOps", "in28minutes"),
                new Course(3, "Learn Azure", "in28minutes"),
                new Course(4, "Learn GCP", "in28minutes"),
                new Course(5, "Learn GCP", "in28minutes"),
                new Course(7, "Learn Kubernetes", "in28minutes")
        );
    }
}
