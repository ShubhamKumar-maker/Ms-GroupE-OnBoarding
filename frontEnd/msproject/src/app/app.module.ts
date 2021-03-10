import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { SocialLoginModule } from 'angularx-social-login';
import { SocialAuthServiceConfig } from 'angularx-social-login';
import {
  GoogleLoginProvider
} from 'angularx-social-login';
import { ViewComponent } from './components/OnboardHome/view/view.component';
import { CreateComponent } from './components/OnboardHome/create/create.component';
import { TrendsComponent } from './components/OnboardHome/trends/trends.component';
import {HttpClientModule} from '@angular/common/http';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2OrderModule} from 'ng2-order-pipe';
import {Ng2SearchPipeModule} from 'ng2-search-filter';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ViewComponent,
    CreateComponent,
    TrendsComponent,
    
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SocialLoginModule,
    HttpClientModule,
    NgxPaginationModule,
    Ng2OrderModule,
    Ng2SearchPipeModule
  ],
  providers: [{
    provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '204637019435-8f9gfa3e5rbvukbq5v0oa8dlei8p35tt.apps.googleusercontent.com'
            )
          }
        ]
      } as SocialAuthServiceConfig,

  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
