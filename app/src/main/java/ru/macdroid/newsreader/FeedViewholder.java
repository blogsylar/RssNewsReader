package ru.macdroid.newsreader;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FeedViewholder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    TextView tvTitle, tvDescr, tvpubDate;
    ItemClickListener itemClickListener;
    ImageView ivThumbAdapter;

    public FeedViewholder(@NonNull View itemView) {
        super(itemView);

        tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        tvDescr = (TextView) itemView.findViewById(R.id.tvDescr);
        tvpubDate = (TextView) itemView.findViewById(R.id.tvpubDate);
        ivThumbAdapter = (ImageView)itemView.findViewById(R.id.ivThumbAdapter);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view, getAdapterPosition(), false);

    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}
