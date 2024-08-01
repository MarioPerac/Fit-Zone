export class ImageRequest {

    data: string;
    programId: number;
    isProfile: boolean;

    constructor(data: string, programId: number, isProfile: boolean) {
        this.data = data;
        this.programId = programId;
        this.isProfile = isProfile;
    }
}