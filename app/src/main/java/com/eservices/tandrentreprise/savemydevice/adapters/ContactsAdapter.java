package com.eservices.tandrentreprise.savemydevice.adapters;

import android.content.Context;
import com.eservices.tandrentreprise.savemydevice.Contact;
import com.eservices.tandrentreprise.savemydevice.R;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by stamper on 06/10/16.
 */

public class ContactsAdapter extends ArrayAdapter<Contact> {

    public ContactsAdapter(Context context, List<Contact> contacts) {
        super(context, R.layout.item_list, contacts);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View content = inflater.inflate(R.layout.item_list, null);

        TextView name = (TextView) content.findViewById(R.id.name);
        Contact cur = getItem(position);
        name.setText(cur.firstName + " " + cur.lastName);

        return content;
    }
}
