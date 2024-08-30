import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ExerciseModel } from '../../models/exercise.model';
import { environment } from '../../../../environment';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {

  private apiUrl = 'https://api.api-ninjas.com/v1/exercises';
  private apiKey = environment.apiKey;

  constructor(private http: HttpClient) { }

  getExercises(): Observable<ExerciseModel[]> {
    const headers = new HttpHeaders({
      'X-Api-Key': this.apiKey
    });

    return this.http.get<ExerciseModel[]>(this.apiUrl, { headers });
  }
}
