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

public class OnlineNewsActivity extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    BengaliNewsTitleAdapter adapter;
    AdView adView;
    int[] image={R.drawable.bbbc,R.drawable.bangatribune,
            R.drawable.jago, R.drawable.bn24,
            R.drawable.somoy, R.drawable.ekattor,
            R.drawable.rtv,R.drawable.independent,
            R.drawable.jamuna,R.drawable.chanel24
    };
    String[] OnlineLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_news);
        recyclerView=findViewById(R.id.recyclerview_online_news);
        OnlineLink=getResources().getStringArray(R.array.OnlineLink);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new BengaliNewsTitleAdapter(OnlineNewsActivity.this,image,this);

        recyclerView.setAdapter(adapter);
        addshow();
    }
    private void addshow() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        adView = findViewById(R.id.adView_online);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

    }
    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent();
        switch (position)
        {
            case 0:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[0]);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[1]);
                startActivity(intent);
                break;
            case 2:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[2]);
                startActivity(intent);
                break;
            case 3:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[3]);
                startActivity(intent);
                break;
            case 4:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[4]);
                startActivity(intent);
                break;
            case 5:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[5]);
                startActivity(intent);
                break;
            case 6:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[6]);
                startActivity(intent);
                break;
            case 7:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[7]);
                startActivity(intent);
                break;
            case 8:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[8]);
                startActivity(intent);
                break;
            case 9:
                intent=new Intent(getApplicationContext(),NewsLoadActivity.class);
                intent.putExtra("Link",OnlineLink[9]);
                startActivity(intent);
                break;
        }
        Toast.makeText(getApplicationContext(),"Loading...Please wait",Toast.LENGTH_SHORT).show();

    }
}