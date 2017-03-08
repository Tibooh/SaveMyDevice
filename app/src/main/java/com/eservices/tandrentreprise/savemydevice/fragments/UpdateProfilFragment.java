package com.eservices.tandrentreprise.savemydevice.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.activities.MainActivity;
import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by camrad on 02/02/2017.
 */

public class UpdateProfilFragment extends Fragment {

    private EditText inputPseudo,inputNomPrenom,inputAge,inputAdresse,inputVille,inputCodePostal;
    private Button btnUpdateProfil, btnCancel;
    MyApplication app;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_update_profil, null);

        app = (MyApplication) getActivity().getApplication();

        inputPseudo= (EditText) v.findViewById(R.id.pseudoUpdate);
        inputNomPrenom= (EditText) v.findViewById(R.id.nom_prenomUpdate);
        inputAge= (EditText) v.findViewById(R.id.ageUpdate);
        inputAdresse= (EditText) v.findViewById(R.id.adresseUpdate);
        inputVille = (EditText) v.findViewById(R.id.villeUpdate);
        inputCodePostal= (EditText) v.findViewById(R.id.code_postalUpdate);

        inputPseudo.setText(app.connectedUser.getPseudo());
        inputNomPrenom.setText(app.connectedUser.getNomPrenom());
        inputAge.setText(""+app.connectedUser.getAge());
        inputAdresse.setText(app.connectedUser.getAdresse());
        inputVille.setText(app.connectedUser.getVille());
        inputCodePostal.setText(app.connectedUser.getCodePostal());


        btnUpdateProfil = (Button) v.findViewById(R.id.button_valide_update);
        btnCancel = (Button) v.findViewById(R.id.btn_cancel_update);

        btnUpdateProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                app.connectedUser.setPseudo(inputPseudo.getText().toString());
                app.connectedUser.setAdresse(inputAdresse.getText().toString());
                app.connectedUser.setAge(Integer.parseInt(inputAge.getText().toString()));
                app.connectedUser.setCodePostal(inputCodePostal.getText().toString());
                app.connectedUser.setNomPrenom(inputNomPrenom.getText().toString());
                app.connectedUser.setRegion(Area.HDF);
                app.connectedUser.setVille(inputVille.getText().toString());
                Fragment fragment=new ProfilFragment();;
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new ProfilFragment();;
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
        getActivity().setTitle("Mon compte");
    }
    }
