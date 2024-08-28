export class Message {
    id: number;
    sender: string;
    receiver: string;
    content: string;
    created: string;

    constructor(id: number, sender: string, receiver: string, content: string, created: string) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.created = created;
    }
}