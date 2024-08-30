import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Program } from '../../models/program.model';
import { Image } from '../../models/image.model';
import { ProgramService } from '../../services/program/program.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ProgramComponent } from '../../home/program/program.component';

@Component({
  selector: 'app-my-programs',
  templateUrl: './my-programs.component.html',
  styleUrl: './my-programs.component.css'
})
export class MyProgramsComponent {
  @Input() program!: Program;
  @Output() programDeleted = new EventEmitter<number>();
  @Output() programFinished = new EventEmitter<number>();

  constructor(private programService: ProgramService, private snackBar: MatSnackBar) { }
  getProfileImage(images: Image[]): string {

    let image: string = '';

    images.forEach(i => {
      if (i.isProfile) {
        image = i.data;
      }
    });

    return image;
  };

  onFinishClick() {
    this.programService.finishProgram(this.program.id).subscribe((program: Program) => {
      this.snackBar.open('Program finished', undefined, { duration: 2000 });
      this.program = program;
    }
    );
  }

  onDeleteClick() {
    this.programService.delete(this.program.id).subscribe(() => {
      this.snackBar.open('Program deleted', undefined, { duration: 2000 });
      this.programDeleted.emit(this.program.id);
    });
  }
}
