import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class OnboardeeServiceService {

  GET_ALL_Onboardee="/Onboarding/onboardee-list";
  DELETE_Onboardee="/Onboarding/onboardee-delete/";

  constructor(private http:HttpClient) { }

getdata():Observable<any>
{
    return this.http.get(this.GET_ALL_Onboardee);
}
deletedata(id:number):Observable<any>
{
  return this.http.get(this.DELETE_Onboardee+id);
}




}
