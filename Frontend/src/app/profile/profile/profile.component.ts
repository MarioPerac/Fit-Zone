import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../../services/login/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit {

  user!: User;

  constructor(private router: Router, private loginService: LoginService) { }
  ngOnInit() {
    this.user = this.loginService.activeUser!;
  }
}
