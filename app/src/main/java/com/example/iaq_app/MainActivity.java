package com.example.iaq_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner city_spinner,days_spinner,category_spinner;
    private Button pridict;
    private String category;
    private ArrayAdapter<CharSequence> Days_List;
    private ArrayAdapter<CharSequence> Category_List;
    private ArrayAdapter<CharSequence> City_List;
    private String selectedCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city_spinner = (Spinner)findViewById(R.id.spinner_city);
        days_spinner = (Spinner)findViewById(R.id.spinner_days);
        category_spinner = (Spinner)findViewById(R.id.spinner_category);
        
        Days_List = ArrayAdapter.createFromResource(this,R.array.Days_arrays, android.R.layout.select_dialog_item);
        Category_List = ArrayAdapter.createFromResource(this,R.array.Category_forAbbottabad, android.R.layout.select_dialog_item);
        City_List = ArrayAdapter.createFromResource(this, R.array.city_arrays, android.R.layout.select_dialog_item);

        city_spinner.setAdapter(City_List);
        days_spinner.setAdapter(Days_List);
        category_spinner.setAdapter(Category_List);
        city_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city = City_List.getItem(position).toString();
                updateCategorySpinner(city);
                Log.d("info", "onItemSelected: "+city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = Category_List.getItem(position).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String city = City_List.getItem(position).toString();
        updateCategorySpinner(city);
        Log.d("info", "onItemSelected: "+city);

    }

    private void updateCategorySpinner(String city) {
        int aid = 0;
        if(city.equals("Abbottabad"))
        {
            aid = R.array.Category_forAbbottabad;
        }
        else
        {
            aid = R.array.Category_forOthers;
        }
        Category_List = ArrayAdapter.createFromResource(this, aid , android.R.layout.select_dialog_item);

        category_spinner.setAdapter(Category_List);
    }

    public void Pridict(View view) {
         Intent intent = new Intent(getApplicationContext(),Predict.class);

        intent.putExtra("Category",category);
        startActivity(intent);

    }
}