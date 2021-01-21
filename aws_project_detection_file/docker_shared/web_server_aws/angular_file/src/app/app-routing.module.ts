import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HeroesComponent } from './heroes/heroes.component';
import { HeaderComponent } from './header/header.component';
import { LogInComponent } from './log-in/log-in.component';
import { MenuComponent } from './menu/menu.component';

import { AuthGuard } from './guard/auth.guard';

const routes: Routes = [
  { path: '', redirectTo: '/log-in', pathMatch: 'full' },

  { path: 'heroes',
    component: HeroesComponent,
    canActivate: [AuthGuard]
  },
  { path: 'menu',
    component: MenuComponent,
    canActivate: [AuthGuard]
  },

  { path: 'heroes', component: HeroesComponent },
  { path: 'header', component: HeaderComponent },
  { path: 'log-in', component: LogInComponent },
  { path: 'menu', component: MenuComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
