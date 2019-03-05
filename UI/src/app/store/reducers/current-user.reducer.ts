import {Reducer} from 'redux';
import {User} from '../../model/User';


export interface CurrentUserState {
  readonly currentUser: User;
  readonly isLoading: boolean;
  readonly errorMessage: string;
}

const INITIAL_STATE = {
  currentUser: null,
  isLoading: false,
  errorMessage: null
};


export const currentUserReducer: Reducer<CurrentUserState> = (state: CurrentUserState = INITIAL_STATE, action) => {
  return state;
};
