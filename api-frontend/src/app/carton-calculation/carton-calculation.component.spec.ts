import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CartonCalculationComponent } from './carton-calculation.component';

describe('CartonCalculationComponent', () => {
  let component: CartonCalculationComponent;
  let fixture: ComponentFixture<CartonCalculationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CartonCalculationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CartonCalculationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
