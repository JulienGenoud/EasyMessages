package com.juliengenoud.easymessages.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.juliengenoud.easymessages.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author : juliengenoud
 * 21/04/16
 **/
public class ContactAdatper extends RecyclerView.Adapter<ContactAdatper.ViewHolder>  implements Filterable {

    private Context mContext;
    private List<Contact> mContacts;
    private List<Contact> mCopyContact = new ArrayList<>();

    private final OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Contact item);
    }

    public ContactAdatper(final Context context, OnItemClickListener listener) {
        this(context, new ArrayList<Contact>(), listener);
    }

    public ContactAdatper(final Context context, final List<Contact> contacts, OnItemClickListener listener) {
        mContext = context;
        mContacts = contacts;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cat_fact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Contact biz = mContacts.get(position);
        holder.mTextCatFact.setText(biz.getName());
        holder.mTextType.setText(biz.getDescription());

//        Picasso.with(mContext)
//                .load(biz.getFirstImage())
//                .into(holder.mImageCat);
        holder.bind(biz, listener);
    }


    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public void setContacts(List<Contact> Businessess) {
        mContacts = Businessess;
        mCopyContact = Businessess;
        notifyDataSetChanged();
    }

    public void updateContacts(List<Contact> Businessess) {
        mContacts = Businessess;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //    @Bind(R.id.image_cat)
//    ImageView mImageCat;
        @Bind(R.id.text_cat_fact)
        TextView mTextCatFact;
        @Bind(R.id.text_type)
        TextView mTextType;

        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Contact item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return new ContactFilter(this, mCopyContact);
    }

    private static class ContactFilter extends Filter {

        private final ContactAdatper adapter;

        private final List<Contact> originalList;
        private final List<Contact> filteredList;

        private ContactFilter(ContactAdatper adapter, List<Contact> originalList) {
            super();
            this.adapter = adapter;
            this.originalList = new LinkedList<>(originalList);
            this.filteredList = new ArrayList<>();
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredList.clear();
            final FilterResults results = new FilterResults();

            if (constraint.length() == 0) {
                filteredList.addAll(originalList);
            } else {
                final String filterPattern = constraint.toString().toLowerCase().trim();

                for (final Contact contact : originalList) {
                    if (contact.getDescription().toLowerCase().contains(filterPattern)) {
                        filteredList.add(contact);
                    }
                }
            }
            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.mContacts.clear();
            adapter.mCopyContact = originalList;
            adapter.mContacts.addAll((ArrayList<Contact>) results.values);
            adapter.notifyDataSetChanged();
        }
    }
}