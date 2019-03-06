import {NgModule} from '@angular/core';
import {CatalogEpic} from './catalog.epic';
import {OfferEpic} from './offer.epic';

@NgModule({
  providers: [
    CatalogEpic,
    OfferEpic
  ],
})
export class EpicsModule {
}
