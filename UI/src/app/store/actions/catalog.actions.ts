import {Offer} from '../../model/Offer';

export const FETCH_OFFERS = 'FETCH_OFFERS';
export const FETCH_OFFERS_SUCCESS = 'FETCH_OFFERS_SUCCESS';
export const FETCH_OFFERS_FAILED = 'FETCH_OFFERS_FAILED';


export function fetchOffersAction() {
  return {
    type: FETCH_OFFERS
  };
}

export function fetchOffersSuccessAction(offers: Map<string, Offer>) {
  return {
    type: FETCH_OFFERS_SUCCESS,
    payload: {offers}
  };
}

export function fetchOffersFailedAction(message: string) {
  return {
    type: FETCH_OFFERS_FAILED,
    error: true,
    payload: {message}
  };
}
