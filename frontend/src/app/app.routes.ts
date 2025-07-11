import {RouterModule, Routes} from '@angular/router';
import {Login} from './features/auth/login/login';
import {Register} from './features/auth/register/register';
import {NgModule} from '@angular/core';
import {Home} from './features/home/home';
import {Test} from './features/test/test/test';
import {authGuard} from './core/guards/auth/auth-guard';
import {Course} from './features/course/course';
import {MainLayout} from './core/layout/main-layout/main-layout';
import {SidebarContentLayout} from './core/layout/sidebar-content-layout/sidebar-content-layout';

export const routes: Routes = [
  {path: '',
    component: SidebarContentLayout,
    children: [
      { path: 'courses', component: Course },
      { path: 'test', component: Test },
    ]
  },
  {
    path: '',
    component:  MainLayout,
    children: [
      { path: 'home', component: Home },
      { path: 'login', component: Login, canActivate: [authGuard] },
      { path: 'register', component: Register, canActivate: [authGuard] }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
