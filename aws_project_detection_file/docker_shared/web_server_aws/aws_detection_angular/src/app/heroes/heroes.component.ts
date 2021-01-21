import { Component, OnInit, Output, Input, ViewChild, ElementRef } from '@angular/core';
import { FormsModule } from '@angular/forms';

//import { MessageService } from '../message.service';
import { HeroService } from '../service/hero.service';
import { HttpClient, HttpParams, HttpRequest, HttpResponse } from '@angular/common/http';
import { UserDto } from '../user';


import { Observable, of, fromEvent, from, pipe } from 'rxjs';
import { analyzeFileForInjectables } from '@angular/compiler';
import { formatDate, UpperCasePipe } from '@angular/common';
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';
import { catchError, map, tap } from 'rxjs/operators';
import { decimalDigest } from '@angular/compiler/src/i18n/digest';


@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent  {

image: string | ArrayBuffer = ""; ///表示する画像を記入
file: File = null;
reader: String;
data: UserDto[];
public files: any[]; //画像を選択して格納するプロパティ
up: UserDto[]; ///表示するjson
imging: string | ArrayBuffer = "";
a: string;

constructor(private heroService: HeroService,
            private http: HttpClient,) {
              this.files = [];
            }




///////////ファイルが選択されたらContentにデータを格納////////////////////
onSelect(event){
  //fileが選択されていなければリセット
  if (event.target.files.length === 0) {
    this.file = null;
    this.image = "";
    return;
  }

  //ファイルの情報をfileとimgSrcに保存
  let reader = new FileReader();
  this.file = event.target.files[0];

  reader.onload = () => {
    this.image = reader.result;

  }
  reader.readAsDataURL(this.file);////FileReaderのreadAsDataURL()で、ファイルの内容をimg要素のsrcに設定できる文字列（DataURL）として読み込む

 }

/////////////設定ファイルのアップロード//////////////////////////

upImg(event){
  console.log('wertyuiopoiu',this.image);

  this.a = this.image.toString();

  console.log('bbbbbbbbbbbbbbb', this.a);
  this.heroService.posting(this.a)  //////引数にストリングの変数を指定　ここにPOSTしたいデータをいれる
  .subscribe(
    (data) => {console.log(data)},
    (error) => {console.log(error)}
  );
  console.log(this.file, this.a, this.image)
}

////////////取得画像の表示//////////////////////
showing(event) {
 this.heroService.getHeroes()
  .subscribe(
    (result) => {
      this.data = result;
      const eee = this.data['img'];
      this.imging = 'data:image/jpeg;base64,' + eee;
      console.log('aaaaaaaaaaaaaaaaaaaaa', this.imging);
     })
    }
}
