
export class User {
    firstName: string;
    lastName: string;
    password: string;
    username: string;
    mail: string;
    avatar: string;
    acitvated?: boolean;

    constructor(firstName: string, lastName: string, username: string, password: string, mail: string, avatar: string, activated: boolean) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.avatar = avatar;
        this.acitvated = activated;
    }
}