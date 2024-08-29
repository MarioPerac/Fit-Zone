import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program.model';
import { ProgramService } from '../../services/program/program.service';
import { Router } from '@angular/router';
import { LoginService } from '../../services/login/login.service';
import { UserHasProgram } from '../../models/userHasProgram.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  usersHavePrograms!: UserHasProgram[];
  totalItems: number = 0;
  currentPage: number = 0;
  pageSize: number = 3;
  constructor(private programService: ProgramService, private router: Router, private loginService: LoginService) { }

  ngOnInit(): void {
    this.loadPrograms();
  }

  loadPrograms(page: number = 0): void {
    this.programService.getProgramsToUser(this.loginService.activeUser!.username, page, this.pageSize).subscribe(response => {
      this.usersHavePrograms = response.content;
      this.totalItems = response.totalElements;
      this.currentPage = response.number;
    });
  }

  onPageChange(event: any): void {
    this.loadPrograms(event.pageIndex);
  }



  openDetails(userHasProgram: UserHasProgram) {
    this.router.navigate(["/program", userHasProgram.program.id], { state: { userHasProgram } });
  }
}
