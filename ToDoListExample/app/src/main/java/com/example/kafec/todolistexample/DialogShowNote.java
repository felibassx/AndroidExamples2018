package com.example.kafec.todolistexample;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogShowNote extends DialogFragment {

    private Note mNote;

    public void sendNoteSelected(Note noteSelected){
        this.mNote = noteSelected;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Inflar el Dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);

        TextView txtTitle = (TextView) dialogView.findViewById(R.id.txtTitleShow);
        TextView txtDescription = (TextView) dialogView.findViewById(R.id.txtDescriptionShow);

        txtTitle.setText(mNote.getTitle().toString());
        txtDescription.setText(mNote.getDescription().toString());

        ImageView imageViewImportant = (ImageView)dialogView.findViewById(R.id.imageViewImportant);
        ImageView imageViewTodo = (ImageView)dialogView.findViewById(R.id.imageViewTodo);
        ImageView imageViewIdea = (ImageView)dialogView.findViewById(R.id.imageViewIdea);

        if(!mNote.isImportant()){
            imageViewImportant.setVisibility(View.GONE);
        }
        if(!mNote.isTodo()){
            imageViewTodo.setVisibility(View.GONE);
        }
        if(!mNote.isIdea()){
            imageViewIdea.setVisibility(View.GONE);
        }

        Button btnOk = (Button) dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView)
                .setMessage("Tu Nota");

        btnOk.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return builder.create();

    }
}
