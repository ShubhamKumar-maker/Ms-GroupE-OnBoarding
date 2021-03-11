import { Component, OnInit } from '@angular/core';
import { ChartOptions, ChartType, ChartDataSets } from 'chart.js';
import { Label } from 'ng2-charts';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import {OnboardeeServiceService} from '../../../onboardee-service.service';
import onboardee from '../../modles/onboardee-details';

interface groupdata{
  value:number,
  data:any
}

@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.scss']
})

export class TrendsComponent implements OnInit {
  userToken:any="";

  data!:Array<groupdata>;
  COLUM_VALUE!:String;
  barChartLabels!:Array<string>;
  ChartData=new Array();
  barChartData!:ChartDataSets[];
  selectedName!:string;

  public barChartOptions: ChartOptions = {
    responsive: true,
  };
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;
  public barChartPlugins = [];

  


  constructor(private router: Router,private service:OnboardeeServiceService) { }

  ngOnInit(): void {
    this.userToken=sessionStorage.getItem("userToken");
    if(this.userToken==null)
    {
      this.router.navigate(['/Login']);
    }
    

    this.barChartData = [
      { 
        data: [],label: 'Series A'
      },
    ];

  }

  groupdata()
  {
    this.barChartLabels = new Array<string>();
    this.ChartData =new Array<number>();



    console.log(this.data);
      for(const item of this.data)
      {
        this.barChartLabels.push(item.data);
        
        this.ChartData.push(item.value);
        console.log(item.value);
        console.log(item.data);
      }

      this.ChartData.forEach((element:number) => {
         this.barChartData[0].data?.push(element);
        console.log(element)
        
      });
  }
  changefun()
  {
    this.COLUM_VALUE=this.selectedName;
    this.service.groupbydata(this.COLUM_VALUE).subscribe((result)=>{
      this.data=result;
    })
    this.ngOnInit();
  }

}
