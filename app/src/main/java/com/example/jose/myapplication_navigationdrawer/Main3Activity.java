package com.example.jose.myapplication_navigationdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    EditText alto,ancho;
    TextView rojo,azul,verde;
    RelativeLayout l1,l2;
    RadioButton r1,r2;
    SeekBar s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        l1=(RelativeLayout)findViewById(R.id.layout1);
        l2=(RelativeLayout)findViewById(R.id.layoutDibujo);

        l1.setBackgroundColor(Color.WHITE);
        l2.setBackgroundColor(Color.WHITE);

        alto=(EditText)findViewById(R.id.alto);
        ancho=(EditText)findViewById(R.id.ancho);

        rojo=(TextView)findViewById(R.id.red);
        azul=(TextView)findViewById(R.id.blue);
        verde=(TextView)findViewById(R.id.green);

        r1=(RadioButton)findViewById(R.id.rbR);
        r2=(RadioButton)findViewById(R.id.rbB);

        s1=(SeekBar)findViewById(R.id.seekBar);
        s2=(SeekBar)findViewById(R.id.seekBar2);
        s3=(SeekBar)findViewById(R.id.seekBar3);

        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                rojo.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                verde.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                azul.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        getSupportActionBar().hide();
    }

    public class Lienzo extends View{
        public Lienzo(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
          //  super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            Paint pincel=new Paint();
            int x=canvas.getWidth();
            int y=canvas.getHeight();
            pincel.setStrokeWidth(5);
            pincel.setARGB(255,Integer.parseInt(rojo.getText().toString()),Integer.parseInt(verde.getText().toString()),Integer.parseInt(azul.getText().toString()));
            if(r1.isChecked()) {
                pincel.setStyle(Paint.Style.FILL);
            }else{
                    pincel.setStyle(Paint.Style.STROKE);
            }
            //canvas.drawRect(100,500,Float.parseFloat(ancho.getText().toString()),Float.parseFloat(alto.getText().toString()),pincel);
            canvas.drawRect(400,400,Integer.parseInt(ancho.getText().toString()), Integer.parseInt(alto.getText().toString()),pincel);

        }

    }
    public void dibujar(View v){
        Lienzo l=new Lienzo(this);
        l2.addView(l);
    }
}
