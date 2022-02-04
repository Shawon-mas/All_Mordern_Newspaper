package com.allnewspaper.allmordernnewspaper.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.allnewspaper.allmordernnewspaper.Adapter.BengaliNewsTitleAdapter;
import com.allnewspaper.allmordernnewspaper.Model.RecyclerViewInterface;
import com.allnewspaper.allmordernnewspaper.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class EnglishNewsActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    BengaliNewsTitleAdapter adapter;
    AdView adView;
    int[] image={R.drawable.ic_dailystar,R.drawable.bdnews24,
            R.drawable.thenfinancial, R.drawable.thenewnation,R.drawable.dailysun,
            R.drawable.ic_dhakatribune,R.drawable.dailyobserver,R.drawable.theindependent,
            R.drawable.newage,R.drawable.thebangladeshtoday
    };
    String[] englshlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_news);
        recyclerView=findViewById(R.id.recyclerview_enlish_news);
        englshlink=getResources().getStringArray(R.array.EnglishLink);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new BengaliNewsTitleAdapter(EnglishNewsActivity.this,image,this);

        recyclerView.setAdapter(adapter);
        addshow();
    }
    private void addshow() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView_english);
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
                intent.putExtra("Link",englshlink[0]);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[1]);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[2]);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[3]);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[4]);
                startActivity(intent);
                break;
            case 5:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[5]);
                startActivity(intent);
                break;
            case 6:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[6]);
                startActivity(intent);
                break;
            case 7:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[7]);
                startActivity(intent);
                break;
            case 8:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[8]);
                startActivity(intent);
                break;
            case 9:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",englshlink[9]);
                startActivity(intent);
                break;
        }
        Toast.makeText(getApplicationContext(),"Loading...Please wait",Toast.LENGTH_SHORT).show();

    }
}