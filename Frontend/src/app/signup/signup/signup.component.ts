import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit {

  public form: FormGroup = new FormGroup({});
  public avatars: { value: string, imageUrl: string }[] = [];
  public selectedAvatar: { value: string, imageUrl: string } | undefined;

  constructor(private fromBuilder: FormBuilder) { }

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
    //TO DO

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
