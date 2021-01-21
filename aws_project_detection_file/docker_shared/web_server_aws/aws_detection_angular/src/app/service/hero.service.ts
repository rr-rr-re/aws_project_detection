import { Injectable } from '@angular/core';

import {} from 'rxjs/add/operator/toPromise';

import { Observable, of, fromEvent, pipe, throwError, identity } from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from '@angular/common/http';
import { catchError, map, sample, tap } from 'rxjs/operators';
import { Data } from '@angular/router';
import { UserDto } from '../user';
import { Userlog } from '../User.log';



@Injectable({
  providedIn: 'root'
})

export class HeroService {

data: UserDto[];
fff : UserDto[];
//webserverのURL
public hostUrl = 'http://13.113.255.82:8080'; //web api URLとして

public  httppostOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'multipart/form-data',
     })
  };

public  httpOptions = {
    headers: new HttpHeaders({
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
     })
  };

  constructor(private http: HttpClient)  {
    // `Authorization` に `Bearer トークン` をセットする
    this.setAuthorization('my-auth-token');
  }

  string_to_buffer(src) {
    return (new ArrayBuffer([].map.call(src, function(c) {
      return c.charCodeAt(0)
    })));
  }


  // ArrayBuffer から文字列への変換

  buffer_to_string(buf) {
    return String.fromCharCode.apply("", new Uint16Array(buf))
  }

  /////////////serverからget//////////////////this.host + '/get'
  public getHeroes(): Observable<UserDto[]> {
      return this.http.get<UserDto[]>('http://13.113.255.82:8080/practice1/sample/sample2/getSample', this.httpOptions)
      .pipe(
      catchError(this.handleError<UserDto[]>('getHeroes', []))
      );
  }

  public posting(e):Observable<UserDto[]> {
    const aaa = new UserDto;
    aaa.flSrcImageId = 1;
    aaa.filename = "test";
    aaa.img = e.replace('data:image/jpeg;base64,', '');

    console.log('beforpost', aaa);
    let postdata = JSON.stringify( aaa );
    console.log('afterpost', postdata);
    return this.http.post<UserDto[]>('http://13.113.255.82:8080/practice1/sample/sample2/postSample', postdata, this.httpOptions)
    .pipe(
      catchError(this.handleError),
    );
  }

  /**
   *
   * @param operation - 失敗した操作の名前
   * @param result - observableな結果として返す任意の値
   * 失敗したHttp操作を処理します。
   * アプリを持続させます。*/

  handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      //TODO: リモート上のロギング基盤にエラーを送信する
      console.error(error); //かわりにConsoleに出力

      //TODO: ユーザへの開示のためにエラーの変換処理を改善する
      console.log(`${operation} failed: ${error.message}`);

      //　空の結果を返して、アプリを持続可能にする
      return of(result as T);
    };
  }

  public setAuthorization(token: string = null): void {
    if (!token) {
      return;
    }
    const bearerToken: string = `Bearer ${token}`;
    this.httpOptions.headers = this.httpOptions.headers.set('Authorization', bearerToken);
  }
  private zzz: Userlog;
  public postlogin(aa: Userlog): Observable<any> {
    this.zzz = aa;
    let eee = this.zzz;
    console.log('aaaaaaaaaaaa', eee)
   // let postdata = JSON.stringify( eee );
    return this.http.post<Userlog[]>('http://13.113.255.82:8080/practice1/sample/sample2/postlogin', eee, this.httpOptions)
    .pipe(
      catchError(this.handleError),
    );
}
}
