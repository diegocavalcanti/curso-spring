import { Component } from "@angular/core";
import { CommonModule } from "@angular/common";
import { Empresa } from "../../models/empresa";
import { EmpresaService } from "../../services/empresa.service";
import { FormsModule } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "app-empresa-edit",
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: "./empresa-edit.component.html",
  styleUrl: "./empresa-edit.component.css",
})
export class EmpresaEditComponent {
  empresa: Empresa = {
    id: 0,
    nome: "",
    endereco: "",
    telefone: "",
    numeroFuncionario: 0,
  };

  constructor(private router: Router, private route: ActivatedRoute, private service: EmpresaService) {}

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id')
    this.service.buscarPorId(parseInt(id!)).subscribe((empresa) => {
      this.empresa = empresa
    })
  }

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
