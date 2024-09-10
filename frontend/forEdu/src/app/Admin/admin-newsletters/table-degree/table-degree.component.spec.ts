import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableDegreeComponent } from './table-degree.component';

describe('TableDegreeComponent', () => {
  let component: TableDegreeComponent;
  let fixture: ComponentFixture<TableDegreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableDegreeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableDegreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
