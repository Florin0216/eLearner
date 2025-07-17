package com.example.backend.service;

import com.example.backend.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> findAllCourses();

    void addUserToCourse(Long courseId, String username);

    void removeUserFromCourse(Long courseId, String username);
}
