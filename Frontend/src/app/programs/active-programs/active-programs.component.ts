import { Component, Input } from '@angular/core';
import { Program } from '../../models/program.model';

@Component({
  selector: 'app-active-programs',
  templateUrl: './active-programs.component.html',
  styleUrl: './active-programs.component.css'
})
export class ActiveProgramsComponent {
  @Input() program!: Program;
}
