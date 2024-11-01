import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { Route, Router } from '@angular/router';
import { Program } from '../../models/program.model';
import { UserService } from '../../services/user/user.service';
import { Comment } from '../../models/comment.model';


@Component({
  selector: 'app-programs',
  templateUrl: './programs.component.html',
  styleUrl: './programs.component.css'
})
export class ProgramsComponent implements OnInit {

  myPrograms!: Program[];
  comments: Comment[] = [];
  activePrograms!: Program[];
  finishedPrograms!: Program[];
  constructor(private loginService: LoginService, private userService: UserService, private router: Router) {

  }

  ngOnInit() {
    const username = this.loginService.activeUser!.username;
    this.userService.getUserPrograms(username).subscribe({
      next: (programs: Program[]) => {

        this.myPrograms = programs;
        this.myPrograms.forEach(program => {
          program.comments.forEach(comment => {
            if (comment.answer == null) {
              this.comments.push(comment);
            }
          })
        });
        console.log("ukupno" + this.comments.length);
      }
    });

    this.userService.getUserActviePrograms(username).subscribe({
      next: (programs: Program[]) => {
        this.activePrograms = programs;
      }
    });

    this.userService.getUserFinishedPrograms(username).subscribe({
      next: (programs: Program[]) => {
        this.finishedPrograms = programs;
      }
    });
  }

  onProgramDeleted(programId: number) {
    this.myPrograms = this.myPrograms.filter(program => program.id !== programId);
  }

}

