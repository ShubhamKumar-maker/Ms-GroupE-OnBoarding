import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {OnboardeeServiceService} from '../../../onboardee-service.service';
import OnboardeeDetails from '../../modles/onboardee-details';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrls: ['./view.component.scss']
})
export class ViewComponent implements OnInit {
  userToken:any="";
  




    data!:OnboardeeDetails;
  form1=new FormGroup({

  })

  constructor(private service:OnboardeeServiceService,private router:Router) { }

  ngOnInit(): void {

    this.userToken=sessionStorage.getItem("userToken");
    if(this.userToken==null)
    {
      this.router.navigate(['/Login']);
    }
    console.log(this.service.SHARED_DATA);
    this.data=this.service.SHARED_DATA;
    console.log(this.data);
  }


}
