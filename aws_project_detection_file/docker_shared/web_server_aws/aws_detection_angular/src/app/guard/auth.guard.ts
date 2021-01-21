import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { AuthService } from '../service/auth.service';



@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  res: number;

/*  ngOninit(){ this.res = this.authservice.data;
console.log('mmmmmmmmm', this.res)
    }*/

  ngOninit(){}

 /* this.res = this.authservice.data;
  console.log('mmmmmmmm', this.res)*/


  constructor(private router:Router,
      private authservice: AuthService){}

  canActivate(next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
    ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    this.res = this.authservice.data;
      console.log('mmmmmmmm', this.res, this.authservice.data, this.authservice);
       if (this.res != 1) {
        this.router.navigate(['/login']);
        return false;
  }
  return true;

}



}
