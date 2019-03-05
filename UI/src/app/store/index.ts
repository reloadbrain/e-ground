import {CurrentUserState} from './reducers/current-user.reducer';
import {UserSideNavState} from './reducers/user-side-nav.reducer';

export interface AppState {
  readonly router?: string;
  readonly currentUserState?: CurrentUserState;
  readonly userSideNavState?: UserSideNavState;
  /*readonly startupsState?: StartupsState;
  readonly startupPageState?: StartupPageState;
  readonly router?: string;
  readonly dialogsState?: DialogState;
  readonly currentUserState?: CurrentUserState;
  readonly startupSearchToolbarState?: StartupSearchToolbarState;
  readonly resumeState?: ResumeState;
  readonly resumePageState?: ResumePageState;
  readonly userSideNavState?: UserSideNavState;
  readonly contactsState?: ContactsState;
  readonly accountPageState?: AccountPageState;
  readonly specialistsSearchState?: SpecialistsSearchToolbarState;
  readonly conversationsState?: ConversationsState;
  readonly favoritesState?: FavoritesState;
  readonly resetPasswordState?: ResetPasswordState;
  readonly contactsSearchToolbarState?: ContactsSearchToolbarState;*/
}


