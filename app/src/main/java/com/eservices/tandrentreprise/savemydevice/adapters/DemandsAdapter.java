package com.eservices.tandrentreprise.savemydevice.adapters;

import android.content.Context;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.R;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter de la liste des demandes
 */
public class DemandsAdapter extends ArrayAdapter<Demande> {

    public DemandsAdapter(Context context, List<Demande> demands) {
        super(context, R.layout.item_list, demands);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.item_list, null);

        TextView title = (TextView) content.findViewById(R.id.title);
        TextView subtitle = (TextView) content.findViewById(R.id.subtitle);
        ImageView iconDemande = (ImageView)  content.findViewById(R.id.iconDemande);


        Demande cur = getItem(position);
        if(cur.type.equals("Hardware")) {
            iconDemande.setImageResource(R.mipmap.type_hardware);
        }else{
            iconDemande.setImageResource(R.mipmap.type_software);
        }

        title.setText(cur.title+ "\n \n");
        title.setTypeface(null, Typeface.BOLD);
        subtitle.setText(cur.detail);

        return content;
    }
}
