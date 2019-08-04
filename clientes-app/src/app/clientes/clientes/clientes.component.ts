import { Component, OnInit } from '@angular/core';
import { Cliente } from '../cliente';
import { ClienteServicesService } from 'src/app/services/cliente-services.service';



@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[];
  constructor(private clienteService: ClienteServicesService) { }

  ngOnInit() {
    this.clienteService.getClientes().subscribe(
      clientes => this.clientes = clientes
    );
  }
  delete(cliente: Cliente): void {

    this.clienteService.delete(cliente.id).subscribe(response =>
      this.clientes = this.clientes.filter(cli => cli !== cliente)
    )
  }
}
