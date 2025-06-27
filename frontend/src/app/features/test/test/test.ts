import {Component, OnInit} from '@angular/core';
import {TestService} from '../../../core/services/test/test-service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-test',
  imports: [],
  templateUrl: './test.html',
  styleUrl: './test.css'
})
export class Test implements OnInit {
  message: string = '';

  constructor(private testService: TestService) { }

  ngOnInit(): void {
    this.testService.getTest().subscribe({
      next: (res) => this.message = res,
      error: (err: HttpErrorResponse) => {
        this.message = `Error ${err.status}: ${err.message}`;
      }
    });
  }
}
