package com.example.lucian_pc.chemistree;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Credits animation screen
 */

public class Credits extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Removes title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Removes notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.credits);

        // Declares images for background animation transition
        final ImageView backgroundOne = findViewById(R.id.background_one);
        final ImageView backgroundTwo = findViewById(R.id.background_two);

        // Sets the animation time, speed
        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(9000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            // Calculates the offset for animation
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float height = backgroundOne.getHeight();
                final float translationY = height * progress;
                backgroundOne.setTranslationY(translationY);
                backgroundTwo.setTranslationY(translationY - height);
            }
        });

        animator.start();

        // Returns user to main menu
        Button backCredits = findViewById(R.id.backCredits);
        backCredits.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backCredits:
                Intent backCreditsIntent = new Intent(this, MainActivity.class);
                startActivity(backCreditsIntent);
                break;
        }
    }
}