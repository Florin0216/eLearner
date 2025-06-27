import {Component} from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {Auth} from '../../../core/services/auth/auth';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [
    NgOptimizedImage,
    FormsModule,
    RouterLink,
  ],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  credentials: any = {username: '', password: ''};

  constructor(private auth: Auth, private router: Router) {
  }

  login() {
    this.auth.login(this.credentials)
      .subscribe(res => {
        localStorage.setItem('accessToken', res.accessToken);
        localStorage.setItem('refreshToken', res.refreshToken);
        this.router.navigate(['/home'])
      });
  }

}
