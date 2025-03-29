import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerificationPresenceComponent } from './verification-presence.component';

describe('VerificationPresenceComponent', () => {
  let component: VerificationPresenceComponent;
  let fixture: ComponentFixture<VerificationPresenceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerificationPresenceComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerificationPresenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
