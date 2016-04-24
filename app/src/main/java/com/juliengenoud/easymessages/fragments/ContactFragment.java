package com.juliengenoud.easymessages.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.juliengenoud.easymessages.MessagesActivity;
import com.juliengenoud.easymessages.R;
import com.juliengenoud.easymessages.adapters.Contact;
import com.juliengenoud.easymessages.adapters.ContactAdatper;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : juliengenoud
 * 17/04/16
 **/
public class ContactFragment  extends Fragment implements SearchView.OnQueryTextListener , ContactAdatper.OnItemClickListener{


    private RecyclerView mRecyclerView;
    private ContactAdatper mContactAdatperAdatper;

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }


    // protected BillsAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.setVisible(true);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setQueryHint(getString(R.string.search_hint_contacts));

        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contacts_fragment, container, false);

//        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        mContactAdatperAdatper = new ContactAdatper(this.getContext(), this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerView.setAdapter(mContactAdatperAdatper);
//        mRecyclerView.setLayoutManager(new RecyclerView.LayoutManager() {
//            @Override
//            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
//                RecyclerView.LayoutParams a;
//                a.
//                return a;
//            }
//        });

        List<Contact> contacts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            contacts.add(new Contact("Julien Genoud", String.valueOf(i)));
        }

        mContactAdatperAdatper.setContacts(contacts);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mContactAdatperAdatper.getFilter().filter(newText);
        return false;
    }

    @Override
    public void onItemClick(Contact item) {
        Toast.makeText(getContext(), item.getName() + " " + item.getDescription(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCallClick(Contact item) {
        startActivity(new Intent(getContext(), MessagesActivity.class));
    }
}