import { Component } from '@angular/core';

@Component({
  selector: 'soma-component'
  ,templateUrl: 'soma.component.html'
  ,styleUrls: ['soma.component.css']
})
export class SomaComponent{
  numero1 : number = 0;
  numero2 : number = 0;
  numero3 : number = 0;
  numero4 : number = 0;
  numero5 : number = 0;

  nomes : string[] = ['josé', 'matheus']

  somar() : void {
    let total = Number(this.numero1) + Number(this.numero2);
    alert('a soma é '+total);
  }

  par() : void {
    let resultado = '';
    if(Number(this.numero3) % 2 == 0){
      resultado = 'par';
    } else{
      resultado = 'ímpar';
    }
    alert(resultado);
  }

  positivo() : void{
    let resultado: string = 'positivo';
    if(Number(this.numero4) < 0){
      resultado = 'negativo';
    }
    alert(resultado);
  }

  parPosivito():void{
    let num : number = Number(this.numero5);
    if(num % 2 == 0 && num >=0 ){
      alert('par e positivo');
    }else{
      alert('nao é par ou positivo');
    }
  }
}
