
export class MessageToAdvisors {
    id?: number;
    title: string;
    content: string;
    username: string;

    constructor(title: string, content: string, username: string) {
        this.title = title;
        this.content = content;
        this.username = username;
    }
}