import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-program',
  templateUrl: './new-program.component.html',
  styleUrl: './new-program.component.css'
})
export class NewProgramComponent implements OnInit {

  public form: FormGroup = new FormGroup({});
  categories = ['Category 1', 'Category 2', 'Category 3'];
  images: any[] = [];
  constructor(private formBuilder: FormBuilder) { };


  ngOnInit(): void {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      description: [''],
      location: ['', Validators.required],
      categories: [[], Validators.required],
      images: [[]]
    });
  }

  create(form: any) {
    //TO DO

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


}
