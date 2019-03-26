import {combineReducers, Reducer} from 'redux';
import {currentUserReducer} from './current-user.reducer';
import {userSideNavReducer} from './user-side-nav.reducer';
import {catalogReducer} from './catalog.reducer';
import {routerReducer} from '@angular-redux/router';

export const reducers: Reducer = combineReducers({
  currentUserState: currentUserReducer,
  userSideNavState: userSideNavReducer,
  catalogState: catalogReducer,
  router: routerReducer
});
