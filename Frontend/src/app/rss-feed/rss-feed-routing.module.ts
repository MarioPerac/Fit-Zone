import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RssFeedComponent } from './rss-feed/rss-feed.component';

const routes: Routes = [
  {
    path: '',
    component: RssFeedComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RssFeedRoutingModule { }
