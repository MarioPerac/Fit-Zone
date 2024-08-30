import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RssFeedRoutingModule } from './rss-feed-routing.module';
import { RssFeedComponent } from './rss-feed/rss-feed.component';
import { HomeModule } from '../home/home.module';
import { AppMaterialModule } from '../app-material/app-material.module';


@NgModule({
  declarations: [
    RssFeedComponent
  ],
  imports: [
    CommonModule,
    RssFeedRoutingModule,
    HomeModule,
    AppMaterialModule
  ]
})
export class RssFeedModule { }
