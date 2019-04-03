package com.lnsergioantonio.kinedutest.ui.home.catalog.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lnsergioantonio.kinedutest.R;
import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;

import java.util.ArrayList;
import java.util.Iterator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class ActivitiesChildFragment extends Fragment implements ActivitiesChildMvp.View {
    private static final String ARGUMENT_POSITION = "argument_position";
    private RecyclerView activitiesRecyclerView;
    private CellActivitiesRecyclerViewAdapter adapter;
    private ProgressBar progressBar;
    private ActivitiesChildMvp.Presenter presenter;
    private NestedScrollView layoutContent;
    public static ActivitiesChildFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        ActivitiesChildFragment fragment = new ActivitiesChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ActivitiesChildPresenter(this,getContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog_activities, container, false);
        activitiesRecyclerView = view.findViewById(R.id.fragment_catalog_activities_recyclerview);
        layoutContent = view.findViewById(R.id.fragment_catalog_activities_content);

        progressBar = view.findViewById(R.id.fragment_catalog_activities_progressBar);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int position = getArguments().getInt(ARGUMENT_POSITION, -1);
        presenter.requestActivities();
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
    public void setDataToRecyclerView(ArrayList<Activities> activitiesList) {
        adapter = new CellActivitiesRecyclerViewAdapter(getContext(), activitiesList);
        activitiesRecyclerView.setAdapter(adapter);
    }

    @Override
    public void updateAdapterActivities(String month) {
        adapter.getFilter().filter(month);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_LONG).show();
    }
}
