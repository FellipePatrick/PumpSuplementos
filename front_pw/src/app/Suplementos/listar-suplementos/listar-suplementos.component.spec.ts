import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSuplementosComponent } from './listar-suplementos.component';

describe('ListarSuplementosComponent', () => {
  let component: ListarSuplementosComponent;
  let fixture: ComponentFixture<ListarSuplementosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarSuplementosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarSuplementosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
