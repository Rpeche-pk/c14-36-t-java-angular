import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/Pages/home/home.component';
import { LoginComponent } from './component/Pages/login/login.component';
import { HelpComponent } from './component/Pages/helpPages/help/help.component';
import { HelpRequestComponent } from './component/Pages/helpPages/help-request/help-request.component';
import { HelpResponseComponent } from './component/Pages/helpPages/help-response/help-response.component';

const routes: Routes = [
  {path: '', component:HomeComponent},
  {path: 'login',component: LoginComponent },
  {path:'help', component:HelpComponent, children:[
    {path:'', redirectTo:'/helpReq', pathMatch:'full'},
    {path:'helpReq', component:HelpRequestComponent},
    {path:'helpRes', component:HelpResponseComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
