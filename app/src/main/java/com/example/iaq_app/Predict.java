package com.example.iaq_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Predict extends AppCompatActivity {
    LineGraphSeries<DataPoint> series;
    GraphView graph;
    TextView info;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);
        double x,y;
        graph = (GraphView) findViewById(R.id.graphView);
        info = (TextView)findViewById(R.id.text);
        Intent i=getIntent();
        category = i.getExtras().getString("Category");
        info.setText("You are Predicting "+category);
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
}