import {Injectable} from '@angular/core';
import {combineEpics} from 'redux-observable';

@Injectable()
export class EpicService {

  constructor() {
  }

  getEpics() {
    return combineEpics();
  }
}
