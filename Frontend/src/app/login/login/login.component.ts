import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LoginService } from '../../services/login/login.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Login } from '../../models/login.model';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {

  public form: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private snackBar: MatSnackBar, private router: Router) { }


  public ngOnInit(): void {
    this.form = this.formBuilder.group({
      username: [null, Validators.required],
      password: [null, Validators.required]
    })
  }

  public login(form: any) {
    this.loginService.login(new Login(form.value.username, form.value.password)).subscribe({
      next: (user: User) => {

        this.loginService.signedIn = true;
        this.loginService.activeUser = user;

        this.router.navigate(['home'], { state: { user: this.loginService.activeUser, signedIn: this.loginService.signedIn } });
      },
      error: (error) => {
        if (error.status === 401) {

          this.snackBar.open("Incorrect credentials", undefined, {
            duration: 2000
          });
        } else {

          console.error('Error during login:', error);
          this.snackBar.open("An error occurred. Please try again.", undefined, {
            duration: 2000
          });
        }
      }
    });
  }


  hide = true;

  clickEvent(event: MouseEvent) {
    this.hide = !this.hide;
    event.stopPropagation();
  }

  signup() {
    this.router.navigate(["/signup"]);
  }
}
