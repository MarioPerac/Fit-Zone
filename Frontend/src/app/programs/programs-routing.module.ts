import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProgramComponent } from '../home/program/program.component';
import { ProgramsComponent } from './programs/programs.component';

const routes: Routes = [
  {
    path: '',
    component: ProgramsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProgramsRoutingModule { }
