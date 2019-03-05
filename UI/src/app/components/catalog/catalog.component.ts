import {Component, OnInit} from '@angular/core';
import {Offer} from '../../model/Offer';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  offers: Offer[];

  constructor() {
  }


  ngOnInit() {
  }

}
