import { Component, Input } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrl: './program.component.css'
})
export class ProgramComponent {

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
