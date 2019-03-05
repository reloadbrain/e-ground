import {Reducer} from 'redux';

export interface UserSideNavState {
  readonly isOpened: boolean;
}


const INITIAL_STATE = {
  isOpened: false
};


export const userSideNavReducer: Reducer<UserSideNavState> = (state: UserSideNavState = INITIAL_STATE, action): UserSideNavState => {
    return state;
  }
;
