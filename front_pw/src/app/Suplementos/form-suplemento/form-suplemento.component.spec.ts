import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormSuplementoComponent } from './form-suplemento.component';

describe('FormSuplementoComponent', () => {
  let component: FormSuplementoComponent;
  let fixture: ComponentFixture<FormSuplementoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormSuplementoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormSuplementoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
