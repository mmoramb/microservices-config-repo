import { Component } from '@angular/core';
import { MyserviceService } from './myservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private myservice: MyserviceService){
  }
  todayDate;
  componentproperty;
  ngOnInit(){
    this.todayDate = this.myservice.showTodayDate();
    console.log(this.myservice.serviceProperty)
    this.myservice.serviceProperty = "component created"; //value is changed
    this.componentproperty = this.myservice.serviceProperty;
    console.log(this.componentproperty)
  }

  title = 'angularExample';
  months = ["January", "Feburary", "March", "April", "May", 
            "June", "July", "August", "September",
            "October", "November", "December"];
  isavailable = true;   //variable is set to true

  myClickFunction(event){
    alert("button is clicked");
    console.log(event);
  }

  changemonths(event){
    alert("Changed month from the Dropdown");
  }


}
