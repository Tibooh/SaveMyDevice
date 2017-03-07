package com.eservices.tandrentreprise.savemydevice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;


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

    MyApplication app;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profil, null);

        app = (MyApplication) getActivity().getApplication();

        // TODO : Affichage des infos (3.1)
        pseudo = (TextView) v.findViewById(R.id.tv_pseudo);
        nom = (TextView) v.findViewById(R.id.tv_nom);
        prenom = (TextView) v.findViewById(R.id.tv_prenom);
        region = (TextView) v.findViewById(R.id.tv_area);
        age = (TextView) v.findViewById(R.id.tv_age);
        adresse = (TextView) v.findViewById(R.id.tv_adresse);
        codePostal = (TextView) v.findViewById(R.id.tv_codePostal);
        ville = (TextView) v.findViewById(R.id.tv_ville);
        nbIntervention = (TextView) v.findViewById(R.id.tv_intervention);
        nbAnnonces = (TextView) v.findViewById(R.id.tv_annonce);
        gainTotal = (TextView) v.findViewById(R.id.tv_gain);

        pseudo.setText(app.connectedUser.getPseudo());
        nom.setText(app.connectedUser.getNomPrenom());
        prenom.setText(app.connectedUser.getNomPrenom());
        region.setText(app.connectedUser.getRegion());
        age.setText(""+app.connectedUser.getAge());
        adresse.setText(app.connectedUser.getAdresse());
        codePostal.setText(app.connectedUser.getCodePostal());
        ville.setText(app.connectedUser.getVille());
        nbIntervention.setText(""+app.connectedUser.getNbIntervention());
        nbAnnonces.setText(""+app.connectedUser.getNbAnnonces());
        gainTotal.setText(""+app.connectedUser.getGainTotal());


        ImageView img = (ImageView) v.findViewById(R.id.account_update);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment fragment = new ProfilFragment();
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
        getActivity().setTitle("Mon compte");
    }

}
