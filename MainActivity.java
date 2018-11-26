package com.example.kraken.moodtracker;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
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

    public static final String BUNDLE_CURRENT_THEME = "BUNDLE_CURRENT_THEME";
    public static final String BUNDLE_COMMENT = "BUNDLE_COMMENT";
    private SharedPreferences sharedPref ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = findViewById(R.id.layout);
        mImage = findViewById(R.id.ivSmiley);
        ImageButton imgBtnComment = findViewById(R.id.iBtnComment);
        ImageButton imgBtnNext = findViewById(R.id.iBtnNext);
        ImageButton imgBtnHistory = findViewById(R.id.iBtnHistory);

        sharedPref = getPreferences(MODE_PRIVATE);
        mImage.setImageResource(smileyImage[sharedPref.getInt(BUNDLE_CURRENT_THEME,0) -1]);
        mLayout.setBackgroundResource(colorBackground[sharedPref.getInt(BUNDLE_CURRENT_THEME,0) -1]);
        currentImage = sharedPref.getInt(BUNDLE_CURRENT_THEME,0);

        /*
        Permet de switch entre les différents smiley et la couleur du background
         */
        imgBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentImage = currentImage % smileyImage.length;
                mImage.setImageResource(smileyImage[currentImage]);
                mLayout.setBackgroundResource(colorBackground[currentImage]);
                currentImage++;
            }
        });

        /*
        Affiche ou enlève la zone de saisie commentaire
        avec bouton d'enregistrement
         */
        imgBtnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogComment();
                }
        });
        }

        @SuppressLint("SetTextI18n")
        public void dialogComment (){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            LayoutInflater inflater = MainActivity.this.getLayoutInflater();
            builder.setTitle("Humeur du jour");
            View v = inflater.inflate(R.layout.dialog_comment, null);
            final EditText commentInput = v.findViewById(R.id.commentInput);
            commentInput.setText(sharedPref.getString(BUNDLE_COMMENT, null));

            builder.setView(v)
            .setPositiveButton(R.string.Enregistrer, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String comment;
                    comment = commentInput.getText().toString();
                    sharedPref.edit().putInt(BUNDLE_CURRENT_THEME, currentImage).apply();
                    sharedPref.edit().putString(BUNDLE_COMMENT, comment).apply();



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
}
