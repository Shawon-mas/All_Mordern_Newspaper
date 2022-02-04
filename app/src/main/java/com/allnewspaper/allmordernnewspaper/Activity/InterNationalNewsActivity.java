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

public class InterNationalNewsActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    BengaliNewsTitleAdapter adapter;
    int[] image={R.drawable.nytimes,R.drawable.thegurdian,
            R.drawable.themoscowtimes, R.drawable.japantimes,
            R.drawable.thewall, R.drawable.thetimes,
            R.drawable.torontostar,R.drawable.bangkokpost,
            R.drawable.theglobe,R.drawable.dailyobserver
    };
    String[] InternationalLink;
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_national_news);
        recyclerView=findViewById(R.id.recyclerview_international_news);
        InternationalLink=getResources().getStringArray(R.array.InternationalLink);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new BengaliNewsTitleAdapter(InterNationalNewsActivity.this,image,this);

        recyclerView.setAdapter(adapter);
        addshow();

    }
    private void addshow() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView_international);
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
                intent.putExtra("Link",InternationalLink[0]);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[1]);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[2]);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[3]);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[4]);
                startActivity(intent);
                break;
            case 5:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[5]);
                startActivity(intent);
                break;
            case 6:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[6]);
                startActivity(intent);
                break;
            case 7:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[7]);
                startActivity(intent);
                break;
            case 8:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[8]);
                startActivity(intent);
                break;
            case 9:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",InternationalLink[9]);
                startActivity(intent);
                break;
        }
        Toast.makeText(getApplicationContext(),"Loading...Please wait",Toast.LENGTH_SHORT).show();


    }
}