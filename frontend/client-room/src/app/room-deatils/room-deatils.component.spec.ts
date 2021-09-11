import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomDeatilsComponent } from './room-deatils.component';

describe('RoomDeatilsComponent', () => {
  let component: RoomDeatilsComponent;
  let fixture: ComponentFixture<RoomDeatilsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoomDeatilsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomDeatilsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
