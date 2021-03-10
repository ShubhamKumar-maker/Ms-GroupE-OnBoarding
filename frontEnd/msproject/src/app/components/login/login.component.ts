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

    user:SocialUser=new SocialUser();
  constructor(private authservice:SocialAuthService ,private route: Router) { }

  ngOnInit(): void {
    this.authservice.authState.subscribe((user)=>{
      this.user=user;
      sessionStorage.setItem("userToken",this.user.authToken);
      sessionStorage.setItem("image",this.user.photoUrl);
      sessionStorage.setItem("name",this.user.firstName);
      this.route.navigate(['/Home',{ value: this.user }]);
    })
  }

  signInWithGoogle():any{
    this.authservice.signIn(GoogleLoginProvider.PROVIDER_ID)
  }

  signOut():any{
    this.authservice.signOut();
    this.user=new SocialUser();
  }

beforEach()
{
  window.history.pushState({name: 'MyName', id: 1}, '', '');
}

}
