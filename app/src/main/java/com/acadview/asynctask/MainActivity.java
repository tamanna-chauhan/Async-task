package com.acadview.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button image,toast;

    ImageView image1;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        toast = findViewById(R.id.toast);

        image1 = findViewById(R.id.image1);

        progressBar = findViewById(R.id.progressBar);


        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"I am Toast",Toast.LENGTH_SHORT).show();
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loadImage();
                new LoadIconTask().execute(R.drawable.zindgi);
            }

        });


    }


    class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap>{


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.zindgi);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            progressBar.setVisibility(progressBar.INVISIBLE);
            image1.setImageBitmap(bitmap);
            super.onPostExecute(bitmap);
        }



        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        }







//    private void loadImage() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//                final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.zindgi);
//
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        image1.setImageBitmap(bitmap);
//
//                    }
//                });
//
//
//            }
//        }).start();
//
//
//    }
}
