package com.example.rxjavawithrecyclerview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SimpleStringAdapter mSimpleStringAdapter;

    // Sample 2
    private Subscription mCatShowSubscription;
    private ProgressBar mProgressBar;
    private RestClient mRestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample 2
        mRestClient = new RestClient(this);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarLoader);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSimpleStringAdapter = new SimpleStringAdapter(this);
        mRecyclerView.setAdapter(mSimpleStringAdapter);

    }



    private void displayCatNames(List<String> names) {
        mSimpleStringAdapter.setStrings(names);
        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mCatShowSubscription != null && !mCatShowSubscription.isUnsubscribed()) {
            mCatShowSubscription.unsubscribe();
        }
    }
}
