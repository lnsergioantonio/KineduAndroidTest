package com.lnsergioantonio.kinedutest.ui.home.catalog.activities;

import android.content.Context;

import com.lnsergioantonio.kinedutest.data.AppDataManager;
import com.lnsergioantonio.kinedutest.data.DataManager;
import com.lnsergioantonio.kinedutest.data.api.activities.Activities;
import com.lnsergioantonio.kinedutest.data.preferences.AppPreferences;

import java.util.ArrayList;

public class ActivitiesChildPresenter implements ActivitiesChildMvp.Presenter, DataManager.ActivitiesIntractor.onFinishListener {
    private ActivitiesChildMvp.View view;
    private AppDataManager dataManager;

    public ActivitiesChildPresenter(ActivitiesChildMvp.View view, Context context) {
        this.view = view;
        dataManager = new AppDataManager(new AppPreferences(context));
        dataManager.setActivitiesIntractor(this);
    }

    @Override
    public void requestActivities() {
        dataManager.getActivities(dataManager.getToken(),5,2064732);
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
    }

    @Override
    public void onError(String error) {
        view.hideLoading();
        view.showError(error);
    }
}
