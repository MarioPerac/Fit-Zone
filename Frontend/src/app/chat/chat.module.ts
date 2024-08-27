import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChatRoutingModule } from './chat-routing.module';
import { ChatComponent } from './chat/chat.component';
import { AppMaterialModule } from '../app-material/app-material.module';
import { HomeModule } from '../home/home.module';


@NgModule({
  declarations: [
    ChatComponent
  ],
  imports: [
    CommonModule,
    ChatRoutingModule,
    AppMaterialModule,
    HomeModule
  ]
})
export class ChatModule { }
