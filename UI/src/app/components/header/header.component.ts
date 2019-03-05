import {NgxPermissionsService} from 'ngx-permissions';
import {Component, OnInit} from '@angular/core';
import {NgRedux, select} from '@angular-redux/store';
import {Observable} from 'rxjs';
import {User} from '../../model/User';
import {AppState} from '../../store';
import {selectCurrentUser} from '../../store/selectors/current-user.selector';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  ls = localStorage;

  @select(selectCurrentUser)
  currentUser: Observable<User>;

  navLinks = [{
    path: '/main-page',
    label: 'Main',
    isActive: true
  }];

  constructor(
    private ngRedux: NgRedux<AppState>,
    private  permissionsServive: NgxPermissionsService) {
  }

  ngOnInit() {
  }

  openSingIn(): void {
  }

  openSingUp(): void {
  }

  logout() {
  }

}
