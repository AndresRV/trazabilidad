package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IRestaurantServicePort;
import com.pragma.powerup.domain.exception.InvalidNameException;
import com.pragma.powerup.domain.exception.InvalidOwnerUser;
import com.pragma.powerup.domain.exception.InvalidPhoneNumberException;
import com.pragma.powerup.domain.model.Restaurant;
import com.pragma.powerup.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class RestaurantUseCase implements IRestaurantServicePort {
    private static final String PHONE_NUMBER_REGEX = "^\\+\\d{12}$";
    private static final String NAME_REGEX = ".*[a-zA-Z]+.*";

    private final IRestaurantPersistencePort restaurantPersistentPort;

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        validateName(restaurant.getName());
        validatePhoneNumber(restaurant.getPhoneNumber());

        restaurantPersistentPort.saveRestaurant(restaurant);
    }

    @Override
    public Restaurant getRestauranByNit(Long nit) {
        return restaurantPersistentPort.getRestauranByNit(nit);
    }

    @Override
    public List<Restaurant> getPagedRestaurants(int page, int size) {
        return restaurantPersistentPort.getPagedRestaurants(page, size);
    }

    private static void validatePhoneNumber(String phoneNumber) {
        Matcher matcher = Pattern.compile(PHONE_NUMBER_REGEX).matcher(phoneNumber);
        if (!matcher.matches())
            throw new InvalidPhoneNumberException("Invalid number phone");
    }

    private static void validateName(String name) {
        Matcher matcher = Pattern.compile(NAME_REGEX).matcher(name);
        if (!matcher.matches())
            throw new InvalidNameException("Invalid name");
    }
}
