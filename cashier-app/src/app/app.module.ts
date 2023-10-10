import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';
import { HomeComponent } from './component/Pages/home/home.component';
import { CardComponent } from './shared/card/card.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { LoginComponent } from './component/Pages/login/login.component';
import { RegisterComponent } from './component/Pages/register/register.component';
import { TransactionComponent } from './component/Pages/transaction/transaction.component';
import { CreditCardComponent } from './component/Pages/credit-card/credit-card.component';
import { MetricComponent } from './component/Pages/metric/metric.component';
import { HelpResponseComponent } from './component/Pages/helpPages/help-response/help-response.component';
import { HelpRequestComponent } from './component/Pages/helpPages/help-request/help-request.component';
import { RouterModule } from '@angular/router';
import { HelpComponent } from './component/Pages/helpPages/help/help.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CardComponent,
    SidebarComponent,
    LoginComponent,
    RegisterComponent,
    TransactionComponent,
    MetricComponent,
    CreditCardComponent,
    FooterComponent,
    HeaderComponent,
    HelpComponent,
    HelpResponseComponent,
    HelpRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
