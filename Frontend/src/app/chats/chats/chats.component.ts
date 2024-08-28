import { Component, OnInit } from '@angular/core';
import { Chat } from '../../models/chat.model';
import { LoginService } from '../../services/login/login.service';
import { MessageService } from '../../services/message/message.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-chats',
  templateUrl: './chats.component.html',
  styleUrl: './chats.component.css'
})
export class ChatsComponent implements OnInit {


  constructor(private loginService: LoginService, private messageService: MessageService, private router: Router) { }

  chats!: Chat[];

  ngOnInit() {

    this.messageService.getChats(this.loginService.activeUser!.username)
      .subscribe({
        next: (chats: Chat[]) => {
          if (chats.length != 0) {
            this.chats = chats;
          } else
            this.chats = [];
        }
      })
  }

  onChatClick(chat: Chat) {
    const friendName = chat.friendName;
    this.router.navigate(["chat/" + this.loginService.activeUser?.username + "/with/" + chat.friendUsername], { state: { friendName } });
  }
}
