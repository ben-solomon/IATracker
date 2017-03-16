/* This activity allows users to select a campaign book or mini campaign
 *
  * NOTE: Currently, there is no minimum or maximum set, so a user can select any number of radio buttons.
  *       In the future, only one radios will be able to be selected at once. */

package kevinsmith.iatracker;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CampaignSelectNew extends AppCompatActivity {

    private Button mMissionSelectBtn;                               // button to next activity
    private int maxNumOfCampaigns = 1;                              // not used yet
    private int cnt;                                                // store number of items retrieved from the text file
    private int numOfCampAttr = 2;                                  // number of values on each line of the text file
    private String campaignSelectFile = "campaign_selections.txt";  // text file name containing the card data for that particular card category
    ArrayList<String> campList;                                     // store the values from the text file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_select);

        /* Each campaign name will populate with a corresponding radio button */
        populateData();

        /* The user can proceed to the Side Missions selection activity */
        mMissionSelectBtn = (Button) findViewById(R.id.mMissionSelectBtn);
        mMissionSelectBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(CampaignSelectNew.this, MissionsSelectNew.class) );
            }
        });
    }

    /* Allows users to select About during the new campaign process. Currently, this option does nothing. */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /* Populate each campaign name with a corresponding radio buttons. Any other data is skipped over. */
    public void populateData() {

        AssetManager am = getAssets();
        Scanner sc = null;

        /* Open the file, which contains delimiters: ",  " and newline characters */
        try {
            campList = new ArrayList<String>();
            sc = new Scanner(am.open(campaignSelectFile));
            sc.useDelimiter("\\s*,\\s*|\\n\\s*");
            cnt = 0;

            while (sc.hasNext()){
                campList.add(sc.next());
                cnt++;
            }
        }
        catch (IOException e){
            Log.e("file open error: ", e.getMessage());
        }
        finally {
            sc.close();
        }

        /* Create new layout to display the campaign names */
        LinearLayout ll = (LinearLayout) findViewById(R.id.campaignScroll);

        /* Create the checkboxes to display the names stored in the list */
        for (int i = 1; i < cnt; i = i + numOfCampAttr){
            RadioButton ch = new RadioButton(this);
            ch.setText(campList.get(i));

            /* The data is added to the view */
            ll.addView(ch);
        }
    }
}