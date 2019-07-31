package com.techyouth.developer.techyouth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>  {
Context context;
List<QuestionModel> mQuestionList;

    public QuestionAdapter(Context context, List<QuestionModel> mQuestionList) {
        this.context = context;
        this.mQuestionList = mQuestionList;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View A= LayoutInflater.from(context).inflate(R.layout.questiondata,null);



        return new QuestionViewHolder(A);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder questionViewHolder, int i) {
        questionViewHolder.Question_data.setText(mQuestionList.get(i).getQuestion());
        questionViewHolder.User_Data.setText(mQuestionList.get(i).getTimeandDate()+""+mQuestionList.get(i).getUserName());
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    public  class QuestionViewHolder extends RecyclerView.ViewHolder{
      TextView Question_data;
      TextView User_Data;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            Question_data =(TextView)itemView.findViewById(R.id.questionMain);
            User_Data =(TextView)itemView.findViewById(R.id.NameTimedate);
        }
    }
}
