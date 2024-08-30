import { StickyDirection } from "@angular/cdk/table";

export class CommentRequest {
    question: string;
    userUsername: string;
    programId: number;

    constructor(question: string, userUsername: string, programId: number) {
        this.question = question;
        this.userUsername = userUsername;
        this.programId = programId;
    }
}