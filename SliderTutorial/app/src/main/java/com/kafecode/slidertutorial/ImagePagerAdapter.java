package com.kafecode.slidertutorial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ImagePagerAdapter extends PagerAdapter {

    //primero se necesita un contexto, que es que actividad que utilizará el adapter
    Context context;

    //La colección de objetos a ser mostrados
    int[] images;

    //un inflater para crear cada unos de los pageritem dentro del pager
    LayoutInflater inflater;

    //constructor
    public ImagePagerAdapter(Context context, int[] images){

        this.context = context;
        this.images = images;

    }

    @Override
    public int getCount() {
        return this.images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


//Se configura el PagerItem, el objeto que debe ser mostrado
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ImageView imageview;

        //Inflador estandar
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //ItemView donde se colocará la imagen
        View itemView = inflater.inflate(R.layout.pager_item, container, false);

        imageview = (ImageView)itemView.findViewById(R.id.image_view);

        imageview.setImageResource(images[position]);

        ((ViewPager) container).addView(itemView);


        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}
