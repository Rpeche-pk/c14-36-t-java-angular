import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { CardComponent } from './card/card.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { TarjetaComponent } from './tarjeta/tarjeta.component';
import { LoginComponent } from './component/pages/login/login.component';
import { RegisterComponent } from './component/pages/register/register.component';
import { TransactionComponent } from './component/pages/transaction/transaction.component';
import { MetricComponent } from './component/pages/metric/metric.component';
import { CreditCardComponent } from './component/pages/credit-card/credit-card.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CardComponent,
    SidebarComponent,
    TarjetaComponent,
    LoginComponent,
    RegisterComponent,
    TransactionComponent,
    MetricComponent,
    CreditCardComponent,
    FooterComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
