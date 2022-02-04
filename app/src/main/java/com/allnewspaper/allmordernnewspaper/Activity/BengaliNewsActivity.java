package com.allnewspaper.allmordernnewspaper.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.allnewspaper.allmordernnewspaper.Adapter.BengaliNewsTitleAdapter;
import com.allnewspaper.allmordernnewspaper.Model.BengaliNewsTitle;
import com.allnewspaper.allmordernnewspaper.Model.CategoriesTitle;
import com.allnewspaper.allmordernnewspaper.Model.RecyclerViewInterface;
import com.allnewspaper.allmordernnewspaper.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class BengaliNewsActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    AdView adView;
    BengaliNewsTitleAdapter adapter;
    int[] image={R.drawable.prothom,R.drawable.samakal,
            R.drawable.kalerkontoh,R.drawable.noyadigontoh,
            R.drawable.ittefaq, R.drawable.bdprotidin, R.drawable.jugantor,R.drawable.amadershomoy,
            R.drawable.manobkontoh,R.drawable.jaijaidin
               };
    String[] banglalink;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bengali_news);
        recyclerView=findViewById(R.id.recyclerview_bengali_news);
        banglalink=getResources().getStringArray(R.array.BanglaLink);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new BengaliNewsTitleAdapter(BengaliNewsActivity.this,image,this);

        recyclerView.setAdapter(adapter);
        addshow();

    }
    private void addshow() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView_bengali);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }


    @Override
    public void onItemClick(int position) {
                     Intent intent=new Intent();
                         switch (position)
                         {
                             case 0:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[0]);
                                  startActivity(intent);
                               break;
                             case 1:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[1]);
                                 startActivity(intent);
                                 break;
                             case 2:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[2]);
                                 startActivity(intent);
                                 break;
                             case 3:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[3]);
                                 startActivity(intent);
                                 break;
                             case 4:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[4]);
                                 startActivity(intent);
                                 break;
                             case 5:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[5]);
                                 startActivity(intent);
                                 break;
                             case 6:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[6]);
                                 startActivity(intent);
                                 break;
                             case 7:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[7]);
                                 startActivity(intent);
                                 break;
                             case 8:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[8]);
                                 startActivity(intent);
                                 break;
                             case 9:
                                 intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                                 intent.putExtra("Link",banglalink[9]);
                                 startActivity(intent);
                                 break;
                         }
        Toast.makeText(getApplicationContext(),"Loading...Please wait",Toast.LENGTH_SHORT).show();
    }
}
