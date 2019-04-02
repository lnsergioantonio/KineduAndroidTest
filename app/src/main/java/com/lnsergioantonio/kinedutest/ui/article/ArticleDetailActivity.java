package com.lnsergioantonio.kinedutest.ui.article;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lnsergioantonio.kinedutest.R;

public class ArticleDetailActivity extends AppCompatActivity implements ArticleMvp.View{
    private String KEY_ARTICLE_ID = "articleId";
    private ImageView imagePicture;
    private TextView labelTitle;
    private ImageButton btnShare;
    private WebView webViewBody;

    private ArticleMvp.Presenter presenter;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        presenter = new ArticlePresenter(this);
        bind();

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            int articleId= bundle.getInt(KEY_ARTICLE_ID);
            presenter.getArticle(articleId);
        }
    }

    private void bind() {
        imagePicture = findViewById(R.id.activity_article_picture);
        labelTitle = findViewById(R.id.activity_article_title);
        btnShare = findViewById(R.id.activity_article_button);
        webViewBody = findViewById(R.id.activity_article_webView);
        progressBar = findViewById(R.id.activity_article_progressBar);
    }

    @Override
    public void setPicture(String picture) {
        Glide.with(this)
                .load(picture)
                .centerCrop()
                .into(imagePicture);
    }

    @Override
    public void setTitle(String title) {
        labelTitle.setText(title);
    }

    @Override
    public void setBody(String body) {
        webViewBody.loadData(body,"text/html; charset=UTF-8", null);
    }

    @Override
    public void error(String error) {
        Toast.makeText(this,error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgresbar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideArticleDetail() {
        imagePicture.setVisibility(View.GONE);
        labelTitle.setVisibility(View.GONE);
        btnShare.setVisibility(View.GONE);
        webViewBody.setVisibility(View.GONE);
    }

    @Override
    public void showArticleDetail() {
        imagePicture.setVisibility(View.VISIBLE);
        labelTitle.setVisibility(View.VISIBLE);
        btnShare.setVisibility(View.VISIBLE);
        webViewBody.setVisibility(View.VISIBLE);
    }
}
