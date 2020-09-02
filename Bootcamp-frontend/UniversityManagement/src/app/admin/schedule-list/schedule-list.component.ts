import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Router } from '@angular/router';
import { ScheduleEntity } from 'src/app/scheduleentity';
import { ScheduleProgramService } from 'src/app/schedule-program.service';

@Component({
  selector: 'app-schedule-list',
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css']
})
export class ScheduleListComponent implements OnInit {

  scheduleEntities: Observable<ScheduleEntity[]>;

  constructor(private scheduleprogramservice: ScheduleProgramService, private router: Router) { }

  ngOnInit(): void {
      this.reloadData();
  }
  reloadData() {
    this.scheduleEntities = this.scheduleprogramservice.getAllSchedule();
  }
  deleteScheduleById(id: String)
  {
    this.scheduleprogramservice.deleteScheduleById(id)
    .subscribe(
      data => {
        console.log("deleted sucessfully");
        this.reloadData();
      },
      error => console.log(error));
    }
       scheduleDetails(id: String)
       {
    this.router.navigate(['/details', id]);
      }
      updateScheduleById(id:String)
      {
        console.log("id"+id);
        this.router.navigate(['/update',id]);
      }

      goToAddProduct(){
        this.router.navigate(['/addschedule']);
      }

}
