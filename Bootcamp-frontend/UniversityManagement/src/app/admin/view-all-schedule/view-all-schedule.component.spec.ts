import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllScheduleComponent } from './view-all-schedule.component';

describe('ViewAllScheduleComponent', () => {
  let component: ViewAllScheduleComponent;
  let fixture: ComponentFixture<ViewAllScheduleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllScheduleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
