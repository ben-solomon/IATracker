package kevinsmith.iatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class CampaignSelectNew extends AppCompatActivity {

    private Button mMissionSelectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_select);

        mMissionSelectBtn = (Button) findViewById(R.id.mMissionSelectBtn);
        mMissionSelectBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CampaignSelectNew.this, MissionsSelectNew.class) );
            }
        });
    }

    /* Allows users to select About during the new campaign process */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

}
