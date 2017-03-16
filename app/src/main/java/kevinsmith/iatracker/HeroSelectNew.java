/* This activity allows users to select 2 to 4 heroes they want for their new campaign
 *
  * NOTE: Currently, there is no minimum or maximum set, so a user can select any number of checkboxes.
  *       The min/max will prohibit users from selecting 0-1 and 5+ in the future. */

package kevinsmith.iatracker;

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

public class HeroSelectNew extends AppCompatActivity {

    private Button mSaveBtn;                            // save button
    private int maxHeroes = 4;                          // max
    private int minHeroes = 2;                          // min
    private int cnt;                                    // store number of items retrieved from the text file
    private int numOfHeroAttr = 2;                      // number of values on each line of the text file
    private String ipAgendaFile = "heroes_list.txt";    // text file name containing the card data for that particular card category
    ArrayList<String> heroList;                         // store the values from the text file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_select_new);

        /* Each hero name will populate with a corresponding checkbox */
        populateData();

        /* The save option is not functional. When it is, it will save the proper data associated with the new campaign. */
        mSaveBtn = (Button) findViewById(R.id.mSaveBtn);
        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

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

    /* Populate each hero name with a corresponding checkbox. Any other data is skipped over. */
    public void populateData() {

        AssetManager am = getAssets();
        Scanner sc = null;

        /* Open the file, which contains delimiters: ",  " and newline characters */
        try {
            heroList = new ArrayList<String>();
            sc = new Scanner(am.open(ipAgendaFile));
            sc.useDelimiter("\\s*,\\s*|\\n\\s*");
            cnt = 0;

            while (sc.hasNext()){
                heroList.add(sc.next());
                cnt++;
            }

        }
        catch (IOException e){
            Log.e("file open error: ", e.getMessage());
        }
        finally {
            sc.close();
        }

        /* Create new layout to display the hero names */
        LinearLayout ll = (LinearLayout) findViewById(R.id.heroScroll);

        /* Create the checkboxes to display the names stored in the list */
        for (int i = 0; i < cnt; i = i + numOfHeroAttr){
            CheckBox ch = new CheckBox(this);

            /* All heroes have last names, except the following two */
            if (heroList.get(i).equals("Gaarkhan") || heroList.get(i).equals("MDH-19")){
                ch.setText(heroList.get(i));
            }
            else {
                ch.setText(heroList.get(i) + " " + heroList.get(i + 1));
            }

            /* The data is added to the view */
            ll.addView(ch);
        }
    }
}