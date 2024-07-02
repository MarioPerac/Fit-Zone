import { Component, Input } from '@angular/core';
import { Program } from '../../models/program';

@Component({
  selector: 'app-program',
  templateUrl: './program.component.html',
  styleUrl: './program.component.css'
})
export class ProgramComponent {

  @Input() program!: Program;

}
