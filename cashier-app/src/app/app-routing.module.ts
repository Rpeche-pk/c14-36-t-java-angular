import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/Pages/home/home.component';
import { DashboardComponent } from './component/Pages/dashboard/dashboard.component';


import { LoginComponent } from './component/Pages/login/login.component';
import { RegisterComponent } from './component/Pages/register/register.component';
import { HelpComponent } from './component/Pages/helpPages/help/help.component';
import { HelpRequestComponent } from './component/Pages/helpPages/help-request/help-request.component';
import { HelpResponseComponent } from './component/Pages/helpPages/help-response/help-response.component';
import { HelpQuestionResComponent } from './component/Pages/helpPages/help-question-res/help-question-res.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login',component: LoginComponent },
  {path: 'register',component: RegisterComponent },
  {path:'help', component:HelpComponent, children:[
    {path:'', redirectTo:'helpReq', pathMatch:'full'},
    {path:'helpReq', component:HelpRequestComponent},
    {path:'helpRes/:id', component:HelpResponseComponent},
    {path :'helpQuestionRes/:id', component:HelpQuestionResComponent}
  ]},
  {path: 'dashboard', component:DashboardComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
