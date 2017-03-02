package com.eservices.tandrentreprise.savemydevice.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.activities.MainActivity;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


/**Fragment de la messagerie de l'applciation*/
public class CreateDemandFragment extends Fragment implements View.OnClickListener{

        private EditText etTitle;
        private EditText etDetail;
        private EditText etModele;
        private EditText etType;
        private String title;
        private String detail;
        private String modele;
        private String type;
        private final FirebaseDatabase database = FirebaseDatabase.getInstance();
        private String userId= FirebaseAuth.getInstance().getCurrentUser().getUid();



    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Retourne votre fichier layout
            // Changer R.layout.yourlayoutfilename pour vos fragments
            View v = inflater.inflate(R.layout.fragment_create_demande, container, false);

            Button button_add = (Button) v.findViewById(R.id.button_add);
            button_add.setOnClickListener(this);
            return v;
        }


    public void addDemande(View v) {
        Context context = getActivity().getApplicationContext(); //Context courant
        etTitle = (EditText) v.findViewById(R.id.title); //Champs nom
        etDetail = (EditText) v.findViewById(R.id.detail); //Champs lieu
        etModele = (EditText) v.findViewById(R.id.modele); //Champs freq
        etType = (EditText) v.findViewById(R.id.type); //Champs freq

        title = etTitle.getText().toString();
        detail = etDetail.getText().toString();
        modele= etModele.getText().toString();
        type=etType.getText().toString();

        //Insertion dans la base de données
        DatabaseReference ref = database.getReference("SaveMyDevice");
        DatabaseReference demandesRef = ref.child("demandes");
        Map<String, Demande> demandes = new HashMap<String, Demande>();
        demandes.put("demandeRecente", new Demande(title, detail,modele,type,"dede","iddddddd"));

        demandesRef.setValue(demandes);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_add:
                addDemande(v);
                Toast.makeText(getActivity(), "demande ajoutée avec succès", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                getActivity().startActivity(intent);
                break;
        }
    }

    @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // Vous pouvez changer le titre dans la toolbar de vos differents fragments
            getActivity().setTitle("Créer une demande");
        }
}
