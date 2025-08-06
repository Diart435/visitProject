import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ServiceListComponent } from './pages/service-list/service-list.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { ContactsComponent } from './pages/contacts/contacts.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {path:'', redirectTo:'/home', pathMatch:'full'},
  {path:'home', component:HomeComponent},
  {path:"service", component:ServiceListComponent},
  {path:"contacts", component:ContactsComponent},
  {path:"**", component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
