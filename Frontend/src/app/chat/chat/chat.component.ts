import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { MessageService } from '../../services/message/message.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css'
})
export class ChatComponent implements OnInit {


  constructor(private loginService: LoginService, private messageService: MessageService) { }

  chats!: string[];

  ngOnInit() {

    this.messageService.getChats(this.loginService.activeUser!.username)
      .subscribe({
        next: (chats: string[]) => {
          if (chats.length != 0) {
            this.chats = chats;
          } else
            this.chats = [];
        }
      })
  }

}
