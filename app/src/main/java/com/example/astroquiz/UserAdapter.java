package com.example.astroquiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;



//custom useradapter to display all the users and their score from the database
public class UserAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    ArrayList<UserModal> userList;

    public UserAdapter(Context context, ArrayList<UserModal> userlist) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.userList = userlist;



    }
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.activity_custom_list_view,null);
        TextView UsernameView = view.findViewById(R.id.username_listview);
        TextView ScoreView = view.findViewById(R.id.score_listview);
        UsernameView.setText(userList.get(i).getUsername());
        ScoreView.setText("Top Score : "+userList.get(i).getScore());

        return view;
    }
}
