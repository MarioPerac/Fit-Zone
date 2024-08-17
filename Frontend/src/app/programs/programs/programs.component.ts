import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Route, Router } from '@angular/router';
import { Program } from '../../models/program.model';
import { UserService } from '../../services/user/user.service';

@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrl: './programs.component.css'
})
export class ProgramsComponent implements OnInit {

  myPrograms!: Program[];
  constructor(private loginService: LoginService, private userService: UserService, private router: Router) {

  }

  ngOnInit() {
    this.userService.getUserPrograms(this.loginService.activeUser!.username).subscribe({
      next: (programs: Program[]) => {
        console.log(programs.length);
        this.myPrograms = programs;
      }
    });
  }
}

