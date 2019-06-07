import { Routes } from '@angular/router';
import { BemComponent } from './bem/bem.component';
import { HomeComponent } from './home/home.component';

export const ROUTES: Routes = [
  {path: '', component: HomeComponent},
  {path: 'bem', component: BemComponent},
];