package com.example.jkcshop.spellingcard;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class Learn extends AppCompatActivity {

    GridView simpleGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);


        simpleGrid = (GridView) findViewById(R.id.gridview);
        ArrayList<Integer> imgid=new ArrayList<>();
        imgid.add(R.drawable.a);
        imgid.add(R.drawable.b);
        imgid.add(R.drawable.c);


        NewAdapter adapter = new NewAdapter(getApplicationContext(), R.layout.each_alphabet,imgid);
        simpleGrid.setAdapter(adapter);
    }


    public  class NewAdapter extends ArrayAdapter {
        private int resource;
        private final LayoutInflater inflater;
        private List<Integer> list;

        public NewAdapter(@NonNull Context context, @LayoutRes int resource,@NonNull List objects) {
            super(context, resource, objects);
            this.resource = resource;
            list =  objects;
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {

                convertView = inflater.inflate(resource, null);


            }

            ImageView alphabet =  convertView.findViewById(R.id.alphabet);
            alphabet.setImageResource(list.get(position));


            alphabet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String[] alphabets_string=getApplicationContext().getResources().getStringArray(R.array.alphabets);
                    Intent intent=new Intent(Learn.this,LearnEachAlphabet.class);
                    intent.putExtra("alphabet",alphabets_string[position]);
                    startActivity(intent);

                }
            });



            return convertView;
        }
    }
}
