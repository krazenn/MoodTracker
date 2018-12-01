package com.example.kraken.moodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
    RelativeLayout rLboxHistory;
    ImageButton iBtnSeeComment;
    TextView tVDay;
    LinearLayout lLayoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

    }
}
