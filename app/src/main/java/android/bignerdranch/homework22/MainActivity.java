package android.bignerdranch.homework22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Adapter adapter;
    ArrayList<String> items;

    String name, job, office, email, phone, image;

    class Faculty

    {
        public String name;

        public String job;

        public String office;

        public String email;

        public String phone;

        public String image;


    }



    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = super.getAssets().open("Faculty.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Faculty> employees = new ArrayList<>();
       // Map<String, String> map = new HashMap<String, String>();

        String Json = loadJSONFromAsset();
        try {
            // get JSONObject from JSON file
            JSONArray jsonarray = new JSONArray(Json);
            // fetch JSONObject named employee
            for(int i=0; i< jsonarray.length();i++) {
                JSONObject employee = jsonarray.getJSONObject(i);
                // get employee name and job
                name = employee.getString("name");
                job = employee.getString("Job");
                office = employee.getString("Office");
                email = employee.getString("Email");
                phone = employee.getString("phonenumber");
                image = employee.getString("image");

                Faculty faculty = new Faculty();
                faculty.name = name;
                faculty.job = job;
                faculty.office = office;
                faculty.email= email;
                faculty.phone = phone;
                faculty.image = image;
                employees.add(faculty);


                //employees.add(name);
               // employees.add(job);
               // employees.add(office);
               // employees.add(email);
               // employees.add(phone);
               // employees.add(image);
                // set employee name and job in TextView's



            }
        } catch (JSONException e) {
            e.printStackTrace();
        }









/***
        items = new ArrayList<>();

        items.add(name);
        items.add(job);
        items.add("Second CardView Item");
        items.add("Second Item Desc");
        items.add("Third CardView Item");
        items.add("Third Item Desc");
        items.add("Fourth CardView Item");
        items.add("Fourth Item Desc");
        items.add("Fifth CardView Item");
        items.add("Fifth Item Desc");
        items.add("Sixth CardView Item");
        items.add("Sixth Item Desc");


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            adapter = new Adapter(this, employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(adapter);
 ***/
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        try {
            adapter = new Adapter(this, employees);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(adapter);







    }
}