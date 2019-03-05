import {Injectable} from '@angular/core';
import {combineEpics} from 'redux-observable';
import {CatalogEpic} from './catalog.epic';

@Injectable()
export class EpicService {

  constructor(private catalogEpic: CatalogEpic) {
  }

  getEpics() {
    return combineEpics(
      this.catalogEpic.fetchOffers$
    );
  }
}
