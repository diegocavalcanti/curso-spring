import { Component, OnInit } from "@angular/core";
import { CommonModule } from "@angular/common";
import { Empresa } from "../../models/empresa";
import { Router } from "@angular/router";
import { EmpresaService } from "../../services/empresa.service";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-empresa-new",
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: "./empresa-new.component.html",
  styleUrl: "./empresa-new.component.css",
})
export class EmpresaNewComponent implements OnInit {
  empresa: Empresa = {
    id: 0,
    nome: "",
    endereco: "",
    telefone: "",
    numeroFuncionario: 0,
  };

  constructor(private router: Router, private service: EmpresaService) {}

  ngOnInit(): void {}

  salvar() {
    this.service.gravar(this.empresa).subscribe({
      next: (v) => {
        this.empresa = v;
        this.router.navigate(["/empresa-list"]);
      },
      error: (e) => console.error(e),
    });
  }

  cancelar() {
    this.router.navigate(["/empresa-list"]);
  }
}
