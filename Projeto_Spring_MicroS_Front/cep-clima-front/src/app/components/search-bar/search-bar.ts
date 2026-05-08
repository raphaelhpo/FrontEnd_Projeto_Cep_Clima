import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CepClimaResponse } from '../../models/cep-clima';
import { CepClimaService } from '../../services/cep-clima';

@Component({
  selector: 'app-search-bar',
  imports: [FormsModule],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.css',
})
export class SearchBar {

  cep: string = '';
  loading: boolean = false;

  @Output() resultado = new EventEmitter<CepClimaResponse>();

  constructor(private service: CepClimaService) { }

  buscar() {
    if (!this.cep) return;
    this.loading = true;
    this.service.buscarCepClima(this.cep).subscribe({
      next: (data) => {
        this.resultado.emit(data);
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }
}