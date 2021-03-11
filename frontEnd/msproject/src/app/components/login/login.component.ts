import { Component, OnInit, ResolvedReflectiveFactory } from '@angular/core';
import {SocialAuthService} from 'angularx-social-login';
import {SocialUser,GoogleLoginProvider} from 'angularx-social-login';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { OnboardeeServiceService } from 'src/app/onboardee-service.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    mail:string="";
    patt = new RegExp(/accolitedigital.com$/g);
    user:SocialUser=new SocialUser();
  constructor(private authservice:SocialAuthService ,private route: Router,private service:OnboardeeServiceService) { }

  ngOnInit(): void {
    this.authservice.authState.subscribe((user)=>{
      if(this.patt.test(user.email))
      {
        this.user=user;
          sessionStorage.setItem("userToken",this.user.authToken);
          sessionStorage.setItem("image",this.user.photoUrl);
          sessionStorage.setItem("name",this.user.name);
          this.route.navigate(['/Home',{ value: this.user }]);
      }
      else{
        alert("Login with correct account");
        this.route.navigate(['/Login']);
        
      }

     
    })
    

    
  }

  signInWithGoogle():any{
    this.authservice.signIn(GoogleLoginProvider.PROVIDER_ID)
    this.service.signin();
    
  }

  signOut():any{
    this.authservice.signOut();
    this.user=new SocialUser();
  }



}
