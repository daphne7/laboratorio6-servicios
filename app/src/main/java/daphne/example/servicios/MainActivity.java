package daphne.example.servicios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import daphne.example.servicios.collection.Item;
import daphne.example.servicios.collection.ListAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
    }

    private void loadComponents(){
        AsyncHttpClient client = new AsyncHttpClient();

        final ListView list = findViewById(R.id.list_main);
        final ArrayList<Item> list_data = new ArrayList<>();


        client.get("http://18.219.197.67/listhomes",  new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                //super.onSuccess(statusCode, headers, response);
                //JSONArray data = response.getJSONArray("data");
                for (int i = 0; i<response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Item p = new Item();
                        p.setId(i);
                        p.setTitle(obj.getString("directions"));
                        p.setDescripsion(obj.getString("description"));
                        p.setUrl(obj.getString("primary_photo"));

                        // p.id = i;

                        list_data.add(p);

                    }
                    catch (JSONException e){
                        e.printStackTrace();

                    }

                }
                ListAdapter adapter = new ListAdapter(MainActivity.this, list_data);
                list.setAdapter(adapter);
            }

            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {

            }

        });

    }



}
