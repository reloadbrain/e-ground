import {Offer} from '../../model/Offer';

export const CREATE_OFFER = '[Offer] Create offer';
export const CREATE_OFFER_SUCCESS = '[Offer] Create offer success';
export const CREATE_OFFER_FAILED = '[Offer] Create offer failed';


export function createOfferAction(offer: Offer) {
  return {
    type: CREATE_OFFER,
    payload: {offer}
  };
}

export function createOfferSuccessAction(offer: Offer) {
  return {
    type: CREATE_OFFER_SUCCESS,
    payload: {offer}
  };
}

export function createOfferFailedAction(errorMessage: string) {
  return {
    type: CREATE_OFFER_FAILED,
    error: true,
    payload: {errorMessage}
  };
}
