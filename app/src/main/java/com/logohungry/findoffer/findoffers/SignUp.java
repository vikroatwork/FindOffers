package com.logohungry.findoffer.findoffers;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
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

        ImageButton button = (ImageButton)findViewById(R.id.back_signup_img_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp.this.onBackPressed();
            }
        });

        TextView signup_tv = (TextView)findViewById(R.id.sign_up_tv);

        signup_tv.setTypeface(Typeface.createFromAsset(getAssets(),"montserrat_bold.otf"));

        String t1 = "vikroatwork@gmail.com";
        String t2 = "abc123";

        new JSONData().createUser(new CustomVolleyRequestQueue(getApplicationContext()).getmRequestQueue(),t1+","+t2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,SplashScreen.class));
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
