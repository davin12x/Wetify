package co.bagga.wetify.Activities;

import android.content.Intent;;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import co.bagga.wetify.Adapter.WeatherAdapter;
import co.bagga.wetify.Interface.HttpCallBack;
import co.bagga.wetify.Models.WeatherData;
import co.bagga.wetify.Network.RequestGenerator;
import co.bagga.wetify.R;
import co.bagga.wetify.Utils.JsonParser;
import co.bagga.wetify.Utils.SharedPreference;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;

import com.google.android.gms.location.places.ui.PlacePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = getClass().getSimpleName();
    int PLACE_PICKER_REQUEST = 1;

    WeatherAdapter weatherAdapter = new WeatherAdapter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        FloatingActionButton addCityButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        addCityButton.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(weatherAdapter);

        ArrayList<String> cityList = (ArrayList<String>) SharedPreference.Companion.getInstance(getApplicationContext()).getSavedCityList();
        if (cityList != null) {
            for (String citName : cityList) {
                fetchWeatherDataByName(citName, RequestGenerator.Companion.getInstance(getApplicationContext()));
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                String address = place.getAddress().toString().replace(",", " ");
                fetchWeatherDataByName(address, RequestGenerator.Companion.getInstance(getApplicationContext()));
                SharedPreference.Companion.getInstance(getApplicationContext()).saveWeatherCityList(address);
            }
        }
    }

    private void fetchWeatherDataByName(String cityName, RequestGenerator requestGenerator) {

        requestGenerator.generateFetchWeatherForecastByNameHttpRequest(cityName, new HttpCallBack() {
            @Override
            public void onHttpRequestSuccess(@NotNull String response, int responseCode) {
                WeatherData weatherData = JsonParser.INSTANCE.parseCurrentWeather(response);
                weatherAdapter.refreshData(weatherData);
            }

            @Override
            public void onHttpRequestError(@NotNull String response, int responseCode) {
                Log.e(TAG, response);
            }
        });
    }

    @Override
    public void onClick(View v) {
        PlacePicker.IntentBuilder placePickerIntentBuilder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(placePickerIntentBuilder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }
}
