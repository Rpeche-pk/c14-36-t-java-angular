import { Component, ElementRef, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { UserData } from 'src/app/interfaces/userData.inteface';
import { TokenService } from 'src/app/services/token.service';
// import { AuthTimerService } from 'src/app/services/auth-timer.service';
// import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss']
})
export class UserDashboardComponent {
 
  UserData!: UserData;
  sidebarStatus!:boolean;

  constructor(private route: Router,
    private tokenService: TokenService
  ) { }

  ngOnInit(): void {

    this.UserData = this.tokenService.getTokenDecoded()
    console.log(this.UserData);

  }
  @ViewChild('sideBar', { read: ElementRef }) sideBar!: ElementRef;

  updateSidebarState(newStatus:boolean){
    this.sidebarStatus = newStatus;
      this.sideBar.nativeElement.classList.toggle("sidebarCollapse")

  }

}
