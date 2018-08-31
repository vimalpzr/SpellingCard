package com.example.jkcshop.spellingcard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Categories extends AppCompatActivity {
    List<NewModel> newModelList;
    NewAdapter newAdapter;
    GridView simpleGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView backbtn = (ImageView) findViewById(R.id.backbutton);
        ImageView search = (ImageView) findViewById(R.id.searchbutton);
        search.setImageResource(R.drawable.searchh);
        backbtn.setImageResource(R.drawable.arrow_back_white);



        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Categories.super.onBackPressed();
            }
        });




        newModelList=new ArrayList<>();

        simpleGrid = (GridView) findViewById(R.id.simpleGridView);



        newModelList.add(new NewModel("Basic",
                R.drawable.basic));

        newModelList.add(new NewModel("Animals",
                R.drawable.animals));

        newModelList.add(new NewModel("Vehicles",
                R.drawable.vehicles));

        newModelList.add(new NewModel("Flowers",
                R.drawable.flowers));

        newAdapter=new NewAdapter(this,R.layout.each_category_layout,newModelList);
        simpleGrid.setAdapter(newAdapter);


    }






    public  class NewAdapter extends ArrayAdapter {
        private List<NewModel> newModelsList;
        private int resource;
        private final LayoutInflater inflater;

        public NewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
            super(context, resource, objects);
            newModelsList = objects;
            this.resource = resource;
            inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {

                convertView = inflater.inflate(resource, null);


            }

            final TextView categorynames;
            final ImageView img;


            img=convertView.findViewById(R.id.sub_images);
            categorynames=convertView.findViewById(R.id.sub_texts);


            categorynames.setText(newModelsList.get(position).getCat_name());

            img.setImageDrawable(getApplicationContext().getResources().getDrawable(newModelsList.get(position).getCat_img()));

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (categorynames.getText().toString().trim().equals("Basic")){
                        Intent i=new Intent(Categories.this,Learn.class);
                        i.putExtra("catname",categorynames.getText().toString().trim());
                        startActivity(i);
                    }else if (categorynames.getText().toString().trim().equals("Animals")){
                        Intent i=new Intent(Categories.this,Animal.class);
                        i.putExtra("catname",categorynames.getText().toString().trim());
                        startActivity(i);
                    }
                    else {
                        Intent i=new Intent(Categories.this,Animal.class);
                        i.putExtra("catname",categorynames.getText().toString().trim());
                        startActivity(i);
                    }
                }
            });





            return convertView;
        }
    }
}
