import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardService } from './services/guard/guard.service';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
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
  },
  {
    path: "program/:id",
    loadChildren: () => import('./program/program.module').then(mod => mod.ProgramModule),
  },
  {
    path: "profile",
    loadChildren: () => import('./profile/profile.module').then(mod => mod.ProfileModule),
    canActivate: [GuardService]
  },
  {
    path: "programs",
    loadChildren: () => import('./programs/programs.module').then(mod => mod.ProgramsModule),
    canActivate: [GuardService]
  },
  {
    path: "consulting",
    loadChildren: () => import('./consulting/consulting.module').then(mod => mod.ConsultingModule),
    canActivate: [GuardService]
  },
  {
    path: "chats",
    loadChildren: () => import('./chats/chats.module').then(mod => mod.ChatsModule),
    canActivate: [GuardService]
  },
  {
    path: "chat/:username/with/:friend",
    loadChildren: () => import('./chat/chat.module').then(mod => mod.ChatModule),
    canActivate: [GuardService]
  },
  {
    path: "rss-feed",
    loadChildren: () => import('./rss-feed/rss-feed.module').then(mod => mod.RssFeedModule)
  },
  {
    path: "exercises",
    loadChildren: () => import('./exercise/exercise.module').then(mod => mod.ExerciseModule)
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
