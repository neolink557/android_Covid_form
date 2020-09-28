package com.university.miapp.ui.home;

import com.university.miapp.data.models.Weather;

public interface HomeView {
    void getTimeSuccess(Weather weather);
    void failure(String error);
}
