import { escapeIdentifier } from '@angular/compiler/src/output/abstract_emitter';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {OnboardeeServiceService} from '../../../onboardee-service.service';
import onboardee from '../../modles/onboardee-details';


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

  constructor(private route: Router,private service:OnboardeeServiceService) { }

  ngOnInit(): void {
    this.service.getdata().subscribe((data)=>{
      console.log(data);
      this.onboardee=data;
      console.log(this.onboardee);
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
  view(){
    this.route.navigate(['/Onboard/View']);

  }
  edit(){
    
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
      else if(this.OPTION=="name")
      {
        this.onboardee=this.onboardee.filter(res=>{
          return res.name.toLocaleLowerCase().match(this.SEARCH_NAME.toLocaleLowerCase());
        })
      }
  }

}
