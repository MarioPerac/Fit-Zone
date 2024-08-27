import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MessageToAdvisors } from '../../models/messageToAdivisors.model';

@Injectable({
  providedIn: 'root'
})
export class ConsultingService {

  private apiUrl = 'http://localhost:8080/api/message-to-advisors';

  constructor(private http: HttpClient) { }

  sendMessage(message: MessageToAdvisors) {
    return this.http.post<MessageToAdvisors>(this.apiUrl, message);
  }

}
