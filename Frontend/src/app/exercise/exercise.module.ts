import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ExerciseRoutingModule } from './exercise-routing.module';
import { ExerciseComponent } from './exercise/exercise.component';
import { HomeModule } from '../home/home.module';
import { AppMaterialModule } from '../app-material/app-material.module';


@NgModule({
  declarations: [
    ExerciseComponent
  ],
  imports: [
    CommonModule,
    ExerciseRoutingModule,
    HomeModule,
    AppMaterialModule
  ]
})
export class ExerciseModule { }
