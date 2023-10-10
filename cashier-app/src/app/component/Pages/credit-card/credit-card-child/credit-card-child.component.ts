import { BootstrapOptions, Component, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-credit-card-child',
  templateUrl: './credit-card-child.component.html',
  styleUrls: ['./credit-card-child.component.scss']
})
export class CreditCardChildComponent implements OnInit{

  window: boolean = true;

  ngOnInit(): void {
    this.window = true;
  }
  
  windowClose(){
    this.window = !this.window;
  }
}
