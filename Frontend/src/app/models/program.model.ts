import { Category } from "./category.model";
import { Comment } from "./comment.model";
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
    isActive: boolean;
    images: Image[];
    comments: Comment[];

    constructor(
        id: number,
        name: string,
        description: string,
        location: string,
        category: Category,
        price: number,
        level: string,
        duration: number,
        isActive: boolean,
        images: Image[],
        comments: Comment[]
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.category = category;
        this.price = price;
        this.level = level;
        this.duration = duration;
        this.isActive = isActive;
        this.images = images;
        this.comments = comments;
    }
}
