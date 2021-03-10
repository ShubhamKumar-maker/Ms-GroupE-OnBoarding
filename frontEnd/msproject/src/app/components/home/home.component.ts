import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {SocialAuthService} from 'angularx-social-login';
import {SocialUser,GoogleLoginProvider} from 'angularx-social-login';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    userToken:any="";
    name:any="";
    photourl:any="";
    @Input() user:any;
    value:any;
  constructor(private router: Router, private route: ActivatedRoute,private authservice:SocialAuthService) {
    this.route.params.subscribe(params => {
      this.value = params['value'];
      console.log(this.value);
});
   }

  ngOnInit(): void {

    this.userToken=sessionStorage.getItem("userToken");
    this.name=sessionStorage.getItem("name");
    this.photourl=sessionStorage.getItem("image");
    if(this.userToken==null)
    {
      this.router.navigate(['/Login']);
    }
    
  }

  signout()
  {
    this.authservice.signOut();
    this.router.navigate(['/Login']);
  }
  

}
