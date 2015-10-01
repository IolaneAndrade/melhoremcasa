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

    public class DrugStoreAdapterWithoutGPS extends ArrayAdapter<DrugStore> {
        private Context context;
        private ArrayList<DrugStore> lista;

    public DrugStoreAdapterWithoutGPS(Context context, ArrayList<DrugStore> lista) {

        // Setting HospitalAdapter constructor
        super(context, 0, lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Override method to get view
        DrugStore drugStorePosition = this.lista.get(position);
        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_list_drugstore, null);

        // Setting image view of list item
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView_item);
        imageView.setImageResource(R.mipmap.arrow_right);

        // Setting name of drugStore on list item
        TextView textViewName = (TextView) convertView.findViewById(R.id.tvNameDrugStore);
        textViewName.setText((CharSequence) drugStorePosition.getName());

        // Setting phone of drugstore on list item
        TextView textViewPhone = (TextView) convertView.findViewById(R.id.tvPhoneDrugStore);
        textViewPhone.setText((CharSequence) drugStorePosition.getTelephone());

        TextView textViewDistance = (TextView) convertView.findViewById(R.id.tvDistance);
        textViewDistance.setText(" ");

        return convertView;
        }
    }