package co.bagga.wetify.Activities;

import android.widget.ImageView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lalit Bagga on 2017-05-27.
 */

public class test  {

    private ImageView imageView;
    ArrayList data = new ArrayList();

    public test() {
        for (int i = 0; i< data.size(); i++) {

        }
       String bla =  new Gson().toJson(vll());
    }

    public List<String> vll () {
        return new ArrayList<>();
    }
}
