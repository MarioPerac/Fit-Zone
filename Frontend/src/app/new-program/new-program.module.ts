import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewProgramRoutingModule } from './new-program-routing.module';
import { NewProgramComponent } from './new-program/new-program.component';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
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
