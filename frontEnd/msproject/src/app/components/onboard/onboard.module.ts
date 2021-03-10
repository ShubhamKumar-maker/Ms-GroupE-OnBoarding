import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from '../OnboardHome/home/home.component';
import {ViewComponent} from '../OnboardHome/view/view.component';
import {CreateComponent} from '../OnboardHome/create/create.component';
import {TrendsComponent} from '../OnboardHome/trends/trends.component';
import {NgxPaginationModule} from 'ngx-pagination';



const route: Routes = [
  { path: '', redirectTo: 'Home', pathMatch: 'full' },
  { path: 'Home', component: HomeComponent },
  { path: 'View', component: ViewComponent },
  {path:'Create', component:CreateComponent},
  {path:'Trends',component:TrendsComponent}
  
  
];

@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,NgxPaginationModule,RouterModule.forChild(route)
  ]
})
export class OnboardModule {

 }
