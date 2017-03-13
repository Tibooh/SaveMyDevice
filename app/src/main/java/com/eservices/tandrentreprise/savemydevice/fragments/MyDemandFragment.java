package com.eservices.tandrentreprise.savemydevice.fragments;

import com.eservices.tandrentreprise.savemydevice.MyApplication;
import com.eservices.tandrentreprise.savemydevice.R;
import com.eservices.tandrentreprise.savemydevice.adapters.DemandsAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**Fragment de la liste de mes demandes*/
public class MyDemandFragment extends Fragment {

    MyApplication app;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO : Affichage du fragment (1.1)
        View v = inflater.inflate(R.layout.fragment_mydemand, null);
        ListView list = (ListView) v.findViewById(R.id.list_item);

        app = (MyApplication) getActivity().getApplication();
        app.getMyDemands();

        list.setAdapter(new DemandsAdapter(getContext(), ((MyApplication) getActivity().getApplication()).myDemands));

        // TODO : Gestion du clique sur l'item (2.1)
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DetailDemandFragment fragment = new DetailDemandFragment();
                Bundle b = new Bundle();
                b.putSerializable("Demande", ((MyApplication) getActivity().getApplication()).myDemands.get(position));
                fragment.setArguments(b);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_frame, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return v;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Vous pouvez changer le titre dans la toolbar de vos differents fragments
        getActivity().setTitle("Mes demandes");
    }
}

