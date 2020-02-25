import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MyserviceService {
  serviceProperty = "Service crested";
  constructor() { }

  showTodayDate(){
    let ndate = new Date();
    return ndate;
  }
}
