import { Component, Input } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';
import { UserHasProgram } from '../../models/userHasProgram.model';

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrl: './program.component.css'
})
export class ProgramComponent {

  @Input() userHasProgram!: UserHasProgram;

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
