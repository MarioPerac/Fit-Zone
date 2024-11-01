import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home/home.component';
import { ProgramComponent } from './program/program.component';
import { AppMaterialModule } from '../app-material/app-material.module';
import { ToolbarComponent } from './toolbar/toolbar.component';


@NgModule({
  declarations: [
    HomeComponent,
    ProgramComponent,
    ToolbarComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    AppMaterialModule
  ],
  exports: [ToolbarComponent]
})
export class HomeModule { }
