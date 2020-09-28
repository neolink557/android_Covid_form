package com.university.miapp.ui.home;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.university.miapp.R;
import com.university.miapp.data.models.Weather;
import com.university.miapp.ui.home.presenter.HomePresenter;
import com.university.miapp.ui.home.presenter.HomePresenterImpl;

public class HomeActivity extends AppCompatActivity implements HomeView, View.OnClickListener{
    HomePresenter presenter;
    double time = 0.0;
    ImageView plusButton;
    ImageView minusButton;
    ImageView cameraButton;
    Button imageTemperature;
    Button send;
    View viewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new HomePresenterImpl(this);
        presenter.getTime();
        viewLayout = findViewById(R.id.toolbar);
        plusButton = findViewById(R.id.temperature_plus);
        minusButton = findViewById(R.id.temperature_minus);
        cameraButton = findViewById(R.id.home_camera);
        imageTemperature= findViewById(R.id.temperature_image);
        send = findViewById(R.id.send);
        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        cameraButton.setOnClickListener(this);
        send.setOnClickListener(this);
    }

    @Override
    public void getTimeSuccess(Weather weather) {
        Double var = weather.getMain().getTemp();
        time = var - 273.15;
        imageTemperature.setText(String.format("%.2f", time)+"°");
    }

    @Override
    public void failure(String error) {
        Snackbar.make(viewLayout,"no fue posible conectarse, porfavor revisa tu conexion",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.temperature_plus:
                if (time > 0) {
                    time += 0.1;
                    imageTemperature.setText(String.format("%.2f", time)+"°");
                }
                break;

            case R.id.temperature_minus:
                if (time > 0) {
                    time -= 0.1;
                    imageTemperature.setText(String.format("%.2f", time)+"°");
                }
                break;

            case R.id.home_camera:
                try {
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;

            case R.id.send:
                Snackbar.make(view,"La solicitud se ha enviado con exito",Snackbar.LENGTH_SHORT).show();
                break;
        }

    }
}