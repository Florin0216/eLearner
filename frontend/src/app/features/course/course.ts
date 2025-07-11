import {Component, OnInit} from '@angular/core';
import {CourseService} from '../../core/services/course/CourseService';
import {CourseCard} from './components/course-card/course-card';

@Component({
  selector: 'app-course',
  imports: [
    CourseCard,
  ],
  templateUrl: './course.html',
  styleUrl: './course.css'
})
export class Course implements OnInit {
  courses: any[] = [];

  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.loadCourses();
  }

  loadCourses(): void {
    this.courseService.getCourses().subscribe(courses => {
      this.courses = courses;
    })
  }

}
