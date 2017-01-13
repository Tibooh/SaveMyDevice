package com.eservices.tandrentreprise.savemydevice.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.model.Demande;


/**Fragment de la messagerie de l'applciation*/
public class DetailDemandFragment extends Fragment {
    private Demande demande;

    @Override
    public void setArguments(Bundle args) {
        this.demande = (Demande) args.getSerializable("demande");
    }

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_detail_demande, container, false);
        }


        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // Vous pouvez changer le titre dans la toolbar de vos differents fragments
            getActivity().setTitle("Détail de la demande");
        }
}
