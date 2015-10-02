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
import mds.gpp.saudeemcasa.model.Hospital;

public class HospitalAdapter extends ArrayAdapter<Hospital>   {

    private Context context;
    private ArrayList<Hospital> lista;

    public HospitalAdapter(Context context, ArrayList<Hospital> lista){

        // Setting HospitalAdapter constructor
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Override method to get view
        Hospital hospitalPosition = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item, null);

        // Setting image view of list item
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView_item);
        imageView.setImageResource(R.mipmap.melhor_em_casa);

        // Setting name of hospital on list item
        TextView textViewName = (TextView) convertView.findViewById(R.id.textView2_item);
        textViewName.setText((CharSequence) hospitalPosition.getName());

        // Setting phone of hospital on list item
        TextView textViewPhone = (TextView) convertView.findViewById(R.id.textView3_item);
        textViewPhone.setText((CharSequence) hospitalPosition.getTelephone());

        if(this.lista.get(position).getDistance() < 1f) {
            // Setting distance of hospital on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.textView4_item);
            textViewDistance.setText(this.lista.get(position).getDistance()+" m");
        }else {
            // Setting distance of hospital on list item
            TextView textViewDistance = (TextView) convertView.findViewById(R.id.textView4_item);
            textViewDistance.setText(convertToKM(this.lista.get(position).getDistance()).toString() + " Km");
        }
        return convertView;
    }

    private Float convertToKM(Float distance){
        return distance/1000;

    }
}
