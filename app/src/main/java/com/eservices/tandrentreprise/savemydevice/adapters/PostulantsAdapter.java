package com.eservices.tandrentreprise.savemydevice.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.model.Candidature;

import java.util.List;

/**
 * Adapter de la liste des postulants
 */
public class PostulantsAdapter extends ArrayAdapter<Candidature> {

    public PostulantsAdapter(Context context, List<Candidature> postulants) {
        super(context, R.layout.postulant_list, postulants);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.postulant_list, null);

        TextView name = (TextView) content.findViewById(R.id.name);
        TextView tarif = (TextView) content.findViewById(R.id.tarif);
        ImageButton btnPostulant = (ImageButton)  content.findViewById(R.id.btnPostulant) ;
        ImageView canMove = (ImageView) content.findViewById(R.id.iconcar) ;
        ;
        Candidature cur = getItem(position);

        if (cur.peutBouger==true){
            canMove.setVisibility(View.VISIBLE);
        }else{
            canMove.setVisibility(View.INVISIBLE);
        }

        name.setText(cur.nomPostulant);
        tarif.setText("Tarif : "+cur.prixPropose);
        btnPostulant.setBackgroundResource(R.drawable.ic_validate);

        return content;
    }
}
