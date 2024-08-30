import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from '../../models/comment.model';
import { CommentRequest } from '../../models/requests/comment-request.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  private apiUrl = 'http://localhost:8080/api/comments';

  constructor(private http: HttpClient) { }

  answer(id: number, answer: string) {
    return this.http.put<Comment>(this.apiUrl + "/" + id + "/answer", answer);
  }

  question(commentRequest: CommentRequest) {
    return this.http.post(this.apiUrl, commentRequest);
  }
}
