import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EnrolmentRequest } from '../../models/requests/enrolment-request.model';
import { Enrolment } from '../../models/enrolment.model';

@Injectable({
  providedIn: 'root'
})
export class EnrolmentService {

  private apiUrl = 'http://localhost:8080/api/enrolments';

  constructor(private http: HttpClient) { }

  add(req: EnrolmentRequest) {
    return this.http.post<Enrolment>(this.apiUrl, req);
  }
}
