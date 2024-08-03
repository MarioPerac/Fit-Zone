import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';

@Component({
  selector: 'app-program-details',
  templateUrl: './program-details.component.html',
  styleUrl: './program-details.component.css'
})
export class ProgramDetailsComponent implements OnInit {
  program!: Program;

  constructor() { }

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
}
