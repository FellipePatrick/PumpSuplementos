import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSuplementosComponent } from './edit-suplementos.component';

describe('EditSuplementosComponent', () => {
  let component: EditSuplementosComponent;
  let fixture: ComponentFixture<EditSuplementosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EditSuplementosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditSuplementosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
