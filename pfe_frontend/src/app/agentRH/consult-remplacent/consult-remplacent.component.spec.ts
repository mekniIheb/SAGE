import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultRemplacentComponent } from './consult-remplacent.component';

describe('ConsultRemplacentComponent', () => {
  let component: ConsultRemplacentComponent;
  let fixture: ComponentFixture<ConsultRemplacentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultRemplacentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsultRemplacentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
