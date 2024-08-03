import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program.model';
import { ProgramService } from '../../services/program/program.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  programs!: Program[];

  constructor(private programService: ProgramService, private router: Router) { }

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
    // logaout user, signedIn=false...
    this.router.navigate(["/login"]);
  }
}
