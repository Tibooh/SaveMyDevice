package com.eservices.tandrentreprise.savemydevice.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
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
import com.eservices.tandrentreprise.savemydevice.activities.MainActivity;
import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.Candidature;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import static com.eservices.tandrentreprise.savemydevice.R.id.detail;
import static com.eservices.tandrentreprise.savemydevice.R.id.modele;
import static com.eservices.tandrentreprise.savemydevice.R.id.nav_connect;
import static com.eservices.tandrentreprise.savemydevice.R.id.peutBougerSpin;

/**
 * Created by camrad on 05/03/2017.
 */

public class PostulerFragment  extends Fragment{


    private EditText prix,commentaire;
    private Button btnPostuler,btnBack;
    Spinner peutBouger;
    //private ProgressBar progressBar;
    private FirebaseAuth auth;
    Demande demande;

    @Override
    public void setArguments(Bundle args) {
        this.demande = (Demande) args.getSerializable("Demande");
    }



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        // Retourne votre fichier layout
        // Changer R.layout.yourlayoutfilename pour vos fragments
        View v = inflater.inflate(R.layout.fragment_postuler, container, false);

        peutBouger = (Spinner) v.findViewById(R.id.peutBougerSpin);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.peutBouger_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        peutBouger.setAdapter(adapter);


        prix = (EditText) v.findViewById(R.id.prix);
        peutBouger = (Spinner) v.findViewById(R.id.peutBougerSpin);
        commentaire = (EditText) v.findViewById(R.id.commentaire);
        btnPostuler = (Button) v.findViewById(R.id.btn_postuler);
        btnBack = (Button) v.findViewById(R.id.btn_back);
        final Demande demandeActuelle =((MyApplication) getActivity().getApplication()).demandeActuelle;

        //Button valider
        btnPostuler.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Insertion dans la base de données
                boolean peutBougerBool;
                if ("Oui, je peux.".equals(peutBouger.getSelectedItem().toString()))
                {
                    peutBougerBool = true;
                }
                else peutBougerBool= false;

                postuler(demandeActuelle,prix.getText().toString(),peutBougerBool);
//                    ((MyApplication) getActivity().getApplication()).demands.add(d);
                Toast.makeText(getActivity(), "Votre proposition a bien été prise en compte", Toast.LENGTH_SHORT).show();

                DetailDemandFragment fragment = new DetailDemandFragment();
                Bundle b = new Bundle();
                b.putSerializable("Demande", demandeActuelle);
                fragment.setArguments(b);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();

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
        getActivity().setTitle("Candidature");
    }


    public void postuler(Demande demandeActuelle,String prix, boolean peutBouger){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        List<Candidature> candidatureList= demandeActuelle.getCandidatures();
        int idCandidature = 1;
        int prixDecimal=Integer.parseInt(prix);
        if (candidatureList != null){
            idCandidature = demandeActuelle.getCandidatures().size()+1;
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        Candidature candidature = new Candidature(idCandidature,currentUser.getDisplayName(),prixDecimal,peutBouger);

        demandeActuelle.getCandidatures().add(candidature);

        ref.child("demandes").child(demandeActuelle.getIdDemande()).child("candidatures").setValue(demandeActuelle.getCandidatures());
    }

    public User getConnectedUserByUId(String uid){
        String currentUser= FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = database.child("users").child(uid);
        //Query connectedUser = ref.equalTo(uid);
        final List<User> connectedUsers= new ArrayList<User>();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot item: dataSnapshot.getChildren()) {
                        User user= dataSnapshot.getValue(User.class);
                        connectedUsers.add(user);
                    }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
        return connectedUsers.get(0);
    }

}
