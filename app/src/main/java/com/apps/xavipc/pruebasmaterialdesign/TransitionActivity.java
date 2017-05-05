package com.apps.xavipc.pruebasmaterialdesign;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.TextView;

/**
 * Created by XaviPC on 26/04/2017.
 */

public class TransitionActivity extends AppCompatActivity {

    Constants.AnimType type;
    String toolbarTitle, animName;
    TextView mTxvAnimName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // inside your activity (if you did not enable transitions in your theme)
        // For AppCompat getWindow must be called before calling super.OnCreate
        // Must be called before setContentView
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        type = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);
        animName = getIntent().getExtras().getString(Constants.KEY_NAME);

        setUpAnimation();

        bindControl();

        setupToolbar();

        // For overlap between Exiting  MainActivity.java and Entering TransitionActivity.java
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowEnterTransitionOverlap(false);
        }
    }

    private void bindControl() {
        findViewById(R.id.exit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
            }
        });

        mTxvAnimName = (TextView) findViewById(R.id.animName);
        mTxvAnimName.setText(animName);
    }

    protected void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }
        return true;
    }

    private void setUpAnimation() {

        switch (type) {

            case ExplodeJava: { // For Explode By Code
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode enterTransition = new Explode();
//                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                    enterTransition.setDuration(1);
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            }

            case ExplodeXML: { // For Explode By XML
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    enterTransition.setDuration(1);
//                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            }

            case SlideJava: { // For Slide By Code
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Slide enterTransition = new Slide();
                    enterTransition.setSlideEdge(Gravity.RIGHT);
//                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                    enterTransition.setDuration(1);
                    enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            }

            case SlideXML: { // For Slide by XML
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
//                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
                    enterTransition.setDuration(1);
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            }

            case FadeJava: { // For Fade By Code
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Fade enterTransition = new Fade();
//                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                    enterTransition.setDuration(1);
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            }

            case FadeXML: { // For Fade by XML
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
//                    enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
                    enterTransition.setDuration(1);
                    getWindow().setEnterTransition(enterTransition);
                    break;
                }
            }
        }

    }
}
