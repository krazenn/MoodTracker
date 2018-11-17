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

    private int currentImage;
    int[] smileyImage = {R.drawable.smileyhappy, R.drawable.smileysuperhappy,R.drawable.smileysad, R.drawable.smileydisapointed, R.drawable.smileynormal};
    int[] colorBackground = {R.color.light_sage, R.color.banana_yellow, R.color.faded_red, R.color.warm_grey, R.color.cornflower_blue_65};

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

        /*
        Permet de switch entre les différents smiley et la couleur du background
         */
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImage++;
                currentImage = currentImage % smileyImage.length;
                mImage.setImageResource(smileyImage[currentImage]);
                mLayout.setBackgroundResource(colorBackground[currentImage]);
            }
        });

        /*
        Affiche ou enlève la zone dez saisie commentaire
        avec bouton d'enregistrement
         */
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

        /*
        Permet d'enregistrer le commentaire saisie
         */
        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLinearLayout.setVisibility(View.INVISIBLE);
            }
        });
    }


}
