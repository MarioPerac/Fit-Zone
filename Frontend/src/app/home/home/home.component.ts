import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  programs!: Program[];

  ngOnInit() {
    this.programs = [new Program(
      1,
      'Yoga Class',
      'A relaxing yoga session',
      'Studio A',
      2,
      15.00,
      'Beginner',
      3,
      'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.self.com%2Fstory%2Fheres-what-a-perfect-week-of-working-out-looks-like&psig=AOvVaw0S84oo4kFumS6YDAwqTnEL&ust=1720000609100000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPjh1eSLiIcDFQAAAAAdAAAAABAE' // Set a valid image URL
    ), new Program(
      1,
      'Yoga Class',
      'A relaxing yoga session',
      'Studio A',
      2,
      15.00,
      'Beginner',
      5,
      'https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.self.com%2Fstory%2Fheres-what-a-perfect-week-of-working-out-looks-like&psig=AOvVaw0S84oo4kFumS6YDAwqTnEL&ust=1720000609100000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPjh1eSLiIcDFQAAAAAdAAAAABAE' // Set a valid image URL
    )
    ]
  }

}
