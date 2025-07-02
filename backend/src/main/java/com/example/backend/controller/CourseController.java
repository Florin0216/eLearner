package com.example.backend.controller;

import com.example.backend.model.Course;
import com.example.backend.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses() {
        List<Course> allCourses = courseService.findAllCourses();
        return ResponseEntity.ok(allCourses);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        Course newCourse = courseService.createCourse(course);
        return ResponseEntity.ok(newCourse);
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinCourse(@RequestParam Long courseId, @RequestParam Long userId) {
        courseService.addUserToCourse(courseId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/leave")
    public ResponseEntity<?> leaveCourse(@RequestParam Long courseId, @RequestParam Long userId) {
        courseService.removeUserFromCourse(courseId, userId);
        return ResponseEntity.ok().build();
    }

}
