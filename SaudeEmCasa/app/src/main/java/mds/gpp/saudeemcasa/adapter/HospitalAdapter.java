package mds.gpp.saudeemcasa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import mds.gpp.saudeemcasa.R;
import mds.gpp.saudeemcasa.model.Hospital;

public class HospitalAdapter extends ArrayAdapter<Hospital>   {

    private Context context;
    private ArrayList<Hospital> lista;
    public static final int COUNT = 15;

    public HospitalAdapter(Context context, ArrayList<Hospital> lista){

        // Setting HospitalAdapter constructor
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    //Set the number of objects to show on list
    @Override
    public int getCount() { return COUNT; }

    @Override
    public Hospital getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return populateAdapter(convertView,position);
    }

    private Float convertToKM(Float distance){
        return distance/1000;

    }

    public View populateAdapter(View convertView, int position){
        /*
        TextView textView2 = (TextView) convertView.findViewById(R.id.topbar_name);
        textView2.setText("Lista de Hospitais"); */

        // Override method to get view
        Hospital hospitalPosition = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null);

        // Setting name of drugstore on list item
        TextView textView = (TextView) convertView.findViewById(R.id.textView_LargeText);
        textView.setText((CharSequence) hospitalPosition.getName());

        setDistance(convertView, position);

        return convertView;
    }

    public void setDistance(View convertView, int position) {
        // Formato decimal
        NumberFormat mascara = new DecimalFormat(".##");
        if (this.lista.get(position).getDistance() < 1f) {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.textView_SmallText);
            float distance = this.lista.get(position).getDistance();
            textViewDistance.setText(mascara.format(distance) + " m");
        } else {
            // Setting distance of drugstore on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.textView_SmallText);
            float distance = convertToKM(this.lista.get(position).getDistance());
            textViewDistance.setText(mascara.format(distance) + " Km");
        }
    }

}
