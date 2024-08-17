import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinishedProgramsComponent } from './finished-programs.component';

describe('FinishedProgramsComponent', () => {
  let component: FinishedProgramsComponent;
  let fixture: ComponentFixture<FinishedProgramsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FinishedProgramsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FinishedProgramsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
