package com.bsuir.controller;

import com.bsuir.dto.OfferDto;
import com.bsuir.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Class of Offer REST Controller. Contains CRUD methods and methods for updating offer.
 *
 * @author Stsiapan Balashenka
 * @version 1.0
 */
@RestController
@RequestMapping(value = "api/v1/catalog/offers")
public class OfferController {
    /**
     * Field of Offer Service.
     */
    private final OfferService offerService;

    /**
     * Constructor that accepts objects of OfferService, TagService, CategoryService classes.
     *
     * @param offerService object of OfferService class
     */
    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    /**
     * Method that converts DTO to class object and create it.
     *
     * @param offerDto data transfer object
     * @return created object of Offer class
     */
    @PostMapping
    public OfferDto create(@Validated @RequestBody OfferDto offerDto) {
        return offerService.create(offerDto);
    }

    /**
     * Method that save updated object.
     *
     * @param offerDto updated Offer that needs to save
     * @return updated and saved offer
     */
    @PutMapping
    public OfferDto update(@Validated @RequestBody OfferDto offerDto) {
        return offerService.update(offerDto);
    }

    /**
     * Method that delete object.
     *
     * @param id object that needs to delete
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") UUID id) {
        offerService.delete(id);
    }

    /**
     * Method that finds Offer object by Price.
     *
     * @param price parameter to be searched
     * @return List of founded objects
     */
    @GetMapping(path = "/prices/{price}")
    public List<OfferDto> findByPrice(@PathVariable("price") String price) {
        return offerService.findAllByPrice(price);
    }

    /**
     * Method that finds Offer object by Category.
     *
     * @param category parameter to be searched
     * @return List of founded objects
     */
    @GetMapping(path = "/categories/{category}")
    public List<OfferDto> findByCategory(@PathVariable("category") String category) {
        return offerService.findAllByCategory(category);
    }

    /**
     * Method that finds Offer object by Long.
     *
     * @param id parameter to be searched
     * @return List of founded objects
     */
    @GetMapping(path = "/{id}")
    public OfferDto findById(@PathVariable("id") UUID id) {
        return offerService.findById(id);
    }

    /**
     * Method that finds all objects.
     *
     * @return founded objects
     */
    @GetMapping
    public List<OfferDto> findAll() {
        return offerService.findAll();
    }

    /**
     * Method that changes Category to Offer.
     *
     * @param offerId      Offer Long
     * @param categoryName Category to change
     * @return updated Offer
     */
    @PutMapping(path = "/{offerId}/categories/{categoryName}")
    public OfferDto changeCategory(@PathVariable("offerId") UUID offerId, @PathVariable("categoryName") String categoryName) {
        return offerService.changeCategory(offerId, categoryName);
    }

    @GetMapping(path = "/filter")
    public List<OfferDto> findAllByFilter(@RequestParam(value = "category", required = false) String category,
                                          @RequestParam(value = "priceFrom", required = false) String priceFrom,
                                          @RequestParam(value = "priceTo", required = false) String priceTo) {
        return offerService.findAllByFilter(category, priceFrom, priceTo);
    }
}
