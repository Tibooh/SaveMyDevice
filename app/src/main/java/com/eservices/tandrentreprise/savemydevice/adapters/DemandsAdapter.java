package com.eservices.tandrentreprise.savemydevice.adapters;

import android.content.Context;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.R;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
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
        TextView subtitle2 = (TextView) content.findViewById(R.id.subtitle2);
        TextView subtitle3 = (TextView) content.findViewById(R.id.subtitle3);
        TextView subtitle4 = (TextView) content.findViewById(R.id.subtitle4);

        ImageView iconDemande = (ImageView)  content.findViewById(R.id.iconDemande);

        Demande cur = getItem(position);
        if(cur.type.equals("Hardware")) {
            iconDemande.setImageResource(R.mipmap.type_hardware);
        }else{
            iconDemande.setImageResource(R.mipmap.type_software);
        }

        title.setText(cur.title);
        title.setTypeface(null, Typeface.BOLD);
        subtitle.setText("sur "+cur.getModeleAppareil());
        subtitle2.setText("en "+cur.getArea());
        int nbCandidatures = cur.getCandidatures().size();
        subtitle3.setText(nbCandidatures+" ");
        if(nbCandidatures==0){
            subtitle3.setTextColor(Color.parseColor("#7FC768"));
        }else if (nbCandidatures<5){
            subtitle3.setTextColor(Color.parseColor("#ff0000"));
        }else{
            subtitle3.setTextColor(Color.parseColor("#ffa500"));
        }

        Date currentDate = new Date(System.currentTimeMillis());
        if (cur.getDateDemande()!=null) {
            if (cur.getDateDemande().getDay() == currentDate.getDay()){
                subtitle4.setText("Aujourd'hui " + android.text.format.DateFormat.format("hh:mm", cur.getDateDemande()));
            }else {
                subtitle4.setText("" + android.text.format.DateFormat.format("dd-MM-yyyy hh:mm", cur.getDateDemande()));
            }


        }

        return content;
    }
}
