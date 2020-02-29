import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  styles:[' div{ margin: 0 auto; text-align: center; width:200px;} .rotate{width:100px;height:100px;border:solid 1px red;}'],
  animations: [
    trigger("myanimation",[
      state('smaller', style({
        transform: "translateY(100px)"
      })),
      state('larger', style({
        transform: "translateY(0px)"
      })),
      transition("smaller <=> larger", animate("300ms ease-in"))
    ])
  ]
})
export class AppComponent {
  title = 'angularapp2';
  httpdata;
  name;
  searchparam = 2;
  formdata;
  emailid;
  myDate: Array<any>
  state: string = "smaller";
  animate(){
    this.state = this.state == 'larger' ? "smaller" : "larger";
  }
  constructor(private http : HttpClient){
  }

  ngOnInit(){
    this.http.get("http://jsonplaceholder.typicode.com/users?id=" + this.searchparam)
      .subscribe((data) => this.displayData(data));

      this.formdata = new FormGroup({
        emailid: new FormControl("", Validators.compose([
          Validators.required,
          Validators.pattern("[^ @]*@[^ @]*")
        ])),
        passwd: new FormControl("", this.passwordValidation)
      })
  }

  passwordValidation(formcontrol){
    if (formcontrol.value.length < 5) {
      return {"passwd": true};
    }
  }

  displayData(data){
    this.httpdata = data;
  }

  onClickSubmit(data){
    this.emailid = data.emailid;
  }
}
