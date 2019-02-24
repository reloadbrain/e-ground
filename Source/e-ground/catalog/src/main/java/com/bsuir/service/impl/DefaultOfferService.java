package com.bsuir.service.impl;

import com.bsuir.dto.OfferDto;
import com.bsuir.entity.Category;
import com.bsuir.entity.Offer;
import com.bsuir.exception.EntityNotFoundException;
import com.bsuir.repository.CategoryRepository;
import com.bsuir.repository.OfferRepository;
import com.bsuir.service.OfferService;
import com.bsuir.service.util.OfferConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Class of offer service that allows you to work with offers and implements OfferService.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@Service
@Transactional
public class DefaultOfferService implements OfferService {
    private final OfferRepository offerRepository;

    private final CategoryRepository categoryRepository;

    private final OfferConverter converter;

    @Autowired
    public DefaultOfferService(OfferRepository offerRepository, CategoryRepository categoryRepository,
                               OfferConverter converter) {
        this.offerRepository = offerRepository;
        this.categoryRepository = categoryRepository;
        this.converter = converter;
    }

    /**
     * Method that save object in database.
     *
     * @param offerDto object that needs to save
     * @return saved object of Offer class
     */
    @Override
    public OfferDto create(OfferDto offerDto) {
        Offer offer = converter.toOffer(offerDto);
        Category category = categoryRepository.findFirstByName(offerDto.getCategory());
        if (category == null || category.getName().equals(offer.getCategory().getName())) {
            Category categorySave = categoryRepository.save(new Category(offerDto.getCategory()));
            offer.setCategory(categorySave);
        } else {
            offer.setCategory(category);
        }

        Offer createdOffer = offerRepository.save(offer);
        return converter.toOfferDto(createdOffer);
    }

    /**
     * Method that finds Offer object by Price in database.
     *
     * @param value parameter to be searched
     * @return list of founded objects
     */
    @Override
    public List<OfferDto> findAllByPrice(String value) {
        double priceValue = Double.valueOf(value);

        return converter.toOffersDto(offerRepository.findAllByPrice(priceValue));
    }

    /**
     * Method that finds Offer object by Category in database.
     *
     * @param category parameter to be searched
     * @return list of founded objects
     */
    @Override
    public List<OfferDto> findAllByCategory(String category) {
        return converter.toOffersDto(offerRepository.findAllByCategory(categoryRepository.findFirstByName(category)));
    }

    /**
     * Method that finds all objects in database.
     *
     * @return founded objects
     */
    @Override
    public List<OfferDto> findAll() {
        Iterable<Offer> saveOffer = offerRepository.findAll();
        List<Offer> createdOffers = new ArrayList<>();
        for (Offer offer : saveOffer) {
            createdOffers.add(offer);
        }
        return converter.toOffersDto(createdOffers);
    }

    @Override
    public List<OfferDto> findAllByFilter( String category, String priceFrom, String priceTo) {
        Iterable<Offer> saveOffer;

        Category foundCategory = null;

        double priceFromTemp;

        double priceToTemp;

        List<Offer> foundOffers = new ArrayList<>();

        if (category != null) {
            foundCategory = categoryRepository.findFirstByName(category);
        }

        if (priceFrom != null && Double.valueOf(priceFrom) >= 0) {
            priceFromTemp = Double.valueOf(priceFrom);
        } else {
            priceFromTemp = 0;
        }

        if (priceTo != null && Double.valueOf(priceTo) > priceFromTemp) {
            priceToTemp = Double.valueOf(priceTo);
        } else {
            priceToTemp = Double.MAX_VALUE;
        }

       if (category != null) {
            saveOffer = offerRepository.findAllByCategory(foundCategory);
        } else {
            saveOffer = offerRepository.findAll();
        }

        for (Offer offer : saveOffer) {
            if (offer.getPrice() >= priceFromTemp && offer.getPrice() < priceToTemp) {
                foundOffers.add(offer);
            }
        }

        return converter.toOffersDto(foundOffers);
    }

    /**
     * Method that finds Offer object by Long in database.
     *
     * @param id parameter to be searched
     * @return list of founded objects
     */
    @Override
    public OfferDto findById(UUID id) {
        return converter.toOfferDto(offerRepository.findById(id).orElseThrow(NullPointerException::new));
    }

    /**
     * Method that save updated object in database.
     *
     * @param offerDto updated offer that needs to save
     * @return updated and saved offer
     */
    @Override
    public OfferDto update(OfferDto offerDto) {
        return create(offerDto);
    }

    /**
     * Method that delete object in database.
     *
     * @param id parameter to be searched
     */
    @Override
    public void delete(UUID id) {
        try {
            offerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }

    /**
     * Method that changes Category to Offer.
     *
     * @param offerId  Offer class object
     * @param category Category class object
     * @return updated Offer
     */
    @Override
    public OfferDto changeCategory(UUID offerId, String category) {
        Offer offer = offerRepository.findById(offerId).orElseThrow(NullPointerException::new);
        Category categoryByName = categoryRepository.findFirstByName(category);
        offer.setCategory(categoryByName);
        Offer savedOffer = offerRepository.save(offer);
        return converter.toOfferDto(savedOffer);
    }
}
