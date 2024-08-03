import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProgramDetailsComponent } from './program-details/program-details.component';

const routes: Routes = [
  {
    path: '',
    component: ProgramDetailsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProgramRoutingModule { }
