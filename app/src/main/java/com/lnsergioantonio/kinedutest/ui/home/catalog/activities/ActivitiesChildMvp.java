package com.lnsergioantonio.kinedutest.ui.home.catalog.activities;

import com.lnsergioantonio.kinedutest.data.api.activities.Activities;

import java.util.ArrayList;
import java.util.List;

public interface ActivitiesChildMvp {
    interface View{
        void showLoading();
        void hideLoading();
        void showContent();
        void hideContent();
        void setDataToRecyclerView(ArrayList<Activities> activitiesList);
        void updateAdapterActivities(String month);
        void showError(String error);
    }

    interface Presenter{
        void requestActivities();
        ArrayList<Activities> getListActivities();
    }
}
