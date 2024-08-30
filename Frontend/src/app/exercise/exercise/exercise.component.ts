import { Component } from '@angular/core';
import { ExerciseService } from '../../services/exercise/exercise.service';
import { ExerciseModel } from '../../models/exercise.model';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrl: './exercise.component.css'
})
export class ExerciseComponent {
  exercises: ExerciseModel[] = [];

  constructor(private exerciseService: ExerciseService) { }

  ngOnInit(): void {
    this.exerciseService.getExercises().subscribe(
      data => {
        console.log(data);
        this.exercises = data;
        console.log(this.exercises);
      },
      error => {
        console.error('Error fetching exercises:', error);
      }
    );
  }
}
