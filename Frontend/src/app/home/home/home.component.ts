import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program.model';
import { ProgramService } from '../../services/program/program.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  programs!: Program[];

  constructor(private programService: ProgramService) { }

  ngOnInit() {
    this.programService.getPrograms().subscribe(
      {
        next: (programs: Program[]) => {
          this.programs = programs;
        }
      }
    );
  }




}
