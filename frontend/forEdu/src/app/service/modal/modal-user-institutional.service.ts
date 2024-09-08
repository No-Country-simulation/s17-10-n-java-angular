import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Person } from '../../models/person';


@Injectable({
  providedIn: 'root',
})
export class ModalUserInstitutionalService {
  
  private modalUserVisibility = new BehaviorSubject<boolean>(false);
  modalUser$ = this.modalUserVisibility.asObservable();

  private selectedUser = new BehaviorSubject<Person | null>(null);
  selectedUser$ = this.selectedUser.asObservable();

  showModal(user: Person) {
    this.selectedUser.next(user);
    this.modalUserVisibility.next(true);
  }
}
