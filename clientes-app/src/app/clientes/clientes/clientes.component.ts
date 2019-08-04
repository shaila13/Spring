import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteServicesService } from 'src/app/services/cliente-services.service';



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {
  isLoggedIn = false;
  longitudClientes: number;
  clientes: Cliente[];
  constructor(private clienteService: ClienteServicesService) {

  }

  ngOnInit() {
    this.clienteService.getClientes().subscribe(
      clientes => {
        this.clientes = clientes;
        this.longitudClientes = clientes.length;
        (this.longitudClientes == 0) ? this.isLoggedIn = false : this.isLoggedIn = true;
      }
    );

  }

  delete(cliente: Cliente): void {

    this.clienteService.delete(cliente.id).subscribe(response =>
      this.clientes = this.clientes.filter(cli => cli !== cliente)
    )
  }


}
