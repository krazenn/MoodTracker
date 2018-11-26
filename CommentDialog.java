package com.example.kraken.moodtracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;

import java.util.Objects;



public class CommentDialog extends AppCompatDialogFragment {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
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
        return builder.create();
    }



}
