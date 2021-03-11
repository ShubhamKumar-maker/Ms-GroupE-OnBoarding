import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import OnboardeeDetails from '../../modles/onboardee-details';
import {OnboardeeServiceService} from '../../../onboardee-service.service';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  datapayload!:OnboardeeDetails;

  form=new FormGroup({
    name: new FormControl("", Validators.required),
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
    creationdate:new FormControl(new Date().toISOString()),
  });
  
  constructor(private service:OnboardeeServiceService,private route:Router) { }

  ngOnInit(): void {

    if(!sessionStorage.getItem('userToken'))
    {
        this.route.navigate(['/Login']);
    }
    
    
    
  
    
  }
  onSubmit(){
    this.datapayload=this.form.value;
    alert(JSON.stringify(this.datapayload));
    console.log(this.datapayload);
    this.savedata();
  }
  
  savedata(){
    this.service.setdata(this.datapayload).subscribe((data)=>{
      console.log("data");
        console.log("data sucessfully save");
    
    })
  }

}
