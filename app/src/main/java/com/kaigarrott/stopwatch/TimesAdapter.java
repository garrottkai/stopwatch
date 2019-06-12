package com.kaigarrott.stopwatch;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaigarrott.stopwatch.data.TimeEntry;

import java.util.List;

public class TimesAdapter extends RecyclerView.Adapter<TimesAdapter.TimeViewHolder> {

    private List<TimeEntry> mDataSet;
    private Context mContext;

    public TimesAdapter(Context context) {
        mContext = context;
    }

    class TimeViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public TimeViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.times_textview);
        }
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.times_view, viewGroup, false);
        return new TimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder viewHolder, int position) {
        viewHolder.textView.setText(Utils.format(mDataSet.get(position).getValue()));
    }

    public void setData(List<TimeEntry> timeEntries) {
        mDataSet = timeEntries;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }
}
