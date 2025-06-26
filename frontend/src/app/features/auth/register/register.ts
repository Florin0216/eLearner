import { Component } from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {Router, RouterLink} from '@angular/router';
import {Auth} from '../../../core/service/auth';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [
    NgOptimizedImage,
    FormsModule,
    RouterLink
  ],
  templateUrl: './register.html',
  styleUrl: './register.css'
})
export class Register {
  data: any = {username: '', password: '', email: '',};

  constructor(private auth: Auth, private router: Router) {}

  register() {
    this.auth.register(this.data).subscribe(()  => {
      this.router.navigate(['/login'])
    });
  }
}
