package com.lnsergioantonio.kinedutest.ui.home.catalog.articles;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lnsergioantonio.kinedutest.R;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;
import com.lnsergioantonio.kinedutest.ui.article.ArticleDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CellArticlesRecyclerViewAdapter extends RecyclerView.Adapter<CellArticlesRecyclerViewAdapter.CellArticlesViewHolder> {

    private Context context;
    private List<Articles> articlesList;

    public CellArticlesRecyclerViewAdapter(Context context, List<Articles> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public CellArticlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.cell_fragment_articles,parent,false);
        CellArticlesViewHolder articlesViewHolder = new CellArticlesViewHolder(view);
        return articlesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CellArticlesViewHolder holder, int position) {
        holder.bind(articlesList.get(position));
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public static class CellArticlesViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageArticle;
        private TextView labelName;
        private TextView labelDescription;
        private String KEY_ARTICLE_ID = "articleId";

        public CellArticlesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageArticle = itemView.findViewById(R.id.cell_fragment_articles_imageview);
            labelName = itemView.findViewById(R.id.cell_fragment_articles_name);
            labelDescription = itemView.findViewById(R.id.cell_fragment_articles_description);
        }

        public void bind(final Articles article){
            labelName.setText(article.getName());
            labelDescription.setText(article.getShort_description());
            Glide.with(itemView.getContext())
                    .load(article.getPicture())
                    .centerCrop()
                    .into(imageArticle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(),ArticleDetailActivity.class);
                    intent.putExtra(KEY_ARTICLE_ID,article.getId());
                    itemView.getContext().startActivity(intent);
                }
            });
        }

    }
}
