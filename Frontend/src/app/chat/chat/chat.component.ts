import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { MessageService } from '../../services/message/message.service';
import { Chat } from '../../models/chat.model';
import { Message } from '../../models/message.model';
import { ActivatedRoute, Router } from '@angular/router';
import { MessageRequest } from '../../models/requests/message-request.model';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css'
})
export class ChatComponent implements OnInit {


  constructor(private loginService: LoginService, private messageService: MessageService, private route: ActivatedRoute, private router: Router) {
    const navigation = this.router.getCurrentNavigation();
    this.friendName = navigation?.extras.state?.['friendName'];
  }

  messages!: Message[];
  username!: string;
  friendUsername!: string;
  friendName: string;
  newMessageContent: string = '';

  ngOnInit() {

    this.username = this.route.snapshot.paramMap.get('username')!;
    this.friendUsername = this.route.snapshot.paramMap.get('friend')!;


    this.messageService.getMessages(this.username, this.friendUsername)
      .subscribe({
        next: (messages: Message[]) => {
          if (messages.length != 0) {
            this.messages = messages;
          } else
            this.messages = [];
        }
      });
  }

  sendMessage() {

    this.messageService.sendMessage(new MessageRequest(this.username, this.friendUsername, this.newMessageContent))
      .subscribe({
        next: (message: Message) => {
          this.messages.push(message);
          this.newMessageContent = '';
        }
      });
  }
}
