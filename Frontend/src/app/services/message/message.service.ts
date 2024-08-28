import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Chat } from '../../models/chat.model';
import { Message } from '../../models/message.model';
import { MessageRequest } from '../../models/requests/message-request.model';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  private apiUrl = 'http://localhost:8080/api/messages';

  constructor(private http: HttpClient) { }

  getChats(username: string) {
    return this.http.get<Chat[]>(this.apiUrl + "/chats/" + username);
  }


  getMessages(username: string, friend: string) {
    return this.http.get<Message[]>(this.apiUrl + "/" + username + "/with/" + friend);
  }

  sendMessage(message: MessageRequest) {
    return this.http.post<Message>(this.apiUrl, message);
  }
}
