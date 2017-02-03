package com.eservices.tandrentreprise.savemydevice.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.R;


/**Fragment de la messagerie de l'applciation*/
public class CreateDemandFragment extends Fragment {

        private EditText title;
        private EditText detail;
        private EditText modele;
        private EditText type;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Retourne votre fichier layout
            // Changer R.layout.yourlayoutfilename pour vos fragments
            View v = inflater.inflate(R.layout.fragment_create_demande, container, false);

            return v;
        }


    public void addDemande(View v) {
        Context context = getActivity().getApplicationContext(); //Context courant
        title = (EditText) v.findViewById(R.id.title); //Champs nom
        detail = (EditText) v.findViewById(R.id.detail); //Champs lieu
        modele = (EditText) v.findViewById(R.id.modele); //Champs freq
        type = (EditText) v.findViewById(R.id.type); //Champs freq

        //Insertion dans la base de données


    }


    @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // Vous pouvez changer le titre dans la toolbar de vos differents fragments
            getActivity().setTitle("Créer une demande");
        }
}
