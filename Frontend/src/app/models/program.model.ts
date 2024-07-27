export class Program {
    id: number;
    name: string;
    description: string;
    location: string;
    categoryId: number;
    price: number;
    level: string;
    duration: number;
    image: Blob;

    constructor(
        id: number,
        name: string,
        description: string,
        location: string,
        categoryId: number,
        price: number,
        level: string,
        duration: number,
        image: Blob
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.categoryId = categoryId;
        this.price = price;
        this.level = level;
        this.duration = duration;
        this.image = image;
    }
}
