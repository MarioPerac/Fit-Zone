import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home/home.component';
import { ProgramComponent } from './program/program.component';
import { AppMaterialModule } from '../app-material/app-material.module';


@NgModule({
  declarations: [
    HomeComponent,
    ProgramComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    AppMaterialModule
  ]
})
export class HomeModule { }