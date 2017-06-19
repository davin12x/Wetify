package co.bagga.wetify.Activities;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import co.bagga.wetify.R;

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

public class test  {

    private ImageView imageView;
    ArrayList data = new ArrayList();
    View view;
    private TextView textView = (TextView)view.findViewById(R.id.cast_notification_id);


    public test() {
        for (int i = 0; i< data.size(); i++) {

        }
       String bla =  new Gson().toJson(vll());
        textView.setTextColor(Color.WHITE);
    }

    public List<String> vll () {
        return new ArrayList<>();
    }
}
