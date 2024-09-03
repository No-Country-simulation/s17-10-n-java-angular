import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ModalUserInstitutionalService {
  private modalUserVisibility = new BehaviorSubject<boolean>(false);
  private selectedUser = new BehaviorSubject<any>(null);

  modalUser$ = this.modalUserVisibility.asObservable();
  selectedUser$ = this.selectedUser.asObservable();

  showModal(user: any) {
    this.selectedUser.next(user);
    this.modalUserVisibility.next(true);
  }
}
