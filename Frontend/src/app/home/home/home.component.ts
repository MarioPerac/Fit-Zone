import { Component, OnInit } from '@angular/core';
import { Program } from '../../models/program.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  programs!: Program[];

  ngOnInit() {
    this.initializePrograms();
  }

  initializePrograms() {
    this.programs = [
      {
        id: 1,
        name: "Beginner Yoga Class",
        description: "A relaxing yoga class suitable for beginners.",
        location: "Community Center",
        categoryId: 101,
        price: 20.0,
        level: "Beginner",
        duration: 60,
        image: new Blob() // Replace with actual image Blob if available
      },
      {
        id: 2,
        name: "Advanced Programming Workshop",
        description: "An in-depth workshop on advanced programming concepts.",
        location: "Tech Hub",
        categoryId: 102,
        price: 150.0,
        level: "Advanced",
        duration: 180,
        image: new Blob() // Replace with actual image Blob if available
      },
      {
        id: 3,
        name: "Cooking Masterclass",
        description: "A masterclass with a renowned chef.",
        location: "Gourmet Kitchen",
        categoryId: 103,
        price: 75.0,
        level: "Intermediate",
        duration: 120,
        image: new Blob() // Replace with actual image Blob if available
      },
      {
        id: 4,
        name: "Digital Marketing Seminar",
        description: "Learn the latest trends in digital marketing.",
        location: "Conference Hall",
        categoryId: 104,
        price: 50.0,
        level: "Beginner",
        duration: 90,
        image: new Blob() // Replace with actual image Blob if available
      },
      {
        id: 5,
        name: "Art & Creativity Workshop",
        description: "Explore your creativity through various art forms.",
        location: "Art Studio",
        categoryId: 105,
        price: 30.0,
        level: "All Levels",
        duration: 120,
        image: new Blob() // Replace with actual image Blob if available
      }
    ];
  }

}
