import { Component } from '@angular/core';
import {Navbar} from '../../components/navbar/navbar';
import {RouterOutlet} from '@angular/router';
import {Footer} from '../../components/footer/footer';
import {Sidebar} from '../../components/sidebar/sidebar';

@Component({
  selector: 'app-main-layout',
  imports: [
    Navbar,
    RouterOutlet,
    Footer,
  ],
  templateUrl: './main-layout.html',
  styleUrl: './main-layout.css'
})
export class MainLayout {

}
