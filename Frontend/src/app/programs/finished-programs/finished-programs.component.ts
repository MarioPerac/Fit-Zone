import { Component, Input } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';

@Component({
  selector: 'app-finished-programs',
  templateUrl: './finished-programs.component.html',
  styleUrl: './finished-programs.component.css'
})
export class FinishedProgramsComponent {
  @Input() program!: Program;

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
