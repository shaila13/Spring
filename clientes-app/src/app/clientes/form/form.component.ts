import { Component, OnInit } from '@angular/core';
import {Cliente} from '../cliente';
import { ClienteServicesService } from 'src/app/services/cliente-services.service';
import {Router, ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  private cliente: Cliente = new Cliente()
  private titulo: string = "Crear Cliente"

  constructor(private clienteService: ClienteServicesService,
              private router: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.cargarCliente()
  }

  cargarCliente(): void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.clienteService.getCliente(id).subscribe( (cliente) => this.cliente = cliente);
      }
    })
  }

  create(): void {
    this.clienteService.create(this.cliente)
      .subscribe(cliente => {
        this.router.navigate(['/clientes'])
        alert(`Cliente ${cliente.nombre} creado con éxito!`);
      }
      );
  }

  update():void{
    this.clienteService.update(this.cliente)
    .subscribe( cliente => {
      this.router.navigate(['/clientes'])
      alert(`Cliente ${cliente.nombre} actualizado con éxito!`);
    }

    )
  }}
