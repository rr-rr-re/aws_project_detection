import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- NgModel lives here

import { AppComponent } from './app.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroService } from './service/hero.service';
//import { JsonpModule } from '@angular/http';


import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import {  } from 'rxjs/add/operator/toPromise';
import { MenuComponent } from './menu/menu.component';
import { HeaderComponent } from './header/header.component';
import { LogInComponent } from './log-in/log-in.component';

import { AuthService } from './service/auth.service';
import { AuthGuard } from './guard/auth.guard';



@NgModule({

  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,

  ],

  declarations: [
    AppComponent,
    HeroesComponent,
    MenuComponent,
    HeaderComponent,
    LogInComponent,
  ],

  providers: [HeroService,
    AuthService,
    AuthGuard
],
  bootstrap: [ AppComponent ],
})

export class AppModule {}
