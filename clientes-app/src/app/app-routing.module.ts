import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DirectivaComponent } from './directiva/directiva/directiva.component';
import { ClientesComponent } from './clientes/clientes/clientes.component';
import { FormComponent } from './clientes/form/form.component';


const routes: Routes = [
	{path: '', redirectTo: '/clientes', pathMatch:'full'},
	{path: 'directivas', component: DirectivaComponent},
	{path: 'clientes', component: ClientesComponent},
	{path: 'clientes/form', component: FormComponent}  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
