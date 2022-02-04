package com.allnewspaper.allmordernnewspaper.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.allnewspaper.allmordernnewspaper.Adapter.CategoriesTitleAdapter;
import com.allnewspaper.allmordernnewspaper.Model.CategoriesTitle;
import com.allnewspaper.allmordernnewspaper.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class HomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CategoriesTitleAdapter adapter;
    AdView adView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.recyclerview_home_categories);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        ArrayList<CategoriesTitle> homeCategoriesTitles=new ArrayList<>();
        homeCategoriesTitles.add(new CategoriesTitle(R.drawable.newspaper,"Bengali"));
        homeCategoriesTitles.add(new CategoriesTitle(R.drawable.newspaper,"English"));
        homeCategoriesTitles.add(new CategoriesTitle(R.drawable.newspaper,"International"));
        homeCategoriesTitles.add(new CategoriesTitle(R.drawable.newspaper,"Online"));

        adapter=new CategoriesTitleAdapter(homeCategoriesTitles);

        recyclerView.setAdapter(adapter);
        adaptarItemClickListener();
        addshow();
    }

    private void addshow() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView_home);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }


    private void adaptarItemClickListener() {
        adapter.setOnItemClickListener(new CategoriesTitleAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Context context=view.getContext();

                switch (position){
                    case 0:
                        iniAdd();
                        showadd();
                        Intent intent=new Intent(getApplicationContext(),BengaliNewsActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        iniAdd();
                        showadd();
                        Intent intent2=new Intent(getApplicationContext(),EnglishNewsActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        iniAdd();
                        showadd();
                        Intent intent3=new Intent(getApplicationContext(),InterNationalNewsActivity.class);
                        startActivity(intent3);
                        break;
                    case 3:
                        iniAdd();
                        showadd();
                        Intent intent4=new Intent(getApplicationContext(),OnlineNewsActivity.class);
                        startActivity(intent4);
                        break;


                }
            }



            private void iniAdd() {
                MobileAds.initialize(getApplicationContext(), new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {}
                });
                AdRequest adRequest = new AdRequest.Builder().build();

                InterstitialAd.load(getApplicationContext(),"ca-app-pub-3940256099942544/1033173712", adRequest,
                        new InterstitialAdLoadCallback() {
                            @Override
                            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                                mInterstitialAd = interstitialAd;
                                Log.i(TAG, "onAdLoaded");
                            }

                            @Override
                            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {

                                Log.i(TAG, loadAdError.getMessage());
                                mInterstitialAd = null;
                            }
                        });

            }
            private void showadd() {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(HomeActivity.this);
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.");
                }

            }


        });
    }


}
