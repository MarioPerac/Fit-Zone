import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Program } from '../../models/program.model';
import { map, Observable } from 'rxjs';
import { ProgramRequest } from '../../models/requests/program-request.model';
import { Page } from '../../models/page.model';
import { UserHasProgram } from '../../models/userHasProgram.model';

@Injectable({
  providedIn: 'root'
})
export class ProgramService {

  private apiUrl = 'http://localhost:8080/api/programs';

  constructor(private http: HttpClient) { }

  finishProgram(id: number) {
    return this.http.get<Program>(this.apiUrl + "/finish/" + id)
  }

  delete(id: number) {
    return this.http.delete(this.apiUrl + "/" + id);
  }

  getPrograms(): Observable<Program[]> {
    return this.http.get<Program[]>(this.apiUrl);
  }

  createProgram(program: ProgramRequest): Observable<Program> {
    const createUrl = this.apiUrl + "/new";
    return this.http.post<Program>(createUrl, program);
  }

  getProgramsToUser(username: string, page: number, size: number): Observable<Page<UserHasProgram>> {
    let params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    return this.http.get<Page<UserHasProgram>>(this.apiUrl + '/to/' + username, { params });
  }
}
