export class ExerciseModel {

    name: string;
    type: string;
    muscle: string;
    equipment: string;
    difficulty: string;
    instructions: string;

    constructor(
        name: string,
        type: string,
        muscle: string,
        equipment: string,
        difficulty: string,
        instructions: string
    ) {
        this.name = name;
        this.type = type;
        this.muscle = muscle;
        this.equipment = equipment;
        this.difficulty = difficulty;
        this.instructions = instructions;
    }
}
