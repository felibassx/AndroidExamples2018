package com.example.kafec.todolistexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class DialogNewNote extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Inflar el Dialog
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);

        final EditText editTitle = (EditText)dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = (EditText)dialogView.findViewById(R.id.editDescription);

        final CheckBox checkBoxIdea = (CheckBox)dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = (CheckBox)dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = (CheckBox)dialogView.findViewById(R.id.checkBoxImportant);

        Button btnCancel  = (Button)dialogView.findViewById(R.id.btnCancel);
        Button btnOk  = (Button)dialogView.findViewById(R.id.btnOk);

        builder.setView(dialogView)
                .setMessage("Añadir una nueva nota");

        btnCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                //creamos una instancia de la clase Note
                Note newNote = new Note();

                //configuramos las 5 variables de la nota creada
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());

                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());

                //Se llama ala actividad que ha llamado al dialogo
                MainActivity callingActivity = (MainActivity)getActivity();

                //notificar la nueva nota a la activity
                callingActivity.createNewNote(newNote);

                //Cerrar el dialogo
                dismiss();

            }
        });

        return  builder.create();
    }
}
