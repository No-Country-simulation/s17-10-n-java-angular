import { Component, OnInit } from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { ModalUserInstitutionalService } from '../../service/modal/modal-user-institutional.service';
import { Person } from '../../models/person';

@Component({
  selector: 'app-modal-user-intitutional',
  standalone: true,
  imports: [DialogModule],
  templateUrl: './modal-user-institutional.component.html',
  styleUrls: ['./modal-user-institutional.component.css'],
})
export class ModalUserIntitutionalComponent implements OnInit {
  displayModal: boolean = false;
  selectedUser: Person | null = null;

  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  ngOnInit(): void {
    this.modalUserInstitutionalService.modalUser$.subscribe(
      (isVisible) => {
        this.displayModal = isVisible;
      }
    );
    this.modalUserInstitutionalService.selectedUser$.subscribe(
      user => this.selectedUser = user
    );
  }

  loadParentData(){
    
  }
  
}
