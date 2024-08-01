import { Category } from "./category.model";
import { Image } from "./image.model";

export class Program {
    id: number;
    name: string;
    description: string;
    location: string;
    category: Category;
    price: number;
    level: string;
    duration: number;
    images: Image[];
    programImage: Image;

    constructor(
        id: number,
        name: string,
        description: string,
        location: string,
        category: Category,
        price: number,
        level: string,
        duration: number,
        images: Image[],
        image: Image
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.category = category;
        this.price = price;
        this.level = level;
        this.duration = duration;
        this.images = images;
        this.programImage = image;
    }
}
