import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { MyserviceService } from './myservice.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule  } from '@angular/forms';
import { AppComponent } from './app.component';
import { MewCmpComponent } from './mew-cmp/mew-cmp.component';
import { FormsModule } from '@angular/forms';
import { MatButtonModule, MatMenuModule, MatSidenavModule } from '@angular/material';

@NgModule({
  declarations: [
    AppComponent,
    MewCmpComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatMenuModule,
    MatSidenavModule
  ],
  providers: [MyserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
