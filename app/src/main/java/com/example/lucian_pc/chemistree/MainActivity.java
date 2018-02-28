
package com.example.lucian_pc.chemistree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Main menu of the application
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Button startButton = findViewById(R.id.startButton);
        Button creditsButton = findViewById(R.id.creditsButton);

        // Listens for button press
        creditsButton.setOnClickListener(this);
        startButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.startButton:
                Intent quizIntent = new Intent(this, Quiz.class);
                startActivity(quizIntent);
                break;
            case R.id.creditsButton:
                Intent creditsIntent= new Intent(this, Credits.class);
                startActivity(creditsIntent);
                break;
            default:
                break;
        }
    }
}