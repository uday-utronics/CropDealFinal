import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminComponent } from './admin/admin.component';
import { DealerComponent } from './dealer/dealer.component';
import { FarmerComponent } from './farmer/farmer.component';
import { LandingPageComponent } from './landing-page/landing-page.component';

const routes: Routes = [

  {path: 'landing',component: LandingPageComponent},
  {path: 'admin',component: AdminComponent},
  {path:'dashboard', component: AdminDashboardComponent},
  {path: '',redirectTo:'/landing',pathMatch:'full'},
  {path: 'admin/dashboard',component:AdminDashboardComponent},
  {path: 'dealer',component:DealerComponent},
  {path:'farmer', component:FarmerComponent}
  // {path: 'admin',redirectTo:'/landing',pathMatch:'full'},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
