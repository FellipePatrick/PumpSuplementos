import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipalCompentComponent } from './principal-compent.component';

describe('PrincipalCompentComponent', () => {
  let component: PrincipalCompentComponent;
  let fixture: ComponentFixture<PrincipalCompentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrincipalCompentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrincipalCompentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
