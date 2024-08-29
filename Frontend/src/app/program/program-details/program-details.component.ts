import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';
import { LoginService } from '../../services/login/login.service';
import { EnrolmentService } from '../../services/enrolment/enrolment.service';
import { EnrolmentRequest } from '../../models/requests/enrolment-request.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Enrolment } from '../../models/enrolment.model';
import { UserHasProgram } from '../../models/userHasProgram.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-program-details',
  templateUrl: './program-details.component.html',
  styleUrl: './program-details.component.css'
})
export class ProgramDetailsComponent implements OnInit {
  userHasProgram!: UserHasProgram;
  program!: Program;

  constructor(private loginService: LoginService, private enrolmentService: EnrolmentService, private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
    this.userHasProgram = history.state.userHasProgram;
    this.program = this.userHasProgram.program;
  }

  getProfileImage(images: Image[]): string {

    let image: string = '';

    images.forEach(i => {
      if (i.isProfile) {
        image = i.data;
      }
    });

    return image;
  };

  buy() {
    this.enrolmentService.add(new EnrolmentRequest(this.loginService.activeUser!.username, this.program.id)).subscribe({
      next: (enrolment: Enrolment) => {
        this.snackBar.open('Program successfully bought', undefined, { duration: 2000 });
      },
      error: (err) => {
        this.snackBar.open('Error while buying the program', undefined, { duration: 2000 });
      }
    });
  }

  openChat() {
    const friendName = this.userHasProgram.fullName;
    this.router.navigate(["chat/" + this.loginService.activeUser?.username + "/with/" + this.userHasProgram.username], { state: { friendName } });
  }
}