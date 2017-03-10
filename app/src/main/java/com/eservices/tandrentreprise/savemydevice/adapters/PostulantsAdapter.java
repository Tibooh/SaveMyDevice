package com.eservices.tandrentreprise.savemydevice.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.model.Candidature;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.handle;

/**
 * Adapter de la liste des postulants
 */
public class PostulantsAdapter extends ArrayAdapter<Candidature> {

    Context context;

    private MyApplication app;


    public PostulantsAdapter(Context context, List<Candidature> postulants) {
        super(context, R.layout.postulant_list, postulants);
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.postulant_list, null);


        app = (MyApplication) context.getApplicationContext();

        TextView name = (TextView) content.findViewById(R.id.name);
        TextView tarif = (TextView) content.findViewById(R.id.tarif);
        ImageButton btnPostulant = (ImageButton)  content.findViewById(R.id.btnPostulant) ;
        ImageView canMove = (ImageView) content.findViewById(R.id.iconcar) ;
        ;

        final Candidature cur = getItem(position);

        if (cur.peutBouger==true){
            canMove.setVisibility(View.VISIBLE);
        }else{
            canMove.setVisibility(View.INVISIBLE);
        }

        if(app.auth.getCurrentUser()!=null) {
            if (!app.demandeActuelle.getIdUser().equals(app.auth.getCurrentUser().getUid())) {
                btnPostulant.setVisibility(View.INVISIBLE);
            }
        }else{
            btnPostulant.setVisibility(View.INVISIBLE);
        }

        name.setText(cur.nomPostulant);
        tarif.setText("Tarif : "+cur.prixPropose);
        btnPostulant.setBackgroundResource(R.drawable.ic_validate);

        btnPostulant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCandidatureFinale(cur);
            }
        });
        return content;
    }
    public void setCandidatureFinale(Candidature candidatureFinale)
    {
        Demande demande = ((MyApplication) context.getApplicationContext()).demandeActuelle;
        demande.setCandidatureFinale(candidatureFinale);

        //recuperer le createur de la candidature pour la MAJ
        List<User> users=getCreatorOfCandidature(candidatureFinale.getUserId());
        User user=getCreateurDeLaDemande();
        user.setNbIntervention(user.getNbIntervention()+1);
        user.setGainTotal(user.getGainTotal()+candidatureFinale.getPrixPropose());
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = database.child("users").child(candidatureFinale.getUserId());
        ref.setValue(user);

        Toast.makeText((Activity) context, "La candidature a été acceptée", Toast.LENGTH_SHORT).show();
    }


}
