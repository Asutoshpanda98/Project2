
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddScheduleComponent } from './admin/add-schedule/add-schedule.component';
import { UpdatescheduleComponent } from './admin/updateschedule/updateschedule.component';
import { ViewAllScheduleComponent } from './admin/view-all-schedule/view-all-schedule.component';
import { ScheduleListComponent } from './admin/schedule-list/schedule-list.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { ApplicantComponent } from './applicant/applicant.component';
import { AdminComponent } from './admin/admin.component';
import { ViewAllScheduleComponentApplicant } from './applicant/view-all-schedule-applicant/view-all-schedule.component';

const routes: Routes = [
  { path: '', component:HomeComponentComponent },
  { path: 'addschedule', component:AddScheduleComponent },
  { path: 'schedule', component: ScheduleListComponent  },
  { path: 'update/:id', component:  UpdatescheduleComponent },
  { path: 'details/:id', component: ViewAllScheduleComponent },
  { path: 'detail/:id', component: ViewAllScheduleComponentApplicant  },
  { path: 'applicant', component: ApplicantComponent },
  { path: 'admin', component: AdminComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }