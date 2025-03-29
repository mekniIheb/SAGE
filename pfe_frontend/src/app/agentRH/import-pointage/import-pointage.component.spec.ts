import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ImportPointageComponent } from './import-pointage.component';

describe('ImportPointageComponent', () => {
  let component: ImportPointageComponent;
  let fixture: ComponentFixture<ImportPointageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ImportPointageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ImportPointageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
