import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import OnboardeeDetails from './components/modles/onboardee-details';
import {SocialAuthService} from 'angularx-social-login';
import {SocialUser,GoogleLoginProvider} from 'angularx-social-login';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class OnboardeeServiceService {

  GET_ALL_Onboardee="/Onboarding/onboardee-list";
  DELETE_Onboardee="/Onboarding/onboardee-delete/";
  SET_Onboardee="/Onboarding/onboardee-add";
  UPDATE_Onboardee="/Onboarding/onboardee-update/";
  SHARED_DATA!:OnboardeeDetails;
  GROUP_Onboardee="/Onboarding/onboardee-group/";
  USER:SocialUser=new SocialUser();

  constructor(private http:HttpClient,private authservice:SocialAuthService,private route:Router) { }

getdata():Observable<any>
{
    return this.http.get(this.GET_ALL_Onboardee);
}
deletedata(id:number):Observable<any>
{
  return this.http.get(this.DELETE_Onboardee+id);
}

setdata(data:OnboardeeDetails):Observable<any>
{
  return this.http.post(this.SET_Onboardee,data);
}

update(data1:OnboardeeDetails,id:number):Observable<any>{
  console.log("service")
  console.log(data1);
  console.log(this.UPDATE_Onboardee+id);
  return this.http.put(this.UPDATE_Onboardee+id,data1);
}

groupbydata(col:String):Observable<any>{
  return this.http.get(this.GROUP_Onboardee+col);
}

signdata()
{
  this.authservice.authState.subscribe((user)=>{
    this.USER=user;
    this.route.navigate(['/Home']);
  });
}

signin()
{
  this.authservice.signIn(GoogleLoginProvider.PROVIDER_ID);
  this.signdata();
}
signout()
{
  this.authservice.signOut();
}

}
