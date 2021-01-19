package com.example.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Model.Post;
import com.example.Model.User;
import com.example.showuserdata.R;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> users;
    private ArrayList<Post> Posts;


    public void setPostList(ArrayList<Post> users1) {
        Posts = users1;
        Log.d("setUserList123","setPostList = " + Posts.size());
        notifyDataSetChanged();
    }


    public void setUserList(ArrayList<User> users1) {
        users = users1;
        Log.d("setUserList123","setUserList = " + users.size());
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_user, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User myListData = users.get(position);
        Log.d("setUserList123","getTitle = " + users.get(position).getName());
        Log.d("setUserList123","getTitle = " + users.get(position).getName());
        if(Posts.get(position).getId() == users.get(position).getId()) {
            holder.tvname.setText(users.get(position).getCompany().getName());
            holder.tvbody.setText("Body = " + Posts.get(position).getBody());
            holder.tvtitle.setText("Title = " +Posts.get(position).getTitle());
        }

    }



    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        } else {
            return 0;
        }
    }








    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvname , tvbody , tvtitle;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvname = (TextView) itemView.findViewById(R.id.tvname);
            this.tvbody = (TextView) itemView.findViewById(R.id.tvbody);
            this.tvtitle = (TextView) itemView.findViewById(R.id.tvtitle);
        }
    }
}
