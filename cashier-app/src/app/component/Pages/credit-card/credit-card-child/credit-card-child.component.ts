import { Component, EventEmitter, Input, Output } from '@angular/core';
import { IGetCardRes } from 'src/app/interfaces/response.interface';

@Component({
  selector: 'app-credit-card-child',
  templateUrl: './credit-card-child.component.html',
  styleUrls: ['./credit-card-child.component.scss']
})
export class CreditCardChildComponent {
  @Output() emitShowStatus = new EventEmitter<boolean>();
  @Input() show!:boolean;
  @Input() cardData!:IGetCardRes;

  windowClose(){
    this.emitShowStatus.emit(false);
  }
}
