import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { Empresa } from "../../models/empresa";
import { EmpresaService } from "../../services/empresa.service";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { Router, RouterModule } from "@angular/router";


@Component({
  selector: "app-empresa-list",
  standalone: true,
  imports: [CommonModule, HttpClientModule, FormsModule, RouterModule],
    templateUrl: "./empresa-list.component.html",
  styleUrl: "./empresa-list.component.css",
})
export class EmpresaListComponent implements OnInit {
  listaEmpresa: Empresa[] = [];


  constructor(private router: Router, private service: EmpresaService) { }

  refreshList(){
    this.service.listar().subscribe({
      next: (v) => this.listaEmpresa = v,
      error: (e) => console.error(e )
   })
  }

  ngOnInit(): void {
    this.refreshList()
  }

  excluir(id:number){
    this.service.excluir(id).subscribe({
      next: () =>{
        this.refreshList()
         this.router.navigate(["/empresa-list"])
      },
      error: (e) => console.error(e )
    })
  }
}
