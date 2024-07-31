import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from '../../models/user.model';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SignUpService } from '../../services/sign-up.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit {

  public form: FormGroup = new FormGroup({});
  public avatars: { value: string, imageUrl: string }[] = [];
  public selectedAvatar!: { value: string, imageUrl: string };

  constructor(private fromBuilder: FormBuilder, private signUpService: SignUpService, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.avatars = [
      {
        value: 'avatar1', imageUrl: 'assets/avatar1.jpg'
      },
      { value: 'avatar2', imageUrl: 'assets/avatar2.jpg' },

    ];

    this.selectedAvatar = this.avatars[0];

    this.form = this.fromBuilder.group({
      name: [null, Validators.required],
      surname: [null, Validators.required],
      city: [null, Validators.required],
      email: [null, Validators.required],
      username: [null, Validators.required],
      password: [null, Validators.required]
    })
  }

  public signup(form: any) {
    const user = new User(
      this.form.value.name,
      this.form.value.surname,
      this.form.value.username,
      this.form.value.password,
      this.form.value.email,
      this.selectedAvatar.imageUrl,
      false
    );

    this.signUpService.signUp(user).subscribe({
      next: (success: boolean) => {
        if (success) {
          this.router.navigate(['login']);
          this.snackBar.open('Successful Sign In', undefined, {
            duration: 2000
          });
        } else {
          this.snackBar.open('Unsuccessful Sign In', undefined, {
            duration: 2000
          });
        }
      },
      error: (err) => {
        console.error('Sign up error', err);
        this.snackBar.open('Error during sign up', undefined, {
          duration: 2000
        });
      }
    });

  }

  hide = true;

  clickEvent(event: MouseEvent) {
    this.hide = !this.hide;
    event.stopPropagation();
  }



  public selectAvatar(avatar: { value: string, imageUrl: string }): void {
    this.selectedAvatar = avatar;
    this.form.patchValue({ avatar: avatar.value });
  }



  getSelectedAvatarUrl(): string {
    const selectedAvatar = this.avatars.find(avatar => avatar.value === this.form.get('avatar')?.value);
    return selectedAvatar ? selectedAvatar.imageUrl : '';
  }
}
