export class Image {

    id: number;
    data: string;
    programId: number;
    isProfile: boolean;

    constructor(id: number, data: string, programId: number, isProfile: boolean) {
        this.id = id;
        this.data = data;
        this.programId = programId;
        this.isProfile = isProfile;
    }
}