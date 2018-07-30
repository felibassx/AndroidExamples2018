package com.example.kafec.todolistexample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   private NoteAdapter mNoteAdapter;

   private boolean mSound;
   private int mAnimaOption;
   private SharedPreferences mPrefs;

   int mIdBeep = -1;
   SoundPool mSp;

   private void loadSound(){
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
           //Código para Lollypop o posterios
           //El nuevo modo de inicializar el soundpool es con AudioAttributes
           AudioAttributes attr = new AudioAttributes.Builder()
                   .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                   .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                   .build();

           //construir el soundpool
           mSp = new SoundPool.Builder()
                   .setMaxStreams(5)
                   .setAudioAttributes(attr)
                   .build();


       }else{
           //Código para versiones anteriores a Lolmlypop
           mSp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
       }
       try{
           AssetManager manager = this.getAssets();
           AssetFileDescriptor descriptor = manager.openFd("fx1.ogg");
           mIdBeep = mSp.load(descriptor, 0);

       }catch(IOException e){
           e.printStackTrace();
       }

   }

   private Animation mAnimFadeIn, mAnimFlash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoteAdapter = new NoteAdapter();

        ListView listNote = (ListView) findViewById(R.id.list_view);
        listNote.setAdapter(mNoteAdapter);

        //mostrar el dialog con la nota, en el onClick del item
        listNote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int itemPos, long id) {

                if(mSound){
                    mSp.play(mIdBeep, 1, 1, 0, 0,1);
                }

                Note tempNote = mNoteAdapter.getItem(itemPos);

                //Creamos una instancia de show note
                DialogShowNote dialog = new DialogShowNote();
                dialog.sendNoteSelected(tempNote);

                dialog.show(getSupportFragmentManager(), "show_note");

            }
        });

        //Click largo
        listNote.setLongClickable(true);

        listNote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int whichItem, long id) {
                mNoteAdapter.deleteNote(whichItem);
                return false;
            }
        });
        //Fin Click largo


        loadSound();


    }

    @Override
    protected void onResume(){
        super.onResume();

        mPrefs = getSharedPreferences("To Do List", MODE_PRIVATE);
        mSound = mPrefs.getBoolean("sound", true);
        mAnimaOption = mPrefs.getInt("anim option", SettingsActivity.FAST);


        //Cargar los ajustes
        mAnimFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        mAnimFlash  = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flash);

        if(mAnimaOption == SettingsActivity.FAST){
            mAnimFlash.setDuration(100);
        }else if(mAnimaOption == SettingsActivity.SLOW){
            mAnimFlash.setDuration(1000);
        }

        mNoteAdapter.notifyDataSetChanged();
    }

    public void createNewNote(Note newNote){
        //Este método recivirá una nota desde el dialogo...
        mNoteAdapter.addNote(newNote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.action_add){
            DialogNewNote dialog = new DialogNewNote();

            dialog.show(getSupportFragmentManager(), "note_new");
        }

        if(item.getItemId() == R.id.action_settings){

            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);

        }


        return false;

    }

    @Override
    protected void onPause() {
        super.onPause();

        //OnPause es el mejor lugar para guardar cosas
        mNoteAdapter.saveNotes();
    }

    public class NoteAdapter extends BaseAdapter {

        List<Note> noteList = new ArrayList<Note>();
        private JSONSerializer mSerializer;

        public NoteAdapter(){

            mSerializer = new JSONSerializer("ToDoList.json", MainActivity.this.getApplicationContext());

            try{
                noteList = mSerializer.load();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        public void saveNotes(){
            try{
                mSerializer.save(noteList);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        @Override
        public int getCount() {
            return noteList.size();
        }

        @Override
        public Note getItem(int itemPos) {
            return noteList.get(itemPos);
        }

        @Override
        public long getItemId(int itemPos) {
            return itemPos;
        }

        @Override
        public View getView(int itemPos, View view, ViewGroup viewGroup) {

            //Lógica de las celdas de la lista
            if (view == null) {
                //La vista aún no a sido accedida
                //Primero hay que inflarla a partir del layout list_item.xml

                //Instancio el inflador por defecto de android
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_item, viewGroup, false);
            }


            //La vista esta bien definida
            //se procede a ocultar las imagenes sobre el layout
            //y rellenar los text view
            TextView textViewTitle = (TextView) view.findViewById(R.id.text_view_title);
            TextView textViewDescription = (TextView) view.findViewById(R.id.text_view_description);

            ImageView ivImportant = (ImageView) view.findViewById(R.id.image_view_important);
            ImageView ivTodo = (ImageView) view.findViewById(R.id.image_view_todo);
            ImageView ivIdea = (ImageView) view.findViewById(R.id.image_view_idea);



            Note currentNote = noteList.get(itemPos);

            if(currentNote.isImportant() && mAnimaOption!=SettingsActivity.NONE){
                view.setAnimation(mAnimFlash);
            }else{
                view.setAnimation(mAnimFadeIn);
            }

            if (!currentNote.isImportant()) {
                ivImportant.setVisibility(View.GONE);
            }
            if (!currentNote.isTodo()) {
                ivTodo.setVisibility(View.GONE);
            }
            if (!currentNote.isIdea()) {
                ivIdea.setVisibility(View.GONE);
            }

            textViewTitle.setText(currentNote.getTitle().toString());
            textViewDescription.setText(currentNote.getDescription().toString());

            return view;
        }

        public void addNote(Note n){
            noteList.add(n);
            notifyDataSetChanged();
        }

        public void deleteNote(int n){
            noteList.remove(n);
            notifyDataSetChanged();
        }

    }

}
