package android.bignerdranch.homework22;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<String> data;


    //** playing with json


    String JSON_STRING = "{\"employee\":{\"name\":\"wyatt\",\"salary\":65000}}";
    String name, salary;





    //** done playing with json

    Adapter(Context context, List<String> data) throws FileNotFoundException {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup ViewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.custom_view,ViewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        //bind the textview with data received

        String title = data.get(i);
        String desc = data.get(i+1);

        try {
            // get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            // fetch JSONObject named employee
            JSONObject employee = obj.getJSONObject("employee");
            // get employee name and salary
            name = employee.getString("name");
            salary = employee.getString("salary");

            // set employee name and salary in TextView's

        } catch (JSONException e) {
            e.printStackTrace();
        }


        viewHolder.textTitle.setText(name);
        viewHolder.textDescription.setText(salary);
       // viewHolder.imageView.setImageResource(R.drawable.gamerson);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle,textDescription;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           // imageView = (imageView).findViewById(R.id.imageView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDesc);
        }
    }
}
