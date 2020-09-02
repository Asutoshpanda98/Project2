import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Router } from '@angular/router';
import { ScheduleProgramService } from 'src/app/schedule-program.service';
import { ScheduleEntity } from 'src/app/scheduleentity';


@Component({
  selector: 'app-updateschedule',
  templateUrl: './updateschedule.component.html',
  styleUrls: ['./updateschedule.component.css']
})
export class UpdatescheduleComponent implements OnInit {

  id: string;
  scheduleentity: ScheduleEntity;
  
  constructor(private route: ActivatedRoute,private router: Router, private scheduleprogramservice: ScheduleProgramService) { }

  ngOnInit(): void {
    this.scheduleentity = new ScheduleEntity();
    
    this.id = this.route.snapshot.params['id'];

    this.scheduleprogramservice.getScheduleById(this.id)
      .subscribe(data => {
        console.log(data)
        this.scheduleentity = data;
      }, error => console.log(error));
  }
     updateScheduleById()
     {
      this.scheduleprogramservice.updateScheduleById(this.id, this.scheduleentity)
      .subscribe(data => console.log("updated succesfully"), error => console.log(error));
       this.scheduleentity = new ScheduleEntity();
        this.gotoList();
     }
     onSubmit() {
    
      this.updateScheduleById();    
    }
  
    gotoList() {
        
      this.router.navigate(['/schedule']);
    }

  }


