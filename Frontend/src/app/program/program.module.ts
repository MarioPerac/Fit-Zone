import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProgramRoutingModule } from './program-routing.module';
import { ProgramDetailsComponent } from './program-details/program-details.component';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HomeModule } from '../home/home.module';


@NgModule({
  declarations: [
    ProgramDetailsComponent
  ],
  imports: [
    CommonModule,
    ProgramRoutingModule,
    AppMaterialModule,
    HomeModule
  ],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class ProgramModule { }
