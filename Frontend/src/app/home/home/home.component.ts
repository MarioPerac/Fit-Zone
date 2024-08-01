import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  programs!: Program[];

  ngOnInit() {
    this.initializePrograms();
  }

  initializePrograms() {

  }

}
