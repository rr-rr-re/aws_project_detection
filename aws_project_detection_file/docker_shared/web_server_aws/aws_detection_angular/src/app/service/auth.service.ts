import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';



@Injectable({
  providedIn: 'root'
})
export class AuthService  {

  constructor() { }
public data: number = 0;

  /*setMessege(aaa: number) {
    this.data = aaa;
    console.log('xxxxxxxxxx', this.data)
  }*/

/*  public dataChanged = new Subject<number>();
  public sharedDataSource$ = this.dataChanged.asObservable();*/
  public onNotifySharedDataChanged(update: number) {
    this.data = update;
    console.log('xxxxxxxxxxx', update, this.data )
  }

  ngOnInit() {
  }

}
