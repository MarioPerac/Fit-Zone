import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewProgramRoutingModule } from './new-program-routing.module';
import { NewProgramComponent } from './new-program/new-program.component';
import { FormsModule } from '@angular/forms';
import { AppMaterialModule } from '../app-material/app-material.module';


@NgModule({
  declarations: [
    NewProgramComponent
  ],
  imports: [
    CommonModule,
    NewProgramRoutingModule,
    FormsModule,
    AppMaterialModule
  ]
})
export class NewProgramModule { }
