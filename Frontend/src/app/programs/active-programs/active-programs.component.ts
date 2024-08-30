import { Component, Input } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';

@Component({
  selector: 'app-active-programs',
  templateUrl: './active-programs.component.html',
  styleUrl: './active-programs.component.css'
})
export class ActiveProgramsComponent {
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
