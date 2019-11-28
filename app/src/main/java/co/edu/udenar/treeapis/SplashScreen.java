package co.edu.udenar.treeapis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    private final int duracion_splash=1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public  void run(){
                Intent i =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(i);
                finish();
            }

        },duracion_splash);
    }
}
