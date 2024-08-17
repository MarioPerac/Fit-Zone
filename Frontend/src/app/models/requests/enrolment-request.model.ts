export class EnrolmentRequest {

    username: string;
    programId: number;

    constructor(username: string, programId: number) {

        this.programId = programId;
        this.username = username;
    }
}