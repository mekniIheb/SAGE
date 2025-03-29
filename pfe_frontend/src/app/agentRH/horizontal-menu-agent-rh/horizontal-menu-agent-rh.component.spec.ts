import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HorizontalMenuAgentRhComponent } from './horizontal-menu-agent-rh.component';

describe('HorizontalMenuAgentRhComponent', () => {
  let component: HorizontalMenuAgentRhComponent;
  let fixture: ComponentFixture<HorizontalMenuAgentRhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HorizontalMenuAgentRhComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HorizontalMenuAgentRhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
