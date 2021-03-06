import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Room } from '../room';
import { RoomService } from '../room.service';

@Component({
  selector: 'app-room-deatils',
  templateUrl: './room-deatils.component.html',
  styleUrls: ['./room-deatils.component.css']
})
export class RoomDeatilsComponent implements OnInit {

  id:number =0;
  room: Room | undefined;
  submitted = false;

  constructor(private roomservice: RoomService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(){
    this.room = new Room();
    this.id = this.route.snapshot.params['id'];
    this.roomservice.getRoom(this.id)
      .subscribe(
        data => {
          console.log(data);
          this.room = data;
        },
        error => console.log(error)
      );
  }

  list(){
    this.router.navigate(['rooms']);
  }

}
