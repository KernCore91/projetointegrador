import { Routes } from '@angular/router';
import { BemComponent } from './bem/bem.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

export const ROUTES: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'bem', component: BemComponent},
  {path: '**', component: LoginComponent}
];
