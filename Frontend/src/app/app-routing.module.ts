import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardService } from './services/guard.service';

const routes: Routes = [
  {
    path: 'login',
    loadChildren: () => import('./login/login.module').then(mod => mod.LoginModule)

  },
  {
    path: "signup",
    loadChildren: () => import('./signup/signup.module').then(mod => mod.SignupModule)
  },
  {
    path: "new-program",
    loadChildren: () => import('./new-program/new-program.module').then(mod => mod.NewProgramModule),
    canActivate: [GuardService]
  }
  ,
  {

    path: "home",
    loadChildren: () => import('./home/home.module').then(mod => mod.HomeModule),
    canActivate: [GuardService]
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
