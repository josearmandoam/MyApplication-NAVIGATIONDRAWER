package com.example.jose.myapplication_navigationdrawer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

public class Main5Activity extends AppCompatActivity {
    Button b;
    ProgressBar bar1;
    RelativeLayout l,l2;
    VideoView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        bar1=(ProgressBar)findViewById(R.id.progressBar3);
        l2=(RelativeLayout)findViewById(R.id.layoutframes);
        l=(RelativeLayout)findViewById(R.id.layoutp);
        l.setBackgroundColor(Color.WHITE);
        l2.setBackgroundColor(Color.WHITE);

        b=(Button)findViewById(R.id.cargar);
        bar1.setMax(8);
        getSupportActionBar().hide();


    }
    public class Lienzo extends View{
        int n;
        public Lienzo(Context context, int n){
            super(context);
            this.n=n;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            int ancho=canvas.getWidth();
            int alto=canvas.getHeight();
            Bitmap bm;
            switch(n){
                case 1:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena1);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 2:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena2);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 3:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena3);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 4:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena4);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 5:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena5);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 6:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena6);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 7:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena7);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 8:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena8);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 9:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena9);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 10:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena10);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 11:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena11);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 12:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena12);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 13:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena13);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 14:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena14);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 15:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena15);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 16:
                    bm= BitmapFactory.decodeResource(getResources(),R.mipmap.escena16);
                    canvas.drawBitmap(bm,(ancho/92),(alto/10),null);
                    break;
                case 17:
                    canvas.drawColor(Color.WHITE);
                    break;

            }
        }
    }
    public void hilo(View v){
        AsyncTaskCargaDatos as=new AsyncTaskCargaDatos();
        as.execute();

    }


    private void dibuja(int n){
        Lienzo l=new Lienzo(this,n);
        l2.addView(l);
    }


    public class AsyncTaskCargaDatos extends AsyncTask<Void, Integer, Boolean> {
        int i;
        @Override
        protected Boolean doInBackground(Void... params) {

            for(i=0; i<=16; i++) {
                try {
                    Thread.sleep(250);

                }
                catch (Exception e) {}


                publishProgress(i*1);

                if(isCancelled())
                    break;
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            dibuja(i);

            int progreso = values[0].intValue();

            bar1.setProgress(progreso);
        }

        @Override
        protected void onPreExecute() {
            bar1.setMax(16);
            bar1.setProgress(0);
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if(result) {
                dibuja(i + 1);
                Toast.makeText(Main5Activity.this,"Ha terminado la reproducción",Toast.LENGTH_SHORT).show();
                bar1.setProgress(0);
                dibuja(17);
            }

        }

        @Override
        protected void onCancelled() {
            Toast.makeText(Main5Activity.this,"Se ha cancelado el Progreso",Toast.LENGTH_SHORT).show();
        }

    }
}
