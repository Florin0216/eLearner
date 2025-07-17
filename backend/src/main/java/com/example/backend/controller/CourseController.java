package com.example.backend.controller;

import com.example.backend.model.Course;
import com.example.backend.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public ResponseEntity<?> joinCourse(@RequestParam Long courseId, Principal principal) {
        courseService.addUserToCourse(courseId, principal.getName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/leave")
    public ResponseEntity<?> leaveCourse(@RequestParam Long courseId, Principal principal) {
        courseService.removeUserFromCourse(courseId, principal.getName());
        return ResponseEntity.ok().build();
    }

}
