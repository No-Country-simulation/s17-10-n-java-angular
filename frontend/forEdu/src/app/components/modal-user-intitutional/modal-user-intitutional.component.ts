import { Component, OnInit } from '@angular/core';
import { DialogModule } from 'primeng/dialog';
import { ModalUserInstitutionalService } from '../../service/modal/modal-user-institutional.service';

@Component({
  selector: 'app-modal-user-intitutional',
  standalone: true,
  imports: [DialogModule],
  templateUrl: './modal-user-intitutional.component.html',
  styleUrls: ['./modal-user-intitutional.component.css'],
})
export class ModalUserIntitutionalComponent implements OnInit {
  displayModal: boolean = false;
  user: any = null;

  constructor(private modalUserInstitutionalService: ModalUserInstitutionalService) {}

  ngOnInit(): void {
    this.modalUserInstitutionalService.modalUser$.subscribe(
      (isVisible) => {
        this.displayModal = isVisible;
      }
    );
    this.modalUserInstitutionalService.selectedUser$.subscribe(
      (user) => {
        this.user = user;
      }
    );
  }
  
}
