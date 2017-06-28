package co.bagga.wetify.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.bagga.wetify.Models.WeatherData;
import co.bagga.wetify.R;

/**
 * Created by Lalit Bagga on 2017-06-27.
 */

public class WeatherDayAdapter extends RecyclerView.Adapter<WeatherDayAdapter.DayViewHolder>{
    private ArrayList<WeatherData> weatherDataArrayList;

    public WeatherDayAdapter(ArrayList<WeatherData> weatherData) {
        this.weatherDataArrayList = weatherData;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DayViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.day_list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        WeatherData weatherData = weatherDataArrayList.get(position);
        holder.updateView(weatherData);
    }

    @Override
    public int getItemCount() {
        return weatherDataArrayList.size();
    }

    public class DayViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public DayViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.temperature);
        }

        public void updateView(WeatherData weatherData) {
            textView.setText(weatherData.getMain().getTemp().toString());
        }
    }
}
