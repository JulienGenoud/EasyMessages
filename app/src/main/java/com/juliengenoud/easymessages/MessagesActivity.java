package com.juliengenoud.easymessages;

import android.app.ListActivity;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.juliengenoud.easymessages.db.Message;
import com.juliengenoud.easymessages.db.MessageDataSource;

import java.util.List;

/**
 * Author : juliengenoud
 * 24/04/16
 **/
public class MessagesActivity extends ListActivity {
    private MessageDataSource datasource;
    private TextView mMess;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        datasource = new MessageDataSource(this);
        try {
            datasource.open();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        List<Message> values = datasource.getAllMessages();

        mMess = (TextView) findViewById(R.id.new_mess);
        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Message> adapter = new ArrayAdapter<Message>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Message> adapter = (ArrayAdapter<Message>) getListAdapter();
        Message message = null;
        switch (view.getId()) {
            case R.id.add:
//                String[] messages = new String[] { "Cool", "Very nice", "Hate it" };
//                int nextInt = new Random().nextInt(3);
                // save the new message to the database

                if (!mMess.getText().toString().equals("")) {
                    message = datasource.createMessage(mMess.getText().toString());
                    adapter.add(message);
                    mMess.setText("");
                }
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    message = (Message) getListAdapter().getItem(getListAdapter().getCount() - 1);
                    datasource.deleteMessage(message);
                    adapter.remove(message);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        try {
            datasource.open();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}
