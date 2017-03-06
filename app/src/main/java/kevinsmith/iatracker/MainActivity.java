package kevinsmith.iatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button mNewCampaignBtn;
    private Button mLoadCampaignBtn;
    private Button mAboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewCampaignBtn = (Button) findViewById(R.id.mNewCampaignBtn);
        mNewCampaignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CampaignSelectNew.class));
            }
        });


        mLoadCampaignBtn = (Button) findViewById(R.id.mLoadCampaignBtn);
        mLoadCampaignBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, LoadCampaign.class));
            }
        });
//
//        mAboutBtn = (Button) findViewById(R.id.mAboutBtn);
//        mAboutBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//
//            }
//        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}
