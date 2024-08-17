import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Category } from '../../models/category.model';
import { CategoryService } from '../../services/category/category.service';
import { ProgramService } from '../../services/program/program.service';
import { Program } from '../../models/program.model';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Image } from '../../models/image.model';
import { ProgramRequest } from '../../models/requests/program-request.model';
import { ImageRequest } from '../../models/requests/image-request.model';
import { ImageService } from '../../services/image/image.service';
import { LoginService } from '../../services/login/login.service';

@Component({
  selector: 'app-new-program',
  templateUrl: './new-program.component.html',
  styleUrl: './new-program.component.css'
})
export class NewProgramComponent implements OnInit {

  public form: FormGroup = new FormGroup({});
  categories!: Category[];
  images: string[] = [];
  image?: string;
  constructor(private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    private programService: ProgramService,
    private snackBar: MatSnackBar,
    private imageService: ImageService,
    private loginService: LoginService) { };


  ngOnInit(): void {
    this.categoryService.getCategories().subscribe({
      next: (data: Category[]) => {
        console.log(data);
        this.categories = data;
      }
    });
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      description: [''],
      location: ['', Validators.required],
      categories: [null, Validators.required],
      duration: [0, Validators.required],
      price: [0],
      level: ['', Validators.required],
      images: [[]],
      image: [null]
    });
  }

  create(form: FormGroup) {

    const category: Category = form.value.categories;
    console.log(category);
    const program = new ProgramRequest(
      this.loginService.activeUser?.username!,
      form.value.name,
      form.value.description,
      form.value.location,
      category.id,
      form.value.price,
      form.value.level,
      form.value.duration
    );

    this.programService.createProgram(program).subscribe({
      next: (programReq: ProgramRequest) => {
        // to do change

        const id = programReq.id || 0;
        const programImages: ImageRequest[] = [];
        for (let index = 0; index < this.images.length; index++) {
          programImages.push(new ImageRequest(this.images[index], id, false));

        }
        programImages.push(new ImageRequest(form.value.image, id, true));

        this.imageService.addImages(programImages).subscribe({
          next: (images: Image[]) => {
            this.snackBar.open('Program added', undefined, { duration: 2000 });
          },
          error: (err) => {
            console.error('Error adding program images', err);
            this.snackBar.open('Error during images adding', undefined, { duration: 2000 });
          }
        });
      },
      error: (err) => {
        console.error('Error adding program', err);
        this.snackBar.open('Error during program creation', undefined, { duration: 2000 });
      }
    });
  }


  onFilesSelected(event: any) {
    const files: FileList = event.target.files;
    if (files.length > 0) {
      const fileArray = Array.from(files);
      this.images = [];
      fileArray.forEach(file => {
        const reader = new FileReader();
        reader.onload = (e: any) => {
          this.images.push(e.target.result);
          this.form.patchValue({ images: this.images });
        };
        reader.readAsDataURL(file);
      });
    }
  }

  onFileSelected(event: any) {
    const file: File = event.target.files[0];
    const reader = new FileReader();
    reader.onload = (e: any) => {
      this.image = e.target.result;
      this.form.patchValue({ image: this.image });
    };
    reader.readAsDataURL(file);
  }


}
