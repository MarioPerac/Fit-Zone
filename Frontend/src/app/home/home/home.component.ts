import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program.model';
import { ProgramService } from '../../services/program/program.service';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  programs!: Program[];

  constructor(private programService: ProgramService, private router: Router, private loginService: LoginService) { }

  ngOnInit() {
    this.programService.getPrograms().subscribe(
      {
        next: (programs: Program[]) => {
          this.programs = programs;
        }
      }
    );
  }



  openDetails(program: Program) {
    this.router.navigate(["/program", program.id], { state: { program } });
  }

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
}
