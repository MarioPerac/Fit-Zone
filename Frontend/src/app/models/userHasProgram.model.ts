import { Program } from "./program.model";
export class UserHasProgram {
    username: string;
    fullName: string;
    program: Program;

    constructor(username: string, fullName: string, program: Program) {
        this.username = username;
        this.fullName = fullName;
        this.program = program;
    }
}