package kevinsmith.iatracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class LoadCampaign extends AppCompatActivity {

    private Button mLoadedCampaign;
    private int numOfSavedMissions = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_campaign);

        /* Any previous saved campaigns will be loaded and displayed for the user to select. */
        LinearLayout ll = (LinearLayout) findViewById(R.id.loadCampaignScroll);

        for (int i =0; i < numOfSavedMissions; i++){
            RadioButton ch = new RadioButton(this);
            ch.setText("saved campaign checkbox (dynamically added checkbox)");   //default until database is running
            ll.addView(ch);
        }

        mLoadedCampaign = (Button) findViewById(R.id.mLoadedCampaign);
        mLoadedCampaign.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(LoadCampaign.this, LoadedCampaign.class) );
            }
        });

    }
}
