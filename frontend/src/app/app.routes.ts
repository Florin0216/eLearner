import {RouterModule, Routes} from '@angular/router';
import {Login} from './features/auth/login/login';
import {Register} from './features/auth/register/register';
import {NgModule} from '@angular/core';
import {Home} from './features/home/home';
import {Test} from './features/test/test/test';
import {authGuard} from './core/guards/auth/auth-guard';

export const routes: Routes = [
  { path: 'login', component: Login , canActivate: [authGuard]},
  { path: 'register', component: Register, canActivate: [authGuard] },
  { path: 'home', component: Home },
  { path: 'test', component: Test },
  { path: '', pathMatch: 'full', redirectTo: '/home' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
