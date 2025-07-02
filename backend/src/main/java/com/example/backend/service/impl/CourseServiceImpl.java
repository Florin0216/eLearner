package com.example.backend.service.impl;

import com.example.backend.model.Course;
import com.example.backend.model.User;
import com.example.backend.repository.CourseRepository;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseServiceImpl(CourseRepository courseRepository,  UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }


    public Course createCourse(Course course) {
        course.setCreationDate(LocalDate.now());
         return courseRepository.save(course);
    }

    public void addUserToCourse(Long courseId, Long userId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        course.getUsers().add(user);
        user.getCourses().add(course);

        courseRepository.save(course);
    }

    public void removeUserFromCourse(Long courseId, Long userId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        course.getUsers().remove(user);
        user.getCourses().remove(course);

        courseRepository.save(course);
    }
}
