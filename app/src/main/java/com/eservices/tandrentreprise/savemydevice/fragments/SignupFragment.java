package com.eservices.tandrentreprise.savemydevice.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.activities.MainActivity;
import com.eservices.tandrentreprise.savemydevice.model.Area;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.eservices.tandrentreprise.savemydevice.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static android.R.id.input;

/**
 * Created by camrad on 02/02/2017.
 */

public class SignupFragment extends Fragment {

    private EditText inputEmail, inputPassword,inputPseudo,inputNomPrenom,inputAge,inputAdresse,inputVille,inputCodePostal;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    //private ProgressBar progressBar;
    private FirebaseAuth auth;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, null);


        auth = FirebaseAuth.getInstance();

        inputPseudo= (EditText) v.findViewById(R.id.pseudo);
        inputNomPrenom= (EditText) v.findViewById(R.id.nom_prenom);
        inputAge= (EditText) v.findViewById(R.id.age);
        inputAdresse= (EditText) v.findViewById(R.id.adresse);
        inputVille = (EditText) v.findViewById(R.id.ville);
        inputCodePostal= (EditText) v.findViewById(R.id.code_postal);


        btnSignIn = (Button) v.findViewById(R.id.sign_in_button);
        btnSignUp = (Button) v.findViewById(R.id.sign_up_button);
        inputEmail = (EditText) v.findViewById(R.id.email);
        inputPassword = (EditText) v.findViewById(R.id.password);
        //progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        btnResetPassword = (Button) v.findViewById(R.id.btn_reset_password);



        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Fragment fragment=new LoginFragment();;
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getActivity(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getActivity(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(getActivity(), "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                //progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();

                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(inputPseudo.getText().toString())
                                            .build();

                                    currentUser.updateProfile(profileUpdates)
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) {
                                                        Toast.makeText(getActivity(), "Pseudo ajouté" + task.getException(),
                                                                Toast.LENGTH_SHORT).show(); }
                                                }
                                            });

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                                    //Insertion dans la base de new user
                                    DatabaseReference ref = database.getReference("users");

                                    User connectedUser = new User(currentUser.getUid() , inputPseudo.getText().toString(), inputNomPrenom.getText().toString(), "", Integer.parseInt(inputAge.getText().toString()), inputAdresse.getText().toString(),inputCodePostal.getText().toString(), inputVille.getText().toString());

                                    ref.child(currentUser.getUid()).setValue(connectedUser);

                                    Intent intent = new Intent(getActivity(), MainActivity.class);
                                    getActivity().startActivity(intent);
                                }
                            }
                        });

            }
        });
        return v;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("");
    }
    }
