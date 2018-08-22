package ru.macdroid.newsreader;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

public class FeedAdapter extends RecyclerView.Adapter<FeedViewholder> {

    RssObject rssObject;
    Context context;
    LayoutInflater inflater;
    View itemView;
    String imgUrl;
    Intent intent;

    URL sourceUrl;

    String toolbarTitle;

    TextView splashSportsRu;
    private Typeface tf_light ,tf_bold, tf_semibold, tf_regular;

    public FeedAdapter(RssObject rssObject, Context context, LayoutInflater inflater) {
        this.rssObject = rssObject;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public FeedViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        itemView = inflater.inflate(R.layout.news_item, viewGroup, false);

        tf_light = Typeface.createFromAsset(itemView.getContext().getAssets(), "manrope-light.ttf");
        tf_bold = Typeface.createFromAsset(itemView.getContext().getAssets(), "manrope-bold.ttf");
        tf_semibold = Typeface.createFromAsset(itemView.getContext().getAssets(), "manrope-semibold.ttf");
        tf_regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "manrope-regular.ttf");

        return new FeedViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final FeedViewholder feedViewholder, final int i) {

        feedViewholder.tvTitle.setText(rssObject.getItems().get(i).getTitle().replaceAll("&amp;", " - "));
        feedViewholder.tvDescr.setText(rssObject.getItems().get(i).getDescription());
        feedViewholder.tvpubDate.setText(rssObject.getItems().get(i).getPubDate());

        feedViewholder.tvTitle.setTypeface(tf_bold);
        feedViewholder.tvDescr.setTypeface(tf_light);
        feedViewholder.tvpubDate.setTypeface(tf_light);

        Picasso.get().load(R.drawable.b).into(feedViewholder.ivThumbAdapter);

        feedViewholder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!isLongClick) {

                    intent = new Intent(itemView.getContext(), DetailWebView.class);
                    intent.putExtra("link", rssObject.getItems().get(i).getLink());
                    intent.putExtra("title", rssObject.getItems().get(i).getTitle().replaceAll("&amp;", " - "));
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rssObject.getItems().size();
    }
}
