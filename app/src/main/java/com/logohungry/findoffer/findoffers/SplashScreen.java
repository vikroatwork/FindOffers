package com.logohungry.findoffer.findoffers;

import android.Manifest;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class SplashScreen extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    Button sign_up_button;
    Typeface typeface;
    TextView or;
    TextView logotext;
    float i =1.0f;

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //   Window w = getWindow();
            // w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //w.setStatusBarColor(Color.rgb(40, 53, 147));
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );

        new CustomVolleyRequestQueue(getApplicationContext()).getmRequestQueue();
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.lottie);
        //img = (ImageView) findViewById(R.id.splashimage);

      //  Bitmap d = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.pd);
      //  int nh = (int) (d.getHeight() * (2048.0 / d.getWidth()));
       // Bitmap scaled = Bitmap.createScaledBitmap(d, 2048, nh, true);
       // img.setImageBitmap(scaled);
        //img.setAlpha(0.2f);


        sign_up_button = (Button)findViewById(R.id.button_sign_in);
        logotext = (TextView) findViewById(R.id.logoText);
        or =(TextView)findViewById(R.id.or_label);
        or.setTypeface(Typeface.createFromAsset(getAssets(),"montserrat_semibold.otf"));
        or.setTextColor(DATA.white_color);

        typeface = Typeface.createFromAsset(getAssets(), "shine.ttf");

       //img.setImageDrawable(getDrawable(R.drawable.splash5));
        //img.setAlpha(0.05f);
        logotext.setTypeface(typeface);
        logotext.setTextColor(DATA.white_color);
        //sign_up_button.setTypeface(Typeface.createFromAsset(getAssets(),"snickes.ttf"));
        sign_up_button.setTextColor(DATA.white_color);
        sign_up_button.setTypeface(Typeface.createFromAsset(getAssets(),"montserrat_semibold.otf"));
        sign_up_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashScreen.this,SignIn.class); //CHOICES  ACTIVITY
                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });


        final ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.splash_layout);

      /*  final ColorDrawable[] cd1 = {
                new ColorDrawable(Color.parseColor("#c62828")),
                new ColorDrawable(Color.parseColor("#D84315")),
        };
*/




        final ValueAnimator anim = ValueAnimator.ofArgb(Color.parseColor("#880E4F"), Color.parseColor("#1A237E"));
        anim.setDuration(2000);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

               // logotext.setBackgroundColor((Integer) anim.getAnimatedValue());

                cl.setBackgroundColor((Integer) anim.getAnimatedValue());
            }
        });
        anim.start();

        callbackManager = CallbackManager.Factory.create();
        LoginButton fb_button = findViewById(R.id.fb_login_button);
        fb_button.setReadPermissions("email");
        fb_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                AccessToken token = AccessToken.getCurrentAccessToken();
                if(token != null)
                {
                    DATA.token=token.getToken();
                    //Log.d("ACCESS TOKEN ",token.getToken());
                }
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }


}
