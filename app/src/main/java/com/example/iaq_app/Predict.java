package com.example.iaq_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Predict extends AppCompatActivity {
    private LineGraphSeries<DataPoint> series;
    private GraphView graph;
    private TextView info;
    private String category;
    private String model;
    private Button SelectModel;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);
        double x,y;
        graph = (GraphView) findViewById(R.id.graphView);
        info = (TextView)findViewById(R.id.text);
        model="Arima";
        SelectModel = (Button)findViewById(R.id.changeModel);
        //Adding onclick listner on button
        SelectModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu = new PopupMenu(getApplicationContext(),v);
                popupMenu.setOnMenuItemClickListener(Predict.this::onOptionsItemSelected);


                popupMenu.inflate(R.menu.menu_item);
                popupMenu.show();


            }

        });


Intent i=getIntent();
        category = i.getExtras().getString("Category");
        info.setText("You are Predicting "+category+" Using "+model);
        series = new LineGraphSeries<DataPoint>();
        series.appendData(new DataPoint(0,5.0),true,07);
        series.appendData(new DataPoint(0,2.5),true,07);
        series.appendData(new DataPoint(1,4),true,07);
        series.appendData(new DataPoint(2,2.9),true,07);
        series.appendData(new DataPoint(3.8,0.7),true,07);
        series.appendData(new DataPoint(4.7,5),true,07);
        series.appendData(new DataPoint(6,2),true,07);
        series.appendData(new DataPoint(6,3),true,07);
        graph.addSeries(series);

}
    //Getting selected item from pop-up menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.arima:
            {
                model="Arima";
                info.setText("You are Predicting "+category+" Using "+model);
                return  true;
            }
            case R.id.lsdm:
            {
                model="LSDM";
                info.setText("You are Predicting "+category+" Using "+model);
                return  true;
            }
            case R.id.fbprophet:
            {
                model="FBProphet";
                info.setText("You are Predicting "+category+" Using "+model);
                return  true;
            }
            default:
            {
                return false;
            }


        }
    }



}