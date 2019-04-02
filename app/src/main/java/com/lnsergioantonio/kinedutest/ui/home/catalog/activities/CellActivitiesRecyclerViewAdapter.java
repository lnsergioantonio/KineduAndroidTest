package com.lnsergioantonio.kinedutest.ui.home.catalog.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lnsergioantonio.kinedutest.R;
import com.lnsergioantonio.kinedutest.data.api.activities.Activities;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CellActivitiesRecyclerViewAdapter extends RecyclerView.Adapter<CellActivitiesRecyclerViewAdapter.CellActivitiesViewHolder> implements Filterable {

    private Context context;
    private ArrayList<Activities> activitiesList;
    private ArrayList<Activities> filterActivitiesList;
    public CellActivitiesRecyclerViewAdapter(Context context, ArrayList<Activities> activitiesList) {
        this.context = context;
        this.activitiesList = activitiesList;
        this.filterActivitiesList = activitiesList;
    }

    @NonNull
    @Override
    public CellActivitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.cell_fragment_activities,parent,false);
        CellActivitiesViewHolder activitiesViewHolder = new CellActivitiesViewHolder(view);
        return activitiesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CellActivitiesViewHolder holder, int position) {
        Activities activity = filterActivitiesList.get(position);
        Glide.with(context)
                .load(activity.getThumbnail())
                .centerCrop()
                .into(holder.imageActivity);
        holder.labelNameActivity.setText(activity.getName());
        holder.labelPurpose.setText(activity.getPurpose());
        holder.ratingMilestone.setNumStars(activity.getActive_milestones());
    }

    @Override
    public int getItemCount() {
        return filterActivitiesList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()){
                    filterActivitiesList.addAll(activitiesList);
                }else{
                    ArrayList<Activities> filtredActivities= new ArrayList<>();
                    for(Activities activity: activitiesList ){
                        if(activity.getAge_group().equals(charString))
                            filtredActivities.add(activity);
                    }
                    filterActivitiesList = filtredActivities;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterActivitiesList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filterActivitiesList = (ArrayList<Activities>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    // holder
    public static class CellActivitiesViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageActivity;
        private TextView labelNameActivity;
        private TextView labelPurpose;
        private RatingBar ratingMilestone;
        public CellActivitiesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageActivity = itemView.findViewById(R.id.cell_fragment_activities_imageview);
            labelNameActivity = itemView.findViewById(R.id.cell_fragment_activities_name);
            labelPurpose = itemView.findViewById(R.id.cell_fragment_activity_purpose);
            ratingMilestone = itemView.findViewById(R.id.cell_fragment_activities_ratingBar);
        }
    }
}
