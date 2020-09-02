import { Component, OnInit } from '@angular/core';
import { ScheduleEntity } from '../scheduleentity';
import { ScheduleProgramService } from '../schedule-program.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-applicant',
  templateUrl: './applicant.component.html',
  styleUrls: ['./applicant.component.css',]
})
export class ApplicantComponent implements OnInit {
  scheduleEntities: Observable<ScheduleEntity[]>;

  constructor(private scheduleprogramservice: ScheduleProgramService, private router: Router) { }

  ngOnInit(): void {
      this.reloadData();
  }
  reloadData() {
    this.scheduleEntities = this.scheduleprogramservice.getAllSchedule();
  }
 
       scheduleDetails(id: String)
       {
    this.router.navigate(['/detail', id]);
      }
      

}

