import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileRoutingModule } from './profile-routing.module';
import { ProfileComponent } from './profile/profile.component';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HomeModule } from '../home/home.module';


@NgModule({
  declarations: [
    ProfileComponent
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule,
    AppMaterialModule,
    HomeModule
  ]
})
export class ProfileModule { }
