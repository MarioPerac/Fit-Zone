export class Enrolment {

    id: number;
    username: string;
    programId: number;

    constructor(id: number, username: string, programId: number) {
        this.id = id;
        this.programId = programId;
        this.username = username;
    }
}