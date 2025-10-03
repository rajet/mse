import { Component } from '@angular/core';
import { MatTab, MatTabGroup } from '@angular/material/tabs';
import { Authentication } from '../authentication/authentication';
import { Persistence } from '../persistence/persistence';
import { Functions } from '../functions/functions';

@Component({
  selector: 'app-tabs',
  imports: [MatTabGroup, MatTab, Authentication, Persistence, Functions],
  templateUrl: './tabs.html',
  styleUrl: './tabs.scss',
})
export class Tabs {}
