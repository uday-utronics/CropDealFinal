import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { AdminComponent } from './admin/admin.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavigationBarComponent } from './navigation-bar/navigation-bar.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatCardModule } from '@angular/material/card';
import { MatMenuModule } from '@angular/material/menu';
import {MatTabsModule} from '@angular/material/tabs';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AdminServicesService } from './Services/admin-services.service';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule } from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DataTablesModule } from 'angular-datatables';
import { MatPaginatorModule } from '@angular/material/paginator';
import { DealerComponent } from './dealer/dealer.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ToastrModule } from 'ngx-toastr';
import { TesterComponent } from './tester/tester.component';
import { FarmerComponent } from './farmer/farmer.component';



@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    AdminComponent,
    NavigationBarComponent,
    AdminDashboardComponent,
    DealerComponent,
    TesterComponent,
    FarmerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    MatTabsModule,
    HttpClientModule,
    MatTableModule,
    MatFormFieldModule,
    FormsModule,
    DataTablesModule,
    MatPaginatorModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    Ng2SearchPipeModule,
    ToastrModule.forRoot({

      positionClass :'toast-bottom-right'

    })
    
  ],
  providers: [AdminServicesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
