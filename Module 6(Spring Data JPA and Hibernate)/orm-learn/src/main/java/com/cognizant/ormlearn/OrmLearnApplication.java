package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);

        // testGetAllCountries();
        // getAllCountriesTest();
        // testAddCountry();
        // testUpdateCountry();
        // testDeleteCountry();
        // testSearchCountry();
        // testSearchCountryStartingLetter();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void getAllCountriesTest() {
        LOGGER.info("Start getAllCountriesTest");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
        LOGGER.info("End getAllCountriesTest");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country country = new Country();
        country.setCode("XX");
        country.setName("Test Country");
        countryService.addCountry(country);
        
        try {
            Country savedCountry = countryService.findCountryByCode("XX");
            LOGGER.debug("Added Country:{}", savedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after add", e);
        }
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("XX", "Updated Test Country");
            Country updatedCountry = countryService.findCountryByCode("XX");
            LOGGER.debug("Updated Country:{}", updatedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
        LOGGER.info("End testUpdateCountry");
    }
    
    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("XX");
        try {
            Country country = countryService.findCountryByCode("XX");
            LOGGER.debug("Country after delete:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country successfully deleted as expected.");
        }
        LOGGER.info("End testDeleteCountry");
    }
    
    private static void testSearchCountry() {
        LOGGER.info("Start testSearchCountry");
        List<Country> countries = countryService.findByNameContaining("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End testSearchCountry");
    }
    
    private static void testSearchCountryStartingLetter() {
        LOGGER.info("Start testSearchCountryStartingLetter");
        List<Country> countries = countryService.findByStartingLetter("Z");
        LOGGER.debug("Countries starting with 'Z': {}", countries);
        LOGGER.info("End testSearchCountryStartingLetter");
    }
}
