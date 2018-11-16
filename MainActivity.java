package com.example.kraken.moodtracker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mLayout;
    ImageView mImage;
    ImageButton mComment;
    ImageButton mHistory;
    ImageButton mNext;
    LinearLayout mLinearLayout;
    Button mSave;

    int a = 0;
    int b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = findViewById(R.id.layout);
        mImage = findViewById(R.id.imagehappy);
         mComment = findViewById(R.id.comment);
         mNext = findViewById(R.id.next);
        mHistory = findViewById(R.id.history);
        mLinearLayout = findViewById(R.id.input_comment);
        mSave = findViewById(R.id.save);

        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.next:
                        if (a == 0) {
                            mImage.setImageResource(R.drawable.smileysuperhappy);
                            mLayout.setBackgroundResource(R.color.banana_yellow);
                            a = 1;
                        } else if (a == 1) {
                            mImage.setImageResource(R.drawable.smileysad);
                            mLayout.setBackgroundResource(R.color.faded_red);
                            a = 2;
                        } else if (a == 2) {
                            mImage.setImageResource(R.drawable.smileydisapointed);
                            mLayout.setBackgroundResource(R.color.warm_grey);
                            a = 3;
                        } else if (a == 3) {
                            mImage.setImageResource(R.drawable.smileynormal);
                            mLayout.setBackgroundResource(R.color.cornflower_blue_65);
                            a = 4;
                        }
                         else if (a == 4) {
                            mImage.setImageResource(R.drawable.smileyhappy);
                            mLayout.setBackgroundResource(R.color.light_sage);
                        a = 0;
                        }
                        break;
                }
            }
        });

        mComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        if (b == 0) {
                            mLinearLayout.setVisibility(View.VISIBLE);
                            b = 1;
                        }
                        else if (b == 1){
                            mLinearLayout.setVisibility(View.INVISIBLE);
                            b = 0;
                        }
            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayout.setVisibility(View.INVISIBLE);
            }
        });
    }


}
