package com.jsstech.multiplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends AppCompatActivity {




    int score[]={1,2,3,4,5,};
    String total[]={"20%","40%","60%","80%","100%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);


        setupPieChart();
    }

    private void setupPieChart() {

        List<PieEntry> pieEntries=new ArrayList<>();
        for(int i=0;i<score.length;i++){
            score[i]=score[i]*(360/5);
            pieEntries.add(new PieEntry(score[i],total[i]));

        }
        PieDataSet dataSet=new PieDataSet(pieEntries,"Score Board");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data=new PieData(dataSet);

        PieChart chart=(PieChart)findViewById(R.id.pie);
        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();

    }


    }
