import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {OnboardeeServiceService} from '../../../../onboardee-service.service';
import OnboardeeDetails from '../../../modles/onboardee-details';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {
  data!:OnboardeeDetails;
  form1:any;
  payload!:OnboardeeDetails;

  constructor(private route: Router,private service:OnboardeeServiceService) { }

  ngOnInit(): void {

    if(!sessionStorage.getItem('userToken'))
    {
        this.route.navigate(['/Login']);
    }


      this.form1=new FormGroup({
        onboardeeId:new FormControl(''),
        name: new FormControl(''),
        email:new FormControl("",[Validators.required,Validators.email]),
        address:new FormControl("",[Validators.required,Validators.minLength(5)]),
        contactNumber:new FormControl("",[Validators.required]),
        location:new FormControl("",Validators.required),
        eta:new FormControl("",Validators.required),
        msHiringManager:new FormControl("",Validators.required),
        bgcstatus:new FormControl("",Validators.required),
        onboardingStatus:new FormControl("",Validators.required),
        skills:new FormControl("",Validators.required),
        demandId:new FormControl("",Validators.required),
        onboardingDate:new FormControl("",Validators.required),
        creationdate:new FormControl(''),
        modificationtime:new FormControl('')
      })  
    
    this.data=this.service.SHARED_DATA;
    this.data.modificationtime=new Date();
    this.form1.setValue(this.data);
    
  }

  onSubmit(){
    this.payload=this.form1.value;
    console.log(this.payload);
    this.service.update(this.payload,this.payload.onboardeeId).subscribe((data)=>{
      console.log("sucessfully update");
      console.log(data);
      alert("data updated");
      this.route.navigate(['/Onboard/Home'])
      

    })
    
    
  }

}
