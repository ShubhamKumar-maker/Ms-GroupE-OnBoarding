import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from '../OnboardHome/home/home.component';
import {ViewComponent} from '../OnboardHome/view/view.component';
import {CreateComponent} from '../OnboardHome/create/create.component';
import {TrendsComponent} from '../OnboardHome/trends/trends.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UpdateComponent } from  '../OnboardHome/update/update/update.component';
import { ChartsModule } from 'ng2-charts';



const route: Routes = [
  { path: '', redirectTo: 'Home', pathMatch: 'full' },
  { path: 'Home', component: HomeComponent },
  { path: 'View', component: ViewComponent },
  {path:'Create', component:CreateComponent},
  {path:'Trends',component:TrendsComponent},
  {path:'Update',component:UpdateComponent}
  
  
];

@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,ChartsModule,NgxPaginationModule,ReactiveFormsModule,FormsModule,RouterModule.forChild(route)
  ]
})
export class OnboardModule {

 }
