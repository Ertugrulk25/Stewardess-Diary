package com.example.service;

import com.example.domain.Country;

import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final com.example.repository.CountryRepository countryRepository;

    @Autowired
    public CountryService(com.example.repository.CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Tüm ülkeleri listele
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    // Yeni bir ülke ekle
    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    // ID'ye göre ülke bul
    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found with id: " + id));
    }

    // Ülke sil
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
