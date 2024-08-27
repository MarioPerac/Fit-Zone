import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ConsultingRoutingModule } from './consulting-routing.module';
import { ConsultingComponent } from './consulting/consulting.component';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HomeModule } from '../home/home.module';


@NgModule({
  declarations: [
    ConsultingComponent
  ],
  imports: [
    CommonModule,
    ConsultingRoutingModule,
    AppMaterialModule,
    HomeModule
  ]
})
export class ConsultingModule { }
