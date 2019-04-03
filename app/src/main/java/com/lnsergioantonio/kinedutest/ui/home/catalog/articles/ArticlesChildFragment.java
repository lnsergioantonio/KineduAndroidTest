package com.lnsergioantonio.kinedutest.ui.home.catalog.articles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lnsergioantonio.kinedutest.R;
import com.lnsergioantonio.kinedutest.data.api.articles.Articles;
import com.lnsergioantonio.kinedutest.ui.home.catalog.activities.ActivitiesChildMvp;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class ArticlesChildFragment extends Fragment implements ArticlesChildMvp.View {
    private static final String ARGUMENT_POSITION = "argument_position";
    private RecyclerView articlesRecyclerView;
    private ProgressBar progressBar;
    private ArticlesChildMvp.Presenter presenter;
    private CellArticlesRecyclerViewAdapter adapter;
    private NestedScrollView layoutContent;
    public static ArticlesChildFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION,position);
        ArticlesChildFragment fragment = new ArticlesChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ArticlesChildPresenter(this,getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog_articles,container,false);
        articlesRecyclerView = view.findViewById(R.id.fragment_catalog_articles_recyclerview);
        layoutContent = view.findViewById(R.id.fragment_catalog_articles_content);

        progressBar = view.findViewById(R.id.fragment_catalog_articles_progressBar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = getArguments().getInt(ARGUMENT_POSITION,-1);
        presenter.requestArticles();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showContent() {
        layoutContent.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideContent() {
        layoutContent.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<Articles> articlesList) {
        adapter = new CellArticlesRecyclerViewAdapter(getContext(),articlesList);
        articlesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();
    }
}
