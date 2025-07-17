import {Component, Input} from '@angular/core';
import {CourseService} from '../../../../core/services/course/CourseService';
import {NgIf, NgOptimizedImage} from '@angular/common';

@Component({
  selector: 'app-course-card',
  imports: [
    NgOptimizedImage,
  ],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCard {
  @Input() course: any;

  constructor(private courseService: CourseService) { }

  joinCourse(courseId: number): void {
    this.courseService.joinCourse(courseId).subscribe(course => {
    })
  }

  leaveCourse(courseId: number): void {
    this.courseService.leaveCourse(courseId).subscribe(course => {})
  }
}
