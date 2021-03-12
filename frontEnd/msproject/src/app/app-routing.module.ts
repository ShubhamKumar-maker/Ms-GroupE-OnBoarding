import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from './components/login/login.component';
import {HomeComponent} from './components/home/home.component';
import {OnboardModule} from './components/onboard/onboard.module'

const routes: Routes = [
  {path:"", redirectTo:'Login', pathMatch:'full'},
  { path: 'Login', component: LoginComponent },
  { path: 'Home', component: HomeComponent },
  {path:'Onboard',loadChildren: () =>  OnboardModule}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
