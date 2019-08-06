package com.techyouth.developer.techyouth;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFrag extends Fragment {

    public List<QuestionModel> qm;
  public   EditText QuestionDailog,DiscriptionDal;
   public TextView QuestionCounter,DiscriptionCounter,PostQuestions;
   public   LoginServiceApi mAPIService;
    RecyclerView recyclerView;
    public QuestionFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rd =inflater.inflate(R.layout.fragment_question, container, false);
       recyclerView =(RecyclerView)rd.findViewById(R.id.questionRec);



            new DataFetcher().execute();
        //Toast.makeText(getContext(), ""+qm.get(4).getQuestion(), Toast.LENGTH_SHORT).show();



        FloatingActionButton fab = (FloatingActionButton)rd.findViewById(R.id.QuestionpostFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View QuestionDailogs= LayoutInflater.from(getContext()).inflate(R.layout.questiondailog,null);
                QuestionDailog=(EditText)QuestionDailogs.findViewById(R.id.questionMainDialog);
                DiscriptionDal=(EditText)QuestionDailogs.findViewById(R.id.DescriptionDialog);
                QuestionCounter=(TextView)QuestionDailogs.findViewById(R.id.wordCounter);
                DiscriptionCounter=(TextView)QuestionDailogs.findViewById(R.id.DiscriptionCounter);
                PostQuestions=(TextView)QuestionDailogs.findViewById(R.id.PostQuestion);
                QuestionDailog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if(count==129){

                            Toast.makeText(getContext(), "Text Limit Exceed !!!", Toast.LENGTH_SHORT).show();
                            QuestionDailog.setText("");
                        }
                        else  {
                            QuestionCounter.setText(""+"128/"+count);
                        }

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                DiscriptionDal.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                                 if(count==128){
                                     Toast.makeText(getContext(), "Text Limit Exceed !!!", Toast.LENGTH_SHORT).show();
                                     DiscriptionDal.setText("");

                                 }
                                 else {
                                     DiscriptionCounter.setText(""+"128/"+count);
                                 }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                AlertDialog.Builder as= new AlertDialog.Builder(getContext());
                AlertDialog asd= as.create();
                asd.setView(QuestionDailogs);
                asd.show();


            }
        });

        return rd;
    }
   class DataFetcher extends AsyncTask<Void,Void,Void> {
       ProgressDialog progressDialog;
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           qm = new ArrayList<>();
           progressDialog= new ProgressDialog(getContext());
           progressDialog.setTitle("Getting Question");
           progressDialog.show();
       }

       @Override
       protected void onPostExecute(Void aVoid) {
           super.onPostExecute(aVoid);
           progressDialog.dismiss();


       }

       @Override
       protected Void doInBackground(Void... voids) {
           mAPIService = ApiUtils.getLoginServiceApi();
           mAPIService.getQuestion("Show").enqueue(new Callback<List<ListPost>>() {

               @Override
              synchronized public void onResponse(Call<List<ListPost>> call, Response<List<ListPost>> response) {
                 //  qm.add(new QuestionModel("12","sdsd","ffdf","ssdsdsd"));
                   for(  int i=0 ; i<response.body().size();++i){


                       // Toast.makeText(getContext(), ""+response.body().get(i).getId(), Toast.LENGTH_SHORT).show();
                       Toast.makeText(getContext(), ""+response.body().size(), Toast.LENGTH_SHORT).show();
                       qm.add(new QuestionModel(""+response.body().get(i).getId(),""+response.body().get(i).getPost(),""+response.body().get(i).getTimeanddate(),""+response.body().get(i).getUsername()));
                       //Toast.makeText(getContext(), ""+qm.size(), Toast.LENGTH_SHORT).show();

                   }


                   QuestionAdapter qna = new QuestionAdapter(getContext(),qm);
                   LinearLayoutManager lm = new LinearLayoutManager(getContext());
                   DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                           lm.getOrientation());
                   recyclerView.addItemDecoration(dividerItemDecoration);
                   recyclerView.setLayoutManager(lm);
                   recyclerView.setAdapter(qna);
               }

               @Override
               public void onFailure(Call<List<ListPost>> call, Throwable t) {

               }
           });
           return null;
       }
   }

}

