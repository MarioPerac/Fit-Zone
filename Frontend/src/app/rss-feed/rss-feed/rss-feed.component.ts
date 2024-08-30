import { Component } from '@angular/core';
import { RssService } from '../../services/rss/rss.service';

interface FeedItem {
  title: string;
  link: string;
  content: string;
  image: any;
  contentSnippet: string;
  categories: string[];
}


@Component({
  selector: 'app-rss-feed',
  templateUrl: './rss-feed.component.html',
  styleUrl: './rss-feed.component.css'
})
export class RssFeedComponent {
  feed: FeedItem[] = [];

  constructor(private rssFeedService: RssService) { }

  ngOnInit(): void {
    this.rssFeedService.getRssFeed().subscribe(data => {
      console.log(data);
      this.feed = data.__zone_symbol__value.items;
    });
  }
}
