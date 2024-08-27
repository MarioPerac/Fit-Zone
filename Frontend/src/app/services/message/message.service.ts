import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private apiUrl = 'http://localhost:8080/api/messages';

  constructor(private http: HttpClient) { }

  getChats(username: string) {
    return this.http.get<string[]>(this.apiUrl + "/chats/" + username);
  }
}
