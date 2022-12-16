import { Component, OnInit } from '@angular/core';
import { CarsService } from '../cars.service';
import { Car } from '../cars.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  public cars: Array<Car>;
  public category = null;

  constructor(private carsService: CarsService) { }

  ngOnInit(): void {
    this.fetchCars()

  }

  fetchCars() {
    // this.carsService
    //   .getCars()
    //   .subscribe(cars => {
    //     this.cars = cars['carAds'];
    //   })
    this.cars = [
      new Car(1, 'Toyota', 'Corolla', 'Sedan', 'https://scene7.toyota.eu/is/image/toyotaeurope/2022+%E2%80%93+COROLLA+GR+SPORT+WP+004:Medium-Landscape?ts=0', 50, true, 4, 'Manual', true),
      new Car(2, 'Toyota', 'Corolla', 'Sedan', 'https://media.ed.edmunds-media.com/toyota/corolla/2001/oem/2001_toyota_corolla_sedan_le_fq_oem_1_500.jpg', 50, true, 4, 'Manual', true)
    ];

    this.carsService.updateCar(this.cars[0]);
  }

  assignCars(event) {
    this.cars = event['carAds'];
  }

}
