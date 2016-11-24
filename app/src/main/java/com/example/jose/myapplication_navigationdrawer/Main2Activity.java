package com.example.jose.myapplication_navigationdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.jose.myapplication_navigationdrawer.R.id.layout1;

public class Main2Activity extends AppCompatActivity {
    RelativeLayout layout1,layoutD;
    EditText etRadio;
    SeekBar sb1,sb2,sb3;
    TextView red,green,blue;
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout1=(RelativeLayout)findViewById(R.id.layout1);
        layout1.setBackgroundColor(Color.WHITE);
        layoutD=(RelativeLayout)findViewById(R.id.layoutDibujo);
        layoutD.setBackgroundColor(Color.WHITE);

        etRadio=(EditText)findViewById(R.id.etRadio);

        r1=(RadioButton)findViewById(R.id.relleno);
        r2=(RadioButton)findViewById(R.id.borde);



        sb1=(SeekBar)findViewById(R.id.sb1);
        sb2=(SeekBar)findViewById(R.id.sb2);
        sb3=(SeekBar)findViewById(R.id.sb3);
        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        sb3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        red=(TextView)findViewById(R.id.red);
        green=(TextView)findViewById(R.id.green);
        blue=(TextView)findViewById(R.id.blue);
        getSupportActionBar().hide();
    }

    class Lienzo extends View {

        public Lienzo(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            int ancho = canvas.getWidth();
            int alto = canvas.getHeight();

            Paint pincel1 = new Paint();

            pincel1.setARGB(255,Integer.parseInt(red.getText().toString()), Integer.parseInt(green.getText().toString()), Integer.parseInt(blue.getText().toString()));
            if(r1.isChecked()) {
                pincel1.setStyle(Paint.Style.FILL);
            }else{
                pincel1.setStyle(Paint.Style.STROKE);
                // dibuja solo la figura no rellena
            }
            try {
                canvas.drawCircle(ancho / 2, alto / 2, Float.parseFloat(etRadio.getText().toString()), pincel1);
            }catch(NumberFormatException e){
                Toast.makeText(this.getContext(),"Has introducio mal el radio",Toast.LENGTH_SHORT).show();
                etRadio.requestFocus();
            }

        }
    }
    public void circulo(View v){
        Lienzo fondo = new Lienzo(this);
        layoutD.addView(fondo);

    }
    public void borrar(View v){

    }

}
