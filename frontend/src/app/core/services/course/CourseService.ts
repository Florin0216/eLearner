import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  private baseUrl = 'http://localhost:8080/api/course';

  constructor(private http: HttpClient) {
  }

  getCourses(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  joinCourse(courseId: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/join?courseId=${courseId}`, {});
  }

  leaveCourse(courseId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/leave?courseId=${courseId}`, {});
  }

}
