import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Image } from '../models/image.model';
import { ImageRequest } from '../models/requests/image-request.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  private apiUrl = 'http://localhost:8080/api/images';
  constructor(private http: HttpClient) { }

  addImages(images: ImageRequest[]): Observable<Image[]> {
    return this.http.post<Image[]>(`${this.apiUrl}/list`, images);
  }
}
