import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoAsistentesComponent } from './listado-asistentes.component';

describe('ListadoAsistentesComponent', () => {
  let component: ListadoAsistentesComponent;
  let fixture: ComponentFixture<ListadoAsistentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListadoAsistentesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListadoAsistentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
