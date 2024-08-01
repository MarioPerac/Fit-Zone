import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Program } from '../../models/program.model';
import { map, Observable } from 'rxjs';
import { ProgramRequest } from '../../models/requests/program-request.model';

@Injectable({
  providedIn: 'root'
})
export class ProgramService {

  private apiUrl = 'http://localhost:8080/api/programs';

  constructor(private http: HttpClient) { }

  getPrograms(): Observable<Program[]> {
    return this.http.get<Program[]>(this.apiUrl);
  }

  createProgram(program: ProgramRequest): Observable<ProgramRequest> {
    return this.http.post<ProgramRequest>(this.apiUrl, program);
  }
}
