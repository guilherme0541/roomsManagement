import { Component, OnInit } from '@angular/core';
import { RoomService } from '../room.service';
import { Room } from '../room';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-room',
  templateUrl: './create-room.component.html',
  styleUrls: ['./create-room.component.css']
})
export class CreateRoomComponent implements OnInit {

  room: Room = new Room();
  submitted = false;

  constructor(private roomService: RoomService, private router: Router) { }

  ngOnInit(): void {
  }

  newRoom(): void{
    this.submitted = false;
    this.room = new Room();
  }

  onSubmit(){
    this.submitted = true;
    this.save();
  }

  save(){
    this.roomService.createRoom(this.room)
      .subscribe(data => console.log(data),
        error=> console.error(error)
      );
    this.room = new Room();
    this.gotoList();
  }

  gotoList() {
    this.router.navigate(['/rooms']);
  }
}
