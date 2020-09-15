import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item.model';
import { BaseService } from '../services/base.service';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  ngOnInit(): void {
  }

}
