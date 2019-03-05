import {combineReducers, Reducer} from 'redux';
import {currentUserReducer} from './current-user.reducer';

export const reducers: Reducer = combineReducers({
  currentUserState: currentUserReducer
});
