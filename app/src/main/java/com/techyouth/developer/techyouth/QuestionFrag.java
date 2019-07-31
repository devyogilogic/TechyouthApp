package com.techyouth.developer.techyouth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFrag extends Fragment {

    public List<QuestionModel> qm;
    public QuestionFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rd =inflater.inflate(R.layout.fragment_question, container, false);
        RecyclerView recyclerView =(RecyclerView)rd.findViewById(R.id.questionRec);
        qm = new ArrayList<>();
      qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;
        qm.add(new QuestionModel("1","What is python","27/12/13 12:00pm","yogesh")) ;

        QuestionAdapter qna = new QuestionAdapter(getContext(),qm);
         LinearLayoutManager lm = new LinearLayoutManager(getContext());
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
            lm.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(qna);



        return rd;
    }

}
