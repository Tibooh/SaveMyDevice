package com.eservices.tandrentreprise.savemydevice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


/**Fragment de la messagerie de l'applciation*/
public class ProfilFragment extends Fragment {

    private TextView pseudo;
    private TextView nom;
    private TextView prenom;
    private TextView region;
    private TextView age;
    private TextView adresse;
    private TextView codePostal;
    private TextView ville;
    private TextView nbIntervention;
    private TextView nbAnnonces;
    private TextView gainTotal;
    Button validate;


        private final FirebaseDatabase database = FirebaseDatabase.getInstance();
        private String userId= FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profil, null);
        // TODO : Affichage des infos (3.1)
        pseudo = (TextView) v.findViewById(R.id.tv_pseudo);
        nom = (TextView) v.findViewById(R.id.tv_nom);
        prenom = (TextView) v.findViewById(R.id.tv_prenom);

        return v;
    }


    @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Vous pouvez changer le titre dans la toolbar de vos differents fragments
        getActivity().setTitle("Mon compte");
    }

}
