package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button taxi;
    EditText dw,m,addm,addd;
    TextView A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taxi = (Button) findViewById(R.id.button);
        taxi.setOnClickListener(this);
        dw = (EditText) findViewById(R.id.editTextTextPersonName);
        m = (EditText) findViewById(R.id.editTextTextPersonName2);
        addm = (EditText) findViewById(R.id.editTextTextPersonName5);
        addd = (EditText) findViewById(R.id.editTextTextPersonName6);
        A = (TextView) findViewById(R.id.textView2);
    }

    @Override
    public void onClick(View view) {
        double DW = Double.parseDouble(dw.getText().toString());    //基本費率
        double M = Double.parseDouble(m.getText().toString());      //距離
        double Addm = Double.parseDouble(addm.getText().toString());    //每 公尺
        double Addd = Double.parseDouble(addd.getText().toString());    //每段多 元
        double Mm = M/Addm; //多幾段
        int Mmn = (int) Math.floor(Mm);
        if(Mm <= 1){
            A.setText("費用："+DW);
        }
        else if(Mm > 1 && Mmn == Mm){
            int total = (int) (DW +(Mmn-1)*Addd);
            A.setText("費用："+total);
        }
        else{
            int total = (int) (DW + Mmn*Addd);
            A.setText("費用："+total);
        }
    }
}