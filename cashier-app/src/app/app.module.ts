import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
//import { TarjetaComponent } from './tarjeta/tarjeta.component'; ESTE COMPONENTE A CUAL CORRESPONDE?
import { DashboardComponent } from './component/Pages/dashboard/dashboard.component';
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
import { HelpComponent } from './component/Pages/helpPages/help/help.component';
import { HelpQuestionResComponent } from './component/Pages/helpPages/help-question-res/help-question-res.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CardComponent,
    SidebarComponent,
    //TarjetaComponent, A CUAL COMPONENTE CORRESPONDE?
    LoginComponent,
    RegisterComponent,
    TransactionComponent,
    MetricComponent,
    CreditCardComponent,
    FooterComponent,
    HeaderComponent,
    DashboardComponent,
    HelpComponent,
    HelpResponseComponent,
    HelpRequestComponent,
    HelpQuestionResComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AppRoutingModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
