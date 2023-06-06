package com.example.recyclerusingvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter <PostAdapter.ViewHolder>{

List<PostModel> postList;
    public PostAdapter(Context context, List<PostModel> postList){
        this.postList=postList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.userId.setText(Integer.toString(postList.get(position).getUserId()));
        holder.title.setText(postList.get(position).getTitle());
        holder.postdesc.setText(postList.get(position).getPostDesc());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userId,title,postdesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userId=itemView.findViewById(R.id.userId);
            title=itemView.findViewById(R.id.postTitle);
            postdesc=itemView.findViewById(R.id.postDesc);
        }
    }
}
