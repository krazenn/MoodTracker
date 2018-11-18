package com.example.kraken.moodtracker;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mLayout;
    private ImageView mImage;

    private int currentImage;
    private int[] smileyImage = {R.drawable.smileyhappy, R.drawable.smileysuperhappy,R.drawable.smileysad, R.drawable.smileydisapointed, R.drawable.smileynormal};
    private int[] colorBackground = {R.color.light_sage, R.color.banana_yellow, R.color.faded_red, R.color.warm_grey, R.color.cornflower_blue_65};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = findViewById(R.id.layout);
        mImage = findViewById(R.id.imagehappy);
        ImageButton imgBtnComment = findViewById(R.id.comment);
        ImageButton imgBtnNext = findViewById(R.id.next);
        ImageButton imgBtnHistory = findViewById(R.id.history);

        /*
        Permet de switch entre les différents smiley et la couleur du background
         */
        imgBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImage++;
                currentImage = currentImage % smileyImage.length;
                mImage.setImageResource(smileyImage[currentImage]);
                mLayout.setBackgroundResource(colorBackground[currentImage]);
            }
        });

        /*
        Affiche ou enlève la zone de saisie commentaire
        avec bouton d'enregistrement
         */
        imgBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                builder.setTitle("Humeur du jour");
                builder.setView(inflater.inflate(R.layout.dialog_comment, null))
                        .setPositiveButton(R.string.Enregistrer, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton(R.string.Annuler, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create();
                builder.show();
                }
        });
    }
}
