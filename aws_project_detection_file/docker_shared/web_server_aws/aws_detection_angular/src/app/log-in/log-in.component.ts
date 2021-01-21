import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Userlog } from '../User.log';
import { HeroService } from '../service/hero.service'
import { Subscription } from 'rxjs';

import { AuthGuard } from '../guard/auth.guard';
import { AuthService } from '../service/auth.service';


@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(private service: HeroService,
     // private subscription: Subscription,
      private session: AuthService,
      private auth: AuthGuard) { }

  ngOnInit(): void {
  }

User: Userlog = {
  username: '',
  password: ''
}
up:number;
show:string;

uplog(event) {
  this.service.postlogin(this.User)  //////引数にストリングの変数を指定　ここにPOSTしたいデータをいれる
  .subscribe(
    (data:number) => {
      this.up = data;
      this.session.data = this.up;
     /* this.session.setMessege(this.up);*/
      this.session.onNotifySharedDataChanged(this.up)
      console.log('cccccccccccccccc', this.up, this.session)
    //  this.auth.canActivate;
      if (this.up != 1){
        this.show = "認証されませんでした。";
      }
    },
    (error) => {console.log(error)}
  );
}

}
