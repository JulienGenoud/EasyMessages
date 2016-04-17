package com.juliengenoud.easymessages.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.juliengenoud.easymessages.R;

/**
 * Author : juliengenoud
 * 17/04/16
 **/
public class ContactFragment  extends Fragment implements SearchView.OnQueryTextListener {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
//    private ContactAdatper mBookMe5BuisnessAdatper;

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
        //setUpGrid((RecyclerView) view.findViewById(R.id.mounth_recycler));
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // mAdapter.getFilter().filter(newText);
        return false;
    }
}