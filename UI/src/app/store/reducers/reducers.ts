import {combineReducers, Reducer} from 'redux';
import {currentUserReducer} from './current-user.reducer';
import {userSideNavReducer} from './user-side-nav.reducer';

export const reducers: Reducer = combineReducers({
  currentUserState: currentUserReducer,
  userSideNavState: userSideNavReducer
});
