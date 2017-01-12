package com.eservices.tandrentreprise.savemydevice.fragments;

import com.eservices.tandrentreprise.savemydevice.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**Fragment de la messagerie de l'applciation*/
public class MessagesFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Retourne votre fichier layout
            // Changer R.layout.yourlayoutfilename pour vos fragments
            return inflater.inflate(R.layout.fragment_messages, container, false);
        }


        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            // Vous pouvez changer le titre dans la toolbar de vos differents fragments
            getActivity().setTitle("Messages");
        }
}
