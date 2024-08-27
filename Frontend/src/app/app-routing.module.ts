import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardService } from './services/guard/guard.service';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
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
    loadChildren: () => import('./new-program/new-program.module').then(mod => mod.NewProgramModule)
  }
  ,
  {
    path: "home",
    loadChildren: () => import('./home/home.module').then(mod => mod.HomeModule),
    // canActivate: [GuardService]
  },
  {
    path: "program/:id",
    loadChildren: () => import('./program/program.module').then(mod => mod.ProgramModule),
  },
  {
    path: "profile",
    loadChildren: () => import('./profile/profile.module').then(mod => mod.ProfileModule),
  },
  {
    path: "programs",
    loadChildren: () => import('./programs/programs.module').then(mod => mod.ProgramsModule)
  },
  {
    path: "consulting",
    loadChildren: () => import('./consulting/consulting.module').then(mod => mod.ConsultingModule)
  },
  {
    path: "chats",
    loadChildren: () => import('./chat/chat.module').then(mod => mod.ChatModule)
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
