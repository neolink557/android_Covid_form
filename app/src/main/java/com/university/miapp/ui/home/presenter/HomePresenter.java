package com.university.miapp.ui.home.presenter;

import com.university.miapp.data.models.Weather;

public interface HomePresenter {
    void getTimeSuccess(Weather weather);
    void getTime();
    void failure(String error);
}
