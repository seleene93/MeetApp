import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ConstantesService } from '../constantes.service';

@Component({
  selector: 'app-modal-error',
  templateUrl: './modal-error.component.html',
  styleUrls: ['./modal-error.component.css'],
})
export class ModalErrorComponent {
  errorType: string;

  constructor(
    public constantes: ConstantesService,
    public dialogRef: MatDialogRef<ModalErrorComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { errorType: string }
  ) {
    this.errorType = data.errorType;
  }

  closeModal() {
    this.dialogRef.close();
  }
}
