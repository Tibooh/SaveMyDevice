package com.eservices.tandrentreprise.savemydevice.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**Fragment de la messagerie de l'applciation*/
public class CreateDemandFragment extends Fragment {

        private EditText title;
        private EditText detail;
        private Spinner modele;
        private Spinner type;
        Button validate;
        Button btnBack;

        private final FirebaseDatabase database = FirebaseDatabase.getInstance();
        private String userId= FirebaseAuth.getInstance().getCurrentUser().getUid();

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            // Retourne votre fichier layout
            // Changer R.layout.yourlayoutfilename pour vos fragments
            View v = inflater.inflate(R.layout.fragment_create_demande, container, false);

            modele = (Spinner) v.findViewById(R.id.modeleSpin);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.modele_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            modele.setAdapter(adapter);

            type = (Spinner) v.findViewById(R.id.typeSpin);
            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(), R.array.type_array, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            type.setAdapter(adapter2);

            title = (EditText) v.findViewById(R.id.title);
            detail = (EditText) v.findViewById(R.id.detail);
            modele = (Spinner) v.findViewById(R.id.modeleSpin);
            type = (Spinner) v.findViewById(R.id.typeSpin);

            validate = (Button) v.findViewById(R.id.button_add);
            btnBack = (Button) v.findViewById(R.id.btn_cancel);

            //Button valider
            validate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Insertion dans la base de données

                     Demande demande = new Demande(title.getText().toString(), Area.HDF, detail.getText().toString(), type.getSelectedItem().toString(), modele.getSelectedItem().toString(),"dfdf");
//                    ((MyApplication) getActivity().getApplication()).demands.add(d);


                    addDemande(demande);
                    Toast.makeText(getActivity(), "La demande a été créé et ajouté à vos demande", Toast.LENGTH_SHORT).show();

                    Fragment fragment = new MyDemandFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();

                }
            });

            //Button back
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment fragment = new ListDemandFragment();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            });

            return v;
        }

    @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Vous pouvez changer le titre dans la toolbar de vos differents fragments
        getActivity().setTitle("Créer une demande");
    }

    public void  addDemande(Demande demande){
        //Insertion dans la base de données
        DatabaseReference ref = database.getReference("demandes");
        String idDemande = ref.push().getKey();
        ref.child(idDemande).setValue(demande);

        //Map<String, Demande> demandes = new HashMap<String, Demande>();
        //demandes.put(idDemande,demande);

        //ref.setValue(demandes);
    }
}
