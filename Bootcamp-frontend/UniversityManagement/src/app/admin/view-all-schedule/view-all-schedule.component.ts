import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ScheduleEntity } from 'src/app/scheduleentity';
import { ScheduleProgramService } from 'src/app/schedule-program.service';


@Component({
  selector: 'app-view-all-schedule',
  templateUrl: './view-all-schedule.component.html',
  styleUrls: ['./view-all-schedule.component.css']
})
export class ViewAllScheduleComponent implements OnInit {

  id: string;
  scheduleentity: ScheduleEntity;


  constructor(private route: ActivatedRoute,private router: Router, private scheduleprogramservice: ScheduleProgramService) { }

  ngOnInit(): void {

    this.scheduleentity = new ScheduleEntity();

    this.id = this.route.snapshot.params['id'];
    
    this.scheduleprogramservice. getScheduleById(this.id)
    .subscribe(data => {
      console.log(data)
      this.scheduleentity = data;
    }, error => console.log(error));
  }
  list(){
    this.router.navigate(['/schedule']);
  }

}
