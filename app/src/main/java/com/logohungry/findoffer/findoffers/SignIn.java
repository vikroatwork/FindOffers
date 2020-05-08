package com.logohungry.findoffer.findoffers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

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

        ImageButton button = (ImageButton)findViewById(R.id.back_signin_img_button);

        ImageView back =(ImageView)findViewById(R.id.back_img_signin_imageview);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // SignIn.this.onBackPressed();
                startActivity(new Intent(SignIn.this,Choices.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
