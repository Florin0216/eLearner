import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Navbar} from './core/components/navbar/navbar';
import {MainLayout} from './core/layout/main-layout/main-layout';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, MainLayout],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontend';
}
