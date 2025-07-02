import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { LabseqFinder } from "./labseq-calculator/labseq-finder";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, LabseqFinder],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'labseq-ui';
}
