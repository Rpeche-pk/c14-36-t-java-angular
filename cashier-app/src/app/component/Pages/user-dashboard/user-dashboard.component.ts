import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.scss']
})
export class UserDashboardComponent {
  sidebarStatus!:boolean;
  @ViewChild('sideBar', { read: ElementRef }) sideBar!: ElementRef;

  updateSidebarState(newStatus:boolean){
    this.sidebarStatus = newStatus;
      this.sideBar.nativeElement.classList.toggle("sidebarCollapse")

  }

}
