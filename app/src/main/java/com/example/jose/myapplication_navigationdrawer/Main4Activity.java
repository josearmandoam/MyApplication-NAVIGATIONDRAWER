package com.example.jose.myapplication_navigationdrawer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

public class Main4Activity extends AppCompatActivity {
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8;
    RelativeLayout l1,l2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        l1=(RelativeLayout)findViewById(R.id.layout1);
        l2=(RelativeLayout)findViewById(R.id.layout2);
        l1.setBackgroundColor(Color.WHITE);
        l2.setBackgroundColor(Color.WHITE);

        r1=(RadioButton)findViewById(R.id.rdBola);
        r2=(RadioButton)findViewById(R.id.rdGusano);
        r3=(RadioButton)findViewById(R.id.rdCalavera);
        r4=(RadioButton)findViewById(R.id.rdTravolta);
        /*r5=(RadioButton)findViewById(R.id.rdGoku);
        r6=(RadioButton)findViewById(R.id.rdMinions);
        r7=(RadioButton)findViewById(R.id.rdArdilla);
        r8=(RadioButton)findViewById(R.id.rdDori);*/

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r1.isChecked()){
                    dibuja();
                }
            }
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r2.isChecked()){
                    dibuja();
                }
            }
        });
        r3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r3.isChecked()){
                    dibuja();
                }
            }
        });
        r4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(r4.isChecked()){
                    dibuja();
                }
            }
        });

        getSupportActionBar().hide();
    }
    private void dibuja(){
        Lienzo l=new Lienzo(this);
        l2.addView(l);
    }
    public class Lienzo extends View {
        public Lienzo(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            int ancho=canvas.getWidth();
            int alto=canvas.getHeight();
            Bitmap bmp;
            if(r1.isChecked()){
                bmp= BitmapFactory.decodeResource(getResources(),R.mipmap.gohan);
                canvas.drawBitmap(bmp,(ancho/7),(alto/5),null);
            }else{
                if(r2.isChecked()){
                    bmp= BitmapFactory.decodeResource(getResources(),R.mipmap.homer);
                    canvas.drawBitmap(bmp,(ancho/7),(alto/5),null);
                }else{
                    if(r3.isChecked()){
                        bmp= BitmapFactory.decodeResource(getResources(),R.mipmap.mario);
                        canvas.drawBitmap(bmp,(ancho/7),(alto/5),null);
                    }else{
                        if(r4.isChecked()){
                            bmp= BitmapFactory.decodeResource(getResources(),R.mipmap.torre);
                            canvas.drawBitmap(bmp,(ancho/6),(alto/5),null);
                        }
                    }
                }
            }
        }
    }
}
