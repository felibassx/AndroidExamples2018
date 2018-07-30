package cl.kafecode.listviewexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactAdapter mContactAdapter;

    List<Contact> contactList = new ArrayList<Contact>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contact contact1 = new Contact(1,"Felipe Hernández", "+5698889973", "felipe@mail.com");
        contactList.add(contact1);

        Contact contact2 = new Contact(2,"Eduardo Rojas", "+5698889999", "eduardo@mail.com");
        contactList.add(contact2);

        Contact contact3 = new Contact(3,"Carlos Olguin", "+5698889966", "carlos@mail.com");
        contactList.add(contact3);

        Contact contact4 = new Contact(4,"Juan Perez", "+5698889955", "juan@mail.com");
        contactList.add(contact4);

        Contact contact5 = new Contact(5,"Ramon Valdes", "+5698889966", "ramon@mail.com");
        contactList.add(contact5);

        Contact contact6 = new Contact(6,"Manuel Ramos", "+5698889933", "manuel@mail.com");
        contactList.add(contact6);

        Contact contact7 = new Contact(1,"Felipe Hernández", "+5698889973", "felipe@mail.com");
        contactList.add(contact7);

        //implementacion del adapter
        mContactAdapter = new ContactAdapter();

        ListView listContact = (ListView) findViewById(R.id.list_view_example);
        listContact.setAdapter(mContactAdapter);

    }



    public class ContactAdapter extends BaseAdapter {



        @Override
        public int getCount() {
            return contactList.size();
        }

        @Override
        public Contact getItem(int itemPos) {
            return contactList.get(itemPos);
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
                view = inflater.inflate(R.layout.list_item_example, viewGroup, false);
            }

            TextView txtNameContact = (TextView) view.findViewById(R.id.txt_name_contact_item);
            TextView txtNumberContact = (TextView) view.findViewById(R.id.txt_number_contact_item);


            Contact currentContact = contactList.get(itemPos);

            txtNameContact.setText(currentContact.getmNameContact().toString());
            txtNumberContact.setText(currentContact.getmNumberContact().toString());

            return view;
        }
    }
}
