import { Component, OnInit } from '@angular/core';


import { Router } from '@angular/router';

import { ScheduleProgramService } from 'src/app/schedule-program.service';
import { ScheduleEntity } from 'src/app/scheduleentity';


@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent implements OnInit {

  scheduleentity: ScheduleEntity = new ScheduleEntity();
  submitted = false;

  constructor(private scheduleprogramservice: ScheduleProgramService,private router: Router) { }

  ngOnInit(): void {
  }
  newScheduleEntity(): void {
    this.submitted = false;
    this.scheduleentity = new ScheduleEntity();
  }
  save() {
    this.scheduleprogramservice.addSchedule(this.scheduleentity)
      .subscribe(data => console.log(data), error => console.log(error));
      this.scheduleentity = new ScheduleEntity();
    this.gotoList();
  }
  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/schedule']);
  }

}
