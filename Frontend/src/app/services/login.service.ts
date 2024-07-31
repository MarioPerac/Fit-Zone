import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { HttpClient } from '@angular/common/http';
import { Login } from '../models/login.model';
import { catchError, map, Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public signedIn: boolean = false;
  public activeUser: User | null = null;
  private apiUrl = 'http://localhost:8080/api/login';

  constructor(private http: HttpClient) { }


  public login(login: Login): Observable<User> {
    return this.http.post<User>(this.apiUrl, login);
  }
}
