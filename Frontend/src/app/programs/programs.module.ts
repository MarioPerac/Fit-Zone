import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProgramsRoutingModule } from './programs-routing.module';
import { ProgramsComponent } from './programs/programs.component';
import { AppMaterialModule } from '../app-material/app-material.module';
import { ToolbarComponent } from '../home/toolbar/toolbar.component';
import { MatTabsModule } from '@angular/material/tabs';
import { HomeModule } from '../home/home.module';
import { MyProgramsComponent } from './my-programs/my-programs.component';
import { ActiveProgramsComponent } from './active-programs/active-programs.component';
import { FinishedProgramsComponent } from './finished-programs/finished-programs.component';


@NgModule({
  declarations: [
    ProgramsComponent,
    MyProgramsComponent,
    MyProgramsComponent,
    ActiveProgramsComponent,
    FinishedProgramsComponent
  ],
  imports: [
    CommonModule,
    ProgramsRoutingModule,
    AppMaterialModule,
    MatTabsModule,
    HomeModule
  ]
})
export class ProgramsModule { }
