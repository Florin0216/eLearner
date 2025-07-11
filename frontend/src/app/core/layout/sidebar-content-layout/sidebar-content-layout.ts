import { Component } from '@angular/core';
import {Navbar} from '../../components/navbar/navbar';
import {Sidebar} from '../../components/sidebar/sidebar';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-sidebar-content-layout',
  imports: [
    Navbar,
    Sidebar,
    RouterOutlet
  ],
  templateUrl: './sidebar-content-layout.html',
  styleUrl: './sidebar-content-layout.css'
})
export class SidebarContentLayout {

}
