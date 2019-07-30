package com.techyouth.developer.techyouth;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InterestAdapter  extends  RecyclerView.Adapter<InterestAdapter.InterestView>{

    private List<Model> mModelList;

    public InterestAdapter(List<Model> mModelList) {
        this.mModelList = mModelList;
    }

    @NonNull
    @Override
    public InterestView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View d=inflater.inflate(R.layout.interest,viewGroup,false);
        InterestView interestView = new InterestView(d);
        return interestView;
    }

    @Override
    public void onBindViewHolder(@NonNull final InterestView interestView, final int i) {
TextView rt= interestView.ted;
        final Model model = mModelList.get(i);
rt.setText(mModelList.get(i).getInterset_Area());
interestView.allcard.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        model.setSelected(!model.isSelected());
        interestView.view.setBackgroundColor(model.isSelected() ? Color.GREEN : Color.WHITE);
    }
});

    }

    @Override
    public int getItemCount() {
        return mModelList == null ? 0 : mModelList.size();
    }


    class InterestView extends RecyclerView.ViewHolder{
        TextView ted;
        CardView allcard;

         View view;

        public InterestView(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            ted=(TextView)itemView.findViewById(R.id.datainter);
            allcard=(CardView)itemView.findViewById(R.id.allcard);

        }
    }

}
