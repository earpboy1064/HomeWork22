package android.bignerdranch.homework22;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<MainActivity.Faculty> data;


    //** playing with json


    String JSON_STRING = "{\"employee\":{\"name\":\"wyatt\",\"salary\":65000}}";
    String name, salary;

    private class Faculty

    {
        public String name;

        public String job;

        public String office;

        public String email;

        public String phone;

        public String image;


    }

    //** done playing with json

    Adapter(Context context, ArrayList<MainActivity.Faculty> data) throws FileNotFoundException {
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

        String title = data.get(i).name;
        String desc = data.get(i).job;
        String office = data.get(i).office;
        String phone = data.get(i).phone;
        String email = data.get(i).email;
        String image = data.get(i).image;

       // String[] images = {"curtiss","gamerson", "ppape", "sdinc", "zgao","lwu" };
       // String[] names = {"curtiss","gamerson", "ppape", "sdinc", "zgao","lwu" };
        // String value = images[i];
        viewHolder.textTitle.setText(title);
        viewHolder.textDescription.setText(desc);
        viewHolder.textOffice.setText(office);
        viewHolder.textPhone.setText(phone);
        viewHolder.textEmail.setText(email);

        try {
            viewHolder.mImageView.setImageResource(R.drawable.zgao);
        }
        catch(Exception e)
        {
            Log.i("#######",e.getMessage());



        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle,textDescription,textOffice, textEmail, textPhone;
        ImageView mImageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);

            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDesc);
            textOffice = itemView.findViewById(R.id.textOffice);
            textPhone = itemView.findViewById(R.id.textPhone);
            textEmail = itemView.findViewById(R.id.textEmail);
        }
    }
}
