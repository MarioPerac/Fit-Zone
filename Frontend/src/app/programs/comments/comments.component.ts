import { Component, Input } from '@angular/core';
import { Comment } from '../../models/comment.model';
import { CommentService } from '../../services/comment/comment.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrl: './comments.component.css'
})
export class CommentsComponent {

  @Input() comment!: Comment;

  constructor(private commentService: CommentService, private snackBar: MatSnackBar) {
  }

  submitAnswer(comment: Comment) {
    this.commentService.answer(comment.id, comment.answer).subscribe(() => {
      this.snackBar.open('Anwer sent.', undefined, { duration: 2000 });
    });
  }
}
