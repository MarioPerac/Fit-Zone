export class Comment {
    id: number
    question: string;
    answer: string;
    userUsername: string;
    programId: number;
    date: string;

    constructor(id: number, question: string, answer: string, userUsername: string, programId: number, date: string) {
        this.question = question;
        this.userUsername = userUsername;
        this.programId = programId;
        this.id = id;
        this.answer = answer;
        this.date = date;
    }
}