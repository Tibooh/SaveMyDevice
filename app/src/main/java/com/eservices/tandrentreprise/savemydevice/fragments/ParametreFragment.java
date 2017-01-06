package com.eservices.tandrentreprise.savemydevice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eservices.tandrentreprise.savemydevice.R;

/**Fragment des parametres*/
public class ParametreFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Retourne votre fichier layout
        // Changer R.layout.yourlayoutfilename pour vos fragments
        return inflater.inflate(R.layout.fragment_parametre, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Vous pouvez changer le titre dans la toolbar de vos differents fragments
        getActivity().setTitle("Paramètres");
    }
}
