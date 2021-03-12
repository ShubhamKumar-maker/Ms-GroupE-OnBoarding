import { escapeIdentifier } from '@angular/compiler/src/output/abstract_emitter';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {OnboardeeServiceService} from '../../../onboardee-service.service';
import onboardee from '../../modles/onboardee-details';
import {SocialAuthService} from 'angularx-social-login';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  p:number=1;
  DELETE_MESSAGE:String="";
  SEARCH_NAME:String="";
  onboardee:Array<onboardee>=[];
  OPTION="name";
  
 

  constructor(private route: Router,private service:OnboardeeServiceService,private authservice:SocialAuthService ) { }
  selectedName!:string;

  ngOnInit(): void {

    
    this.service.getdata().subscribe((data)=>{
      console.log(data);
      this.onboardee=data;
      console.log(this.onboardee);


      if(!sessionStorage.getItem('userToken'))
      {
          this.route.navigate(['/Login']);
      }





    })

    
  }

  create()
  {
    this.route.navigate(['/Onboard/Create']);

  }
  delete(id:number)
  {
    this.service.deletedata(id).subscribe((data)=>{
      console.log(data);
      this.DELETE_MESSAGE="Onboardee Deleted";
      this.service.getdata().subscribe((list)=>{
        this.onboardee=list;
      })

    })
  }
  view(data:onboardee){
    this.service.SHARED_DATA=data;
    this.route.navigate(['/Onboard/View']);

  }
  edit(data2:onboardee){
    this.service.SHARED_DATA=data2;
    this.route.navigate(['/Onboard/Update']);
    
  }
  trends(){
    this.route.navigate(['/Onboard/Trends']);
  }
  search(event:any)
  {
      this.SEARCH_NAME=event.target.value;
      console.log(this.SEARCH_NAME);
      if (this.SEARCH_NAME=="")
      {
          this.ngOnInit();
      }
      else if(this.selectedName=="name")
      {
        this.onboardee=this.onboardee.filter(res=>{
          return res.name.toLocaleLowerCase().trim().match(this.SEARCH_NAME.toLocaleLowerCase());
        })
      }
      else if(this.selectedName=="email")
      {
        this.onboardee=this.onboardee.filter(res=>{
          return res.email.toLocaleLowerCase().trim().match(this.SEARCH_NAME.toLocaleLowerCase());
        })

      }
      else if(this.selectedName=="location")
      {
        this.onboardee=this.onboardee.filter(res=>{
          return res.location.toLocaleLowerCase().trim().match(this.SEARCH_NAME.toLocaleLowerCase());
        })

      }
      else if(this.selectedName=="hiringmanager")
      {
        this.onboardee=this.onboardee.filter(res=>{
          return res.msHiringManager.toLocaleLowerCase().trim().match(this.SEARCH_NAME.toLocaleLowerCase());
        })
      }
  }
  
  changefun(){

    console.log(this.selectedName);

  }

  signout(){
    this.authservice.signOut();
    sessionStorage.clear();

  }

  reset(){
    this.ngOnInit();
  }


}
