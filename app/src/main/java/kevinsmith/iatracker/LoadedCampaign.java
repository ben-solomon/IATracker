package kevinsmith.iatracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadedCampaign extends AppCompatActivity {

    private Button mMissionsBtn;
    private Button mImpOwnedBtn;
    private Button mImpPurchaseBtn;
    private Button mItemsBtn;
    private Button mHeroDecksBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loaded_campaign);

        mMissionsBtn = (Button) findViewById(R.id.mMissionsBtn);
        mMissionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadedCampaign.this, MissionsLoadCamp.class));
            }
        });


        mImpOwnedBtn = (Button) findViewById(R.id.mImpOwnedBtn);
        mImpOwnedBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoadedCampaign.this, ImpOwned.class));
            }
        });

        mImpPurchaseBtn = (Button) findViewById(R.id.mImpPurchaseBtn);
        mImpPurchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadedCampaign.this, ImpPurchase.class));
            }
        });


        mItemsBtn = (Button) findViewById(R.id.mItemsBtn);
        mItemsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoadedCampaign.this, Items.class));
            }
        });

        mHeroDecksBtn = (Button) findViewById(R.id.mHeroDecksBtn);
        mHeroDecksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoadedCampaign.this, HeroDecks.class));
            }
        });
    }
}
