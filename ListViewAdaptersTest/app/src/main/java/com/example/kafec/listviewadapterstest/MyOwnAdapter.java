package com.example.kafec.listviewadapterstest;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyOwnAdapter extends BaseAdapter {

    List<Animal> myList = new ArrayList<Animal>();

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Animal getItem(int itemPost) {
        return myList.get(itemPost);
    }

    @Override
    public long getItemId(int itemPost) {
        return itemPost;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //aqui recuperamos el objeto a mostrar en la posición i

        return null;
    }
}
