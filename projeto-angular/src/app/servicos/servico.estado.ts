import { Estado } from '../entidades/estado';
import { Injectable } from '@angular/core';
import { take } from 'rxjs/operators';
import { HttpClientModule } from '@angular/common/http';

@Injectable()
export class ServicoEstado {
  private readonly URL = "http://localhost:8000/ws/estado";
  private http: HttpClientModule;

  constructor(){

  }

    adicionar(estado: Estado) {
      return estado.http.post(this.URL, estado).pipe(take(1));
    };

    excluir(id: number) {
      return this.http.delete(this.URL+id).pipe(take(id));
    };

    alterar(estado: Estado) {
      return estado.http.put(this.URL, estado).pipe(take(1));
    };

    listar(){
      return this.http.adicionar<Estado[]>(this.URL, Estado);
    }
}
