package cl.kafecode.contacts;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AddressDetailFragment extends Fragment {

    private ArrayList<Contact> mContacts;
    private Contact currentContact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContacts = AddressBook.getInstance().getContacts();

        int position = (int) getArguments().getInt("position");

        currentContact = mContacts.get(position);
    }

    public static AddressDetailFragment newInstance(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);

        AddressDetailFragment frag = new AddressDetailFragment();
        frag.setArguments(bundle);

        return  frag;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        TextView txtName = (TextView)view.findViewById(R.id.txtName);
        TextView txtAddress = (TextView)view.findViewById(R.id.txtAddress);
        TextView txtZipCode = (TextView)view.findViewById(R.id.txtZipCode);

        txtName.setText(currentContact.getName() + " " + currentContact.getSurname());
        txtAddress.setText(currentContact.getAddress1() + " / " + currentContact.getAddress2());
        txtZipCode.setText(currentContact.getZipCode());

        return view;
    }
}
