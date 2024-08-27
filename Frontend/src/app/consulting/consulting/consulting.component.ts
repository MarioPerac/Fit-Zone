import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Title } from '@angular/platform-browser';
import { Login } from '../../models/login.model';
import { LoginService } from '../../services/login/login.service';
import { ConsultingService } from '../../services/consulting/consulting.service';
import { MessageToAdvisors } from '../../models/messageToAdivisors.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-consulting',
  templateUrl: './consulting.component.html',
  styleUrl: './consulting.component.css'
})
export class ConsultingComponent {
  messageForm!: FormGroup;

  constructor(private fb: FormBuilder, private loginService: LoginService, private consultingService: ConsultingService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.messageForm = this.fb.group({
      title: ['', Validators.required],
      message: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.messageForm.valid) {

      const title = this.messageForm.value.title;
      const content = this.messageForm.value.message;
      this.consultingService.sendMessage(new MessageToAdvisors(title, content, this.loginService.activeUser!.username)).subscribe({
        next: (message: MessageToAdvisors) => {
          this.snackBar.open('Message sent to advisors.', undefined, { duration: 2000 });
          this.messageForm.reset();
        },
        error: (err) => {
          this.snackBar.open('Error during message sending', undefined, { duration: 2000 });
        }
      });


    }
  }
}
