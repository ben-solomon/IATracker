/* This activity allows users to select the side mission of a new campaign
 *
  * NOTE: Currently, there is no minimum or maximum set, so a user can select any number of checkboxes.
  *       In the future, only 13 checkboxes will be able to be selected at once for "full campaign"
  *       This activity will be skipped if a mini campaign (Twin Shadows or Bespin's Gambit) is selected */

package kevinsmith.iatracker;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MissionsSelectNew extends AppCompatActivity {

    private Button mImperialDeckSelect;                         // button to next activity
    private int maxNumOfMissions = 13;                          // this max is only for full campaigns, not mini (Twin Shadows and Bespin's Gambit
    private int cnt;                                            // store number of items retrieved from the text file
    private int numOfMissionAttr = 3;                           // number of values on each line of the text file
    private String missionSelectFile = "side_missions.txt";     // text file name containing the card data for that particular card category
    ArrayList<String> missionList;                              // store the values from the text file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions_select);

        /* Each side mission name will populate with a corresponding checkbox */
        populateData();

        /* The user can proceed to the Imperial Class Deck selection activity */
        mImperialDeckSelect = (Button) findViewById(R.id.mImperialDeckSelect);
        mImperialDeckSelect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MissionsSelectNew.this, ImperialClassSelectNew.class) );
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

    /* Populate each side mission and a corresponding checkbox. Any other data is skipped over. */
    public void populateData() {

        AssetManager am = getAssets();
        Scanner sc = null;

        /* Open the file, which contains delimiters: ",  " and newline characters */
        try {
            missionList = new ArrayList<String>();
            sc = new Scanner(am.open(missionSelectFile));
            sc.useDelimiter("\\s*,\\s*|\\n\\s*");
            cnt = 0;

            while (sc.hasNext()){
                missionList.add(sc.next());
                cnt++;
            }
        }
        catch (IOException e){
            Log.e("file open error: ", e.getMessage());
        }
        finally {
            sc.close();
        }

        /* Create new layout to display the side missions names */
        LinearLayout ll = (LinearLayout) findViewById(R.id.missionScroll);

        /* Create the checkboxes to display the names stored in the list */
        for (int i = 1; i < cnt; i = i + numOfMissionAttr){
            CheckBox ch = new CheckBox(this);
            ch.setText(missionList.get(i) + "  ( " + missionList.get(i + 1) + ")");

            /* The data is added to the view */
            ll.addView(ch);
        }
    }
}