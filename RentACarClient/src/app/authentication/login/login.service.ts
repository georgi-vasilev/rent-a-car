import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private loginPath: string = environment.apiUrl + "api/v1/users/sign-in";
  
  constructor(private http: HttpClient) { }

  login(payload): Observable<any> {
      return this.http.post(this.loginPath, payload);
  }

  setTToken(token) {
    localStorage.setItem('token', token);
  }

  setId(dealerId) {
    localStorage.setItem('dealerId', dealerId);
  }
}
