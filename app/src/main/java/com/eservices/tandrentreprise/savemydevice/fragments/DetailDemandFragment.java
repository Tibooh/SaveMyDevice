package com.eservices.tandrentreprise.savemydevice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.adapters.PostulantsAdapter;
import com.eservices.tandrentreprise.savemydevice.model.Demande;


/**Fragment de la messagerie de l'applciation*/
public class DetailDemandFragment extends Fragment {
    private Demande demande;

    private TextView title;
    private TextView detail;
    private TextView modele;
    private ImageView type;


    @Override
    public void setArguments(Bundle args) {
        this.demande = (Demande) args.getSerializable("Demande");
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_demande, container, false);

        // TODO : Affichage des infos (3.1)

        ListView list = (ListView) v.findViewById(R.id.list_postulant);
        list.setAdapter(new PostulantsAdapter(getContext(), ((MyApplication) getActivity().getApplication()).postulants));

        type = (ImageView) v.findViewById(R.id.type);
        if (demande.type.equals("Hardware")){
            type.setImageResource(R.mipmap.type_hardware);
        }else{
            type.setImageResource(R.mipmap.type_software);
        }
        title = (TextView) v.findViewById(R.id.title);
        detail = (TextView) v.findViewById(R.id.detail);
        modele = (TextView) v.findViewById(R.id.modele);
        if (demande != null) {
            updateDisplay();
        }
        return v;
     }


        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // Vous pouvez changer le titre dans la toolbar de vos differents fragments
            getActivity().setTitle("Détail de la demande");
        }


    public void updateContactView(Demande d) {
        this.demande = d;
        updateDisplay();
    }

    private void updateDisplay() {
        // TODO : Mise a jour des infos (3.2)
        this.title.setText(demande.title);
        this.detail.setText(demande.detail);
        this.modele.setText(demande.modeleAppareil);
    }
}
