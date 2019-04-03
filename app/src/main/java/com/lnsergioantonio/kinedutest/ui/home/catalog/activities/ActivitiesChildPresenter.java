package com.lnsergioantonio.kinedutest.ui.home.catalog.activities;

import android.content.Context;

import com.lnsergioantonio.kinedutest.BuildConfig;
import com.lnsergioantonio.kinedutest.data.AppDataManager;
import com.lnsergioantonio.kinedutest.data.DataManager;
import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;
import com.lnsergioantonio.kinedutest.utils.AssetsPropertyReader;

import java.util.ArrayList;

public class ActivitiesChildPresenter implements ActivitiesChildMvp.Presenter, DataManager.ActivitiesIntractor.onFinishListener {
    private final AssetsPropertyReader propertyReader;
    private ActivitiesChildMvp.View view;
    private AppDataManager dataManager;

    public ActivitiesChildPresenter(ActivitiesChildMvp.View view, Context context) {
        this.view = view;
        this.propertyReader = new AssetsPropertyReader(context);
        dataManager = new AppDataManager(new AppPreferences(context),propertyReader);
        dataManager.setActivitiesIntractor(this);
    }

    @Override
    public void requestActivities() {
        view.showLoading();
        view.hideContent();
        dataManager.getActivities();
    }

    @Override
    public ArrayList<Activities> getListActivities() {
        return dataManager.getListActivities();
    }

    @Override
    public void onSuccess(ArrayList<Activities> activitiesArrayList) {
        dataManager.setListActivities(activitiesArrayList);
        view.setDataToRecyclerView(activitiesArrayList);
        view.hideLoading();
        view.showContent();
    }

    @Override
    public void onError(String error) {
        view.hideLoading();
        view.showError(error);
    }
}
