import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./pages/home/home.component";
import { EmpresaListComponent } from "./pages/empresa-list/empresa-list.component";
import { EmpresaNewComponent } from "./pages/empresa-new/empresa-new.component";
import { EmpresaEditComponent } from "./pages/empresa-edit/empresa-edit.component";

export const routes: Routes = [
  {
    path: "",
    component: HomeComponent,
  },
  {
    path: "empresa-list",
    component: EmpresaListComponent,
  },
  {
    path: "empresa-new",
    component: EmpresaNewComponent,
  },
  {
    path: "empresa-edit/:id",
    component: EmpresaEditComponent,
  },
];
