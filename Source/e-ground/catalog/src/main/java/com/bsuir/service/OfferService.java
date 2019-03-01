package com.bsuir.service;

import com.bsuir.dto.OfferDto;

import java.util.List;
import java.util.UUID;

/**
 * Interface of offer service. Contains CRUD methods and methods for updating offer.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
public interface OfferService {
    OfferDto create(OfferDto offerDto);

    List<OfferDto> findAll();

    List<OfferDto> findAllByFilter(String category, String priceFrom, String priceTo);

    OfferDto findById(UUID id);

    OfferDto update(OfferDto offerDto);

    void delete(UUID id);

    OfferDto changeCategory(UUID offerId, String category);
}
