import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrl: './toolbar.component.css'
})
export class ToolbarComponent {

  constructor(private loginService: LoginService, private router: Router) { }

  onLogoutClick() {
    this.loginService.activeUser = null;
    this.loginService.signedIn = false;

    this.router.navigate(["/login"]);
  }

  onProfileClick() {
    this.router.navigate(["/profile"]);
  }

  onNewProgramClick() {
    this.router.navigate(["/new-program"]);
  }

  onProgramsClick() {
    this.router.navigate(["/programs"]);
  }

  onHomeClick() {
    this.router.navigate(["home"]);
  }

  onConsultingClick() {
    this.router.navigate(["consulting"]);
  }
}
