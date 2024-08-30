import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import Parser from 'rss-parser';
@Injectable({
  providedIn: 'root'
})
export class RssService {

  private rssUrl = '/api';

  private parser: Parser;

  constructor(private http: HttpClient) {
    this.parser = new Parser();
  }

  getRssFeed(): Observable<any> {
    return this.http.get(this.rssUrl, { responseType: 'text' }).pipe(
      map(response =>
        this.parser.parseString(response)
      )
    );
  }
}
