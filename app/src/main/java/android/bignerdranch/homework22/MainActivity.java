package android.bignerdranch.homework22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Adapter adapter;
    ArrayList<String> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        items.add("First CardView Item");
        items.add("First Item Desc");
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
            adapter = new Adapter(this, items);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mRecyclerView.setAdapter(adapter);


    }
}