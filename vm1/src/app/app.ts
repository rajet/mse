import { Component } from '@angular/core';
import { Tabs } from './tabs/tabs';

@Component({
  selector: 'app-root',
  imports: [Tabs],
  templateUrl: './app.html',
  styleUrl: './app.scss',
})
export class App {}
