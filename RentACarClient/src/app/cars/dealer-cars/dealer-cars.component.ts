import { Component, OnInit } from '@angular/core';
import { Car } from '../cars.model';
import { CarsService } from '../cars.service';

@Component({
  selector: 'app-dealer-cars',
  templateUrl: './dealer-cars.component.html',
  styleUrls: ['./dealer-cars.component.css']
})
export class DealerCarsComponent implements OnInit {
  private id: string;
  public cars: Array<Car>;
  public popUpOpen: boolean = false;

  constructor(private carsService: CarsService) { }

  ngOnInit(): void {
    this.popUpOpen = false
    this.fetchCars()
  }

  fetchCars() {
    this.carsService
      .getUserCars()
      .subscribe(cars => {
        this.cars = cars['carAds'];
      })
  }

  openModal(id) {
    this.popUpOpen = true;
    this.id = id;
  }

  cancelModal() {
    this.popUpOpen = false;
    this.id = null;
  }

  assignCars(event) {
    this.cars = event['carAds'];
  }

  deleteCar() {
    this.carsService
      .deleteCar(this.id)
      .subscribe(res => {
        this.popUpOpen = false;
        this.fetchCars();
      })
  }

}
