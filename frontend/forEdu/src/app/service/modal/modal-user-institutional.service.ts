import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Person } from '../../models/person';

@Injectable({
  providedIn: 'root',
})
export class ModalUserInstitutionalService {
  private modalUserVisibility = new BehaviorSubject<boolean>(false);
  private selectedUser = new BehaviorSubject<Person | null>(null); // Usa la interfaz Person

  modalUser$ = this.modalUserVisibility.asObservable();
  selectedUser$ = this.selectedUser.asObservable();

  showModal(user: Person) {
    this.selectedUser.next(user);
    this.modalUserVisibility.next(true);
  }
}
