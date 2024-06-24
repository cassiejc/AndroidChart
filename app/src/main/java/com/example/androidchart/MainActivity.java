package com.example.androidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    MqttClient client;
//    TextView tv;
    BarChart bc;
//    ArrayList<BarEntry> temperatureData = new ArrayList<>();
//    ArrayList<BarEntry> humidityData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bc = findViewById(R.id.mychart);
        
        BarData barData = new BarData(getLabel(),getDataSet());
        bc.setData(barData);
        bc.setDescription("Contoh Barchart");
        bc.animateXY(2000,2000);
        bc.invalidate();

    }

    public ArrayList getDataSet() {
        ArrayList datasets = new ArrayList();
        ArrayList valueset1 = new ArrayList();
        ArrayList valueset2 = new ArrayList();

        float dummy;
        for (int i=0;i<6;i++){
            dummy = (float) ((Math.random()*200)-30);
            valueset1.add(new BarEntry(dummy,i));

            dummy = (float) ((Math.random()*200)-30);
            valueset2.add(new BarEntry(dummy,i));
        }
        BarDataSet barDataSet1 = new BarDataSet(valueset1,"Data Set 1");
        barDataSet1.setColor(Color.rgb(0,200,0));
        BarDataSet barDataSet2 = new BarDataSet(valueset2,"Data Set 2");
        barDataSet1.setColor(Color.rgb(0,0,150));

        datasets.add(barDataSet1);
        datasets.add(barDataSet2);


        return datasets;
    }

    public ArrayList getLabel() {
        ArrayList xlabel = new ArrayList();
        xlabel.add("Jan");
        xlabel.add("Feb");
        xlabel.add("Mar");
        xlabel.add("Apr");
        xlabel.add("Mei");
        xlabel.add("Jun");

        return xlabel;
    }
}