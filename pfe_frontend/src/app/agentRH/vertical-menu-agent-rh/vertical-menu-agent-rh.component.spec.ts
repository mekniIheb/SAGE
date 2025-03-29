import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerticalMenuAgentRhComponent } from './vertical-menu-agent-rh.component';

describe('VerticalMenuAgentRhComponent', () => {
  let component: VerticalMenuAgentRhComponent;
  let fixture: ComponentFixture<VerticalMenuAgentRhComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerticalMenuAgentRhComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerticalMenuAgentRhComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
