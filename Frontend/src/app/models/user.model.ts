
export class User {
    name: string;
    surname: string;
    password: string;
    username: string;
    mail: string;
    avatar: string;
    activated?: boolean;

    constructor(firstName: string, lastName: string, username: string, password: string, mail: string, avatar: string, activated: boolean) {
        this.name = firstName;
        this.surname = lastName;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.avatar = avatar;
        this.activated = activated;
    }
}