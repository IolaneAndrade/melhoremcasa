package mds.gpp.saudeemcasa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.model.DrugStore;
import mds.gpp.saudeemcasa.model.Hospital;


public class DrugStoreAdapter extends ArrayAdapter<DrugStore>   {

    private Context context;
    private ArrayList<DrugStore> lista;

    public DrugStoreAdapter(Context context, ArrayList<DrugStore> lista){

        // Setting HospitalAdapter constructor
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Override method to get view
        DrugStore drugStorePosition = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null);

        // Setting image view of list item
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView_item);
        imageView.setImageResource(R.mipmap.farm_popular);

        // Setting name of drugstore on list item
        TextView textView = (TextView) convertView.findViewById(R.id.textView2_item);
        textView.setText((CharSequence) drugStorePosition.getName());

        // Setting phone of drugstore on list item
        TextView textView1 = (TextView) convertView.findViewById(R.id.textView3_item);
        textView1.setText((CharSequence) drugStorePosition.getTelephone());

        // Setting distance of drugstore on list item
        TextView textView2 = (TextView) convertView.findViewById(R.id.textView4_item);
        textView2.setText("3KM");

        return convertView;
    }
}
