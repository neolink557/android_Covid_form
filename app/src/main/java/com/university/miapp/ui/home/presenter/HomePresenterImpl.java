package com.university.miapp.ui.home.presenter;

import com.university.miapp.data.models.Weather;
import com.university.miapp.data.repository.HomeRepository;
import com.university.miapp.data.repository.HomeRepositoryImpl;
import com.university.miapp.ui.home.HomeView;

public class HomePresenterImpl implements HomePresenter {
    private HomeView view;
    private HomeRepository repository;

    public HomePresenterImpl(HomeView view) {
        repository = new HomeRepositoryImpl(this);
        this.view = view;
    }


    @Override
    public void getTimeSuccess(Weather weather) {
        view.getTimeSuccess(weather);
    }

    @Override
    public void getTime() {
        repository.getTime();
    }

    @Override
    public void failure(String error) {
            view.failure(error);
    }
}
