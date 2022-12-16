import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { Car } from './cars.model';
import { Category } from './category.model';

@Injectable({
  providedIn: 'root'
})
export class CarsService {
  carsPath: string = environment.apiUrl + 'api/v1/car/';
  carPathWithoutSlash = this.carsPath.slice(0, -1)

  private cars$ = new BehaviorSubject<Car>(null);
  public car$$ = this.cars$.asObservable();

  constructor(private http: HttpClient) { }

  updateCar(car: Car): void {
    this.cars$.next(car);
  }

  getCars(): Observable<Array<Car>> {
    return this.http.get<Array<Car>>(this.carsPath + 'getAll');
  }

  getUserCars(): Observable<Array<Car>> {
    return this.http.get<Array<Car>>(this.carsPath + 'mine');
  }

  getCar(id: string): Observable<Car> {
    return this.car$$;
    // return this.http.get<Car>(this.carsPath + id);
  }

  createCar(car: Car): Observable<Car> {
    return this.http.post<Car>(this.carsPath, car);
  }

  editCar(id: string, car: Car): Observable<Car> {
    return this.http.put<Car>(this.carsPath + id, car);
  }

  deleteCar(id: string) {
    return this.http.delete(this.carsPath + id);
  }

  getCategories(): Observable<Array<Category>> {
    return this.http.get<Array<Category>>(this.carsPath + 'categories')
  }

  search(queryString): Observable<Array<Car>> {
    return this.http.get<Array<Car>>(this.carPathWithoutSlash + queryString)
  }
}
