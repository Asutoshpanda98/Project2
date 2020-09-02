import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ScheduleEntity } from './scheduleentity';

@Injectable({
  providedIn: 'root'
})
export class ScheduleProgramService {

  


  constructor(private http:HttpClient) { }

  getAllSchedule(): Observable<any> {
    return this.http.get<any>("http://localhost:9091/schedule/getallschedules");
  }

  getScheduleById(id: string): Observable<any> {
    return this.http.get<any>("http://localhost:9091/schedule/getschedulebyid/"+id);
  }666

  addSchedule(scheduleEntity: Object): Observable<Object> {
    return this.http.post<any>("http://localhost:9091/schedule/addschedule", scheduleEntity);
  }

  updateScheduleById(id: String, scheduleEntity: Object): Observable<Object> {
    return this.http.put<any>("http://localhost:9091/schedule/updateschedule/"+id, scheduleEntity);
  }

  deleteScheduleById(id: String): Observable<any> {
    return this.http.delete<any>("http://localhost:9091/schedule/deleteschedule/"+id);
  }
}
