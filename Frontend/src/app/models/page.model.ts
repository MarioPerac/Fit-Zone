export interface Page<T> {
    totalElements: number;
    totalPages: number;
    numberOfElements: number;
    size: number;
    content: T[];
    number: number;
}
