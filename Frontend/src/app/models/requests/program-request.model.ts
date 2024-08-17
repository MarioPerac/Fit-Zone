export class ProgramRequest {
    id?: number;
    username: string;
    name: string;
    description: string;
    location: string;
    categoryId: number;
    price: number;
    level: string;
    duration: number;

    constructor(
        username: string,
        name: string,
        description: string,
        location: string,
        categoryId: number,
        price: number,
        level: string,
        duration: number
    ) {
        this.username = username;
        this.name = name;
        this.description = description;
        this.location = location;
        this.categoryId = categoryId;
        this.price = price;
        this.level = level;
        this.duration = duration;
    }
}