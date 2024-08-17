import { Component, Input } from '@angular/core';
import { Program } from '../../models/program.model';

@Component({
  selector: 'app-finished-programs',
  templateUrl: './finished-programs.component.html',
  styleUrl: './finished-programs.component.css'
})
export class FinishedProgramsComponent {
  @Input() program!: Program;
}
