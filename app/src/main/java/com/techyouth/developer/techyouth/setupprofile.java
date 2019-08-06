package com.techyouth.developer.techyouth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class setupprofile extends Fragment {
    private List<Model> mModelList;

    public setupprofile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LoginServiceApi mAPIService;


        mAPIService = ApiUtils.getLoginServiceApi();
final View idk=inflater.inflate(R.layout.fragment_setupprofile, container, false);
        mModelList = new ArrayList<>();
        final RecyclerView rec=(RecyclerView)idk.findViewById(R.id.loadInter);
       mAPIService.getInterest("show").enqueue(new Callback<List<Interest>>() {

            @Override
            synchronized   public void onResponse(Call<List<Interest>> call, Response<List<Interest>> response) {


                for(  int i=0 ; i<response.body().size();++i){

                     mModelList.add(new Model(""+response.body().get(i).getInterestArea(),""+response.body().get(i).getId()));


                }

                InterestAdapter idp= new InterestAdapter(mModelList);
                rec.setAdapter(idp);
                rec.setLayoutManager(new GridLayoutManager(getContext(),2));



            }




            @Override
            public void onFailure(Call<List<Interest>> call, Throwable t) {

            }
        });




        return idk;  }

}
