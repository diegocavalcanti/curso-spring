import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empresa } from '../models/empresa';

@Injectable({
  providedIn: 'root'
})
export class EmpresaService {


  private readonly API = 'http://localhost:8080/empresa'

  constructor(private http: HttpClient) { }

  listar(): Observable<Empresa[]> {
    return this.http.get<Empresa[]>(this.API)
  }

  gravar(empresa:Empresa): Observable<Empresa> {
    return this.http.post<Empresa>(this.API,empresa)
  }



  editar(Empresa: Empresa): Observable<Empresa> {
    const url = `${this.API}/${Empresa.id}`
    return this.http.put<Empresa>(url, Empresa )

  }

  excluir(id: number): Observable<void> {
    const url = `${this.API}/${id}`
    return this.http.delete<void>(url)
  }

  buscarPorId(id: number): Observable<Empresa> {
    const url = `${this.API}/${id}`
    return this.http.get<Empresa>(url)
  }



}
