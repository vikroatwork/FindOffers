package com.logohungry.findoffer.findoffers;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Choices extends AppCompatActivity {

    //TextView leisure_tv,foods_tv,apparels_tv,music_tv,home_items_tv,electronics_tv,cosmetics_tv,books_tv;
    TextView choices_title;
    ImageButton leisure_imgButton,foods_imgButton,apparels_imgButton,music_imgButton,home_items_imgButton,electronics_imgButton,cosmetics_imgButton,books_imgButton;
    Button continueNext;
    ConstraintLayout constraint_choices;

    int choices =0;
    boolean flag =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);
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

        choices_title = (TextView)findViewById(R.id.choices_title_tv);

        continueNext = (Button)findViewById(R.id.choices_selected_button);


        leisure_imgButton =(ImageButton)findViewById(R.id.leisure_imgbutton);
        foods_imgButton =(ImageButton)findViewById(R.id.foods_imgbutton);
        apparels_imgButton =(ImageButton)findViewById(R.id.apparels_imgbutton);
        music_imgButton=(ImageButton)findViewById(R.id.music_imgbutton);
        home_items_imgButton=(ImageButton)findViewById(R.id.home_items_imgbutton);
        electronics_imgButton=(ImageButton)findViewById(R.id.electronics_imgbutton);
        cosmetics_imgButton =(ImageButton)findViewById(R.id.cosmetics_imgButton);
        books_imgButton =(ImageButton)findViewById(R.id.books_imgbutton);
        constraint_choices = (ConstraintLayout)findViewById(R.id.constrainLayout_choices);



       leisure_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(leisure_imgButton.getBackground() ==null)
               {
                   leisure_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   --choices;
                   leisure_imgButton.setBackground(null);
               }

           }
       });
       foods_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(foods_imgButton.getBackground() ==null)
               {
                   foods_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   --choices;
                   foods_imgButton.setBackground(null);
               }

           }
       });
       apparels_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(apparels_imgButton.getBackground() ==null)
               {
                   apparels_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   --choices;
                   apparels_imgButton.setBackground(null);
               }

           }
       });
       music_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(music_imgButton.getBackground() == null)
               {
                   music_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   --choices;
                   music_imgButton.setBackground(null);
               }
           }
       });
       home_items_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(home_items_imgButton.getBackground() ==null)
               {
                   home_items_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   home_items_imgButton.setBackground(null);
                   --choices;
               }

           }
       });
       electronics_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(electronics_imgButton.getBackground() ==null)
               {
                   electronics_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   electronics_imgButton.setBackground(null);
                   --choices;
               }

           }
       });
       cosmetics_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(cosmetics_imgButton.getBackground() ==null)
               {
                   cosmetics_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   cosmetics_imgButton.setBackground(null);
                   --choices;
               }

           }
       });
       books_imgButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(books_imgButton.getBackground() ==null)
               {
                   books_imgButton.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.circle));
                   ++choices;
               }
               else
               {
                   books_imgButton.setBackground(null);
                   --choices;
               }

           }
       });

       continueNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               action();
           }
       });

       constraint_choices.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               action();
           }
       });



        Typeface mont = Typeface.createFromAsset(getAssets(),"montserrat_semibold.otf");
        choices_title.setTypeface(mont);
        continueNext.setTypeface(mont);
        continueNext.setTextColor(DATA.bluish_white_color);
        choices_title.setTextColor(DATA.bluish_white_color);


    }

    void action()
    {
        if(flag == false) {
            if (choices >= 3) {
                //Toast.makeText(getBaseContext(),"OK", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Choices.this, Loading.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                flag = true;

            } else {
                Toast.makeText(getBaseContext(), "Please select minimum three choices", Toast.LENGTH_LONG).show();
            }
        }
    }
}
