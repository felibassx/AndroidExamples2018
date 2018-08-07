package cl.kafecode.contacts;

import android.app.ListFragment;
import android.arch.lifecycle.Lifecycling;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AddressListFragment extends ListFragment {

    private ActivityComs mActivityComs;

    private ArrayList<Contact> contacts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contacts = AddressBook.getInstance().getContacts();
        AddressListAdapter adapter = new AddressListAdapter(contacts);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        //Context es de tipo main activity
        mActivityComs = (ActivityComs)context;

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivityComs = null;

    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {

        mActivityComs.onListItemSelected(position);

    }

    //Clase interna
    public class AddressListAdapter extends ArrayAdapter<Contact> {

        public AddressListAdapter(ArrayList<Contact> contacts){
            super(getActivity(), R.layout.list_item, contacts);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)getActivity().getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_item, null);
            }

            Contact currentContact = getItem(position);

            TextView txtName = (TextView) convertView.findViewById(R.id.txtName);

            txtName.setText(currentContact.getName() + " " + currentContact.getSurname());

            return  convertView;
        }
    }
}




