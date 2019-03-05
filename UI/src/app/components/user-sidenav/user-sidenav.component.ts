import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSidenav} from '@angular/material';
import {NgRedux, select} from '@angular-redux/store';
import {selectCurrentUser} from '../../store/selectors/current-user.selector';
import {Observable} from 'rxjs';
import {AppState} from '../../store';
import {User} from '../../model/User';
import {isOpened} from '../../store/selectors/user-side-nav.selector';

@Component({
  selector: 'app-user-sidenav',
  templateUrl: './user-sidenav.component.html',
  styleUrls: ['./user-sidenav.component.css']
})
export class UserSidenavComponent implements OnInit {

  @ViewChild('sidenav')
  nav: MatSidenav;

  @select(selectCurrentUser)
  currentUser: Observable<User>;

  @select(isOpened)
  opened: Observable<boolean>;

  opened1: boolean;

  constructor(private ngRedux: NgRedux<AppState>) {
  }

  ngOnInit() {
    this.opened1 = true;
  }

  open() {
    this.nav.toggle();
    this.opened1 = true;
  }

  close() {
    this.nav.toggle();
    this.opened1 = false;
  }
}
