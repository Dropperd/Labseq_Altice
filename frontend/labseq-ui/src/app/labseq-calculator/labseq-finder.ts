import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'
import { LabseqService } from '../labseq.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-labseq-calculator',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './labseq-finder.html',
  styleUrl: './labseq-finder.css'
})
export class LabseqFinder {
  n: number = 0;
  result: string | null = null;
  loading = false;
  error = '';

  constructor(private labseqService: LabseqService) { }

  calculate() {
    if (this.n < 0) {
      this.error = 'n shoul d be >= 0';
      return;
    }

    this.loading = true;
    this.error = '';
    this.result = null;

    this.labseqService.getLabseq(this.n).subscribe({
      next: (data) => {
        this.result = data;
        this.loading = false;
      },
      error: (err) => {
        this.error = 'Erro: ' + err.message;
        this.loading = false;
      }
    });
  }

  get resultScientific(): string | null {
  if (this.result) {
    
    const bigIntStr = this.result;
    const length = bigIntStr.length;
    const firstDigits = bigIntStr.slice(0, 15);

    return `${firstDigits}e+${length - 15}`;
  }
  return null;
}
}
