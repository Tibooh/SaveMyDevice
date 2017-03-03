package com.eservices.tandrentreprise.savemydevice.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.adapters.DemandsAdapter;
import com.eservices.tandrentreprise.savemydevice.model.Demande;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**Fragment de la liste des demandes*/
public class ListDemandFragment extends Fragment {

    private FirebaseAuth auth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO : Affichage du fragment (1.1)
        View v = inflater.inflate(R.layout.fragment_demand_list, null);
        ListView list = (ListView) v.findViewById(R.id.list_item);
        //((MyApplication) getActivity().getApplication()).getAllDemandes();
        ((MyApplication) getActivity().getApplication()).getAllDemandes();
        list.setAdapter(new DemandsAdapter(getContext(), ((MyApplication) getActivity().getApplication()).demands));

        // TODO : Gestion du clique sur l'item (2.1)
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailDemandFragment fragment = new DetailDemandFragment();
                Bundle b = new Bundle();
                b.putSerializable("Demande", ((MyApplication) getActivity().getApplication()).demands.get(position));
                fragment.setArguments(b);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
               }
        });

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new CreateDemandFragment();;
                if (fragment != null) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            }
        });

        //Cacher le bouton d'ajout si non connecté
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            v.findViewById(R.id.fab).setVisibility(View.VISIBLE);
        }else{
            v.findViewById(R.id.fab).setVisibility(View.INVISIBLE);
        }

        return v;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("");
    }

}

