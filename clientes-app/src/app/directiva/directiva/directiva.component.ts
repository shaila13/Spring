import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva',
  templateUrl: './directiva.component.html',
  styleUrls: ['./directiva.component.css']
})
export class DirectivaComponent implements OnInit {
  listaCurso: string[] = ['TypeSript', 'javaSript', 'Java SE', 'C#', 'PHP'];
  habilitar: boolean = true;
  nameBoton: string = 'Ocultar';
  constructor() { }

  ngOnInit() {
  }
  procesarEvento(): void {
    this.habilitar =(this.habilitar==true) ? false : true;
    this.habilitar ? this.nameBoton='Ocultar' : this.nameBoton='Mostrar';
  }
}
