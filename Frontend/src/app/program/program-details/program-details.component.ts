import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';
import { LoginService } from '../../services/login/login.service';
import { EnrolmentService } from '../../services/enrolment/enrolment.service';
import { EnrolmentRequest } from '../../models/requests/enrolment-request.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Enrolment } from '../../models/enrolment.model';

@Component({
  selector: 'app-program-details',
  templateUrl: './program-details.component.html',
  styleUrl: './program-details.component.css'
})
export class ProgramDetailsComponent implements OnInit {
  program!: Program;

  constructor(private loginService: LoginService, private enrolmentService: EnrolmentService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.program = history.state.program;
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

  entrol() {
    this.enrolmentService.add(new EnrolmentRequest(this.loginService.activeUser!.username, this.program.id)).subscribe({
      next: (enrolment: Enrolment) => {
        this.snackBar.open('Successful enrolment', undefined, { duration: 2000 });
      },
      error: (err) => {
        this.snackBar.open('Error during enrolment', undefined, { duration: 2000 });
      }
    });
  }
}