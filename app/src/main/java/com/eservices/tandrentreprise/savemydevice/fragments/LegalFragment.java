package com.eservices.tandrentreprise.savemydevice.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eservices.tandrentreprise.savemydevice.R;

/**Fragment des mentions leglales de l'application*/
public class LegalFragment extends Fragment {


    private TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_legal, container, false);
        text = (TextView) v.findViewById(R.id.legaltext);

        text.setText("Le site est édité par la société Prodroid, SARL (société à responsabilité limitée) au capital social de 4.000 euros (RCS Nanterre B 753 594 027), domiciliée au 1 Place Paul Verlaine 92100 Boulogne-Billancourt. Numéro SIRET : 75359402700017.\n" +
                "\n" +
                "Directeur de publication et webmaster : Jean-Louis Dell’Oro. Nous contacter à cette adresse : lesapplicationsandroid@gmail.com\n" +
                "\n" +
                "Le site est hébergé par INFOMANIAK NETWORK SA, société anonyme (CH-660.0.059.996-1) domiciliée au 26, Avenue de la Praille 1227 Carouge / Genève Suisse, au capital social de 102.000 francs suisses.\n" +
                "\n" +
                "Le présent Site Web et l’ensemble de son contenu, y compris textes, images fixes ou animées, bases de données, programmes, etc., est protégé par le droit d’auteur. Pour en savoir plus à ce propos, veuillez lire nos conditions générales d’utilisation (CGU).\n" +
                "\n" +
                "Conformément à la loi n°78 – 17 du 6 janvier 1978 relative à l’informatique, aux fichiers et aux libertés, modifiée par la loi n°2004-801 du 6 août 2004, vous disposez à tout moment d’un droit d’accès, de rectification et de suppression des données personnelles vous concernant (formulaire, citation dans nos articles, photos). Si vous souhaitez exercer ce droit, il vous suffit de nous écrire au 1 Place Paul Verlaine 92100 Boulogne-Billancourt ou de nous contacter par mail : lesapplicationsandroid@gmail.com");

        return v;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Vous pouvez changer le titre dans la toolbar de vos differents fragments
        getActivity().setTitle("Mentions légales");
    }
}
