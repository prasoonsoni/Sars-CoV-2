package com.prasoonsoni.sars_cov2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StateListAdapter extends ArrayAdapter <StateModel>{
    private Context context;
    private List<StateModel> stateModelList;


    public StateListAdapter(Context context, List<StateModel> stateModelList) {
        super(context, R.layout.state_list_custom_layout, stateModelList);
        this.context = context;
        this.stateModelList = stateModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.state_list_custom_layout, null, true);
        TextView stateName = view.findViewById(R.id.stateName);
        TextView stateActive = view.findViewById(R.id.stateActive);
        TextView stateDeath = view.findViewById(R.id.stateDeath);
        TextView stateRecovered = view.findViewById(R.id.stateRecovered);
        TextView stateConfirmed = view.findViewById(R.id.stateConfirmed);
        TextView stateLastUpdate = view.findViewById(R.id.stateLastUpdate);

        stateName.setText(stateModelList.get(position).getState());
        stateActive.setText(stateModelList.get(position).getActive());
        stateDeath.setText(stateModelList.get(position).getDeath());
        stateRecovered.setText(stateModelList.get(position).getRecovered());
        stateConfirmed.setText(stateModelList.get(position).getConfirmed());
        stateLastUpdate.setText("Last updated on " + stateModelList.get(position).getLastUpdated());

        return view;
    }
}
