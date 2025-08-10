import { Component, OnInit} from '@angular/core';
import { Service } from './service';
import axios from 'axios';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-service-list',
  standalone: false,
  templateUrl: './service-list.component.html',
  styleUrl: './service-list.component.css'
})
export class ServiceListComponent implements OnInit{
  ngOnInit(): void {
    this.getServiceData();
  }
  reqForm: FormGroup = new FormGroup('');
  constructor(fb:FormBuilder)
  {
    this.reqForm = fb.group({userName:new FormControl('', Validators.required), 
      phoneNumber: new FormControl('', Validators.required)});
  }
  private services: Service[][] = [];
  private fg: FormGroup = new FormGroup('');
  async getServiceData(){
     const response = await axios.get<Service[][]>("api/services");
     this.services = response.data;
     console.log(this.services)
  }
  getServices():Service[][]{
    return this.services;
  }
  async sendRequest(){
    const post = {
      userName: this.reqForm.controls['userName'].value,
      phoneNumber: this.reqForm.controls['phoneNumber'].value
    }
    const response = axios.post('api/request', post, {
      headers: {
        'Content-Type': 'application/json'
      },
      withCredentials: true
    });
    if((await response).status === 201)
    {
      alert("Заявка отправлена.");
    }
  }
}
