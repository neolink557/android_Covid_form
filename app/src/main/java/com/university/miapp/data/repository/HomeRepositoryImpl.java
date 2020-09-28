package com.university.miapp.data.repository;

import com.university.miapp.data.models.Weather;
import com.university.miapp.data.remote.ApiClient;
import com.university.miapp.ui.home.presenter.HomePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeRepositoryImpl implements HomeRepository{
    private HomePresenter homePresenter;

    public HomeRepositoryImpl(HomePresenter homePresenter) {
        this.homePresenter = homePresenter;
    }


    @Override
    public void getTime() {
        Call<Weather> call = ApiClient.getInstance().getApi().getTime();
        call.enqueue(new Callback<Weather>() {

            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                homePresenter.getTimeSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                homePresenter.failure(t.getMessage());
            }
        });

    }
}

