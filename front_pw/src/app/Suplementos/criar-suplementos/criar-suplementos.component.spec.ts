import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarSuplementosComponent } from './criar-suplementos.component';

describe('CriarSuplementosComponent', () => {
  let component: CriarSuplementosComponent;
  let fixture: ComponentFixture<CriarSuplementosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CriarSuplementosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CriarSuplementosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
