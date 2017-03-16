/* This activity allows users to select Imperial Player's agenda decks
 *
  * NOTE: Currently, there is no minimum or maximum set, so a user can select any number of checkboxes.
  *       In the future, only 5 checkboxes will be able to be selected at once  */

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
import android.widget.LinearLayout;
import android.widget.CheckBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AgendaSelectNew extends AppCompatActivity {

    private Button mHeroSelect;                             // button to next activity
    private int maxAgendaDeck = 5;                          // max
    private int cnt;                                        // store number of items retrieved from the text file
    private int numOfAgendaAttr = 7;                        // number of values on each line of the text file
    private String ipAgendaFile = "agenda_decks.txt";       // text file name containing the card data for that particular card category
    ArrayList<String> ipAgendaList;                         // store the values from the text file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_new);

        /* Each IP agenda deck name will populate with a corresponding checkbox */
        populateData();

        /* The user can proceed to the Imperial Agenda decks selection activity */
        mHeroSelect = (Button) findViewById(R.id.mHeroSelect);
        mHeroSelect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AgendaSelectNew.this, HeroSelectNew.class) );
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

    /* Populate each agenda deck name with a corresponding checkbox. Any other data is skipped over. */
    public void populateData() {

        AssetManager am = getAssets();
        Scanner sc = null;

        /* Open the file, which contains delimiters: ",  " and newline characters */
        try {
            ipAgendaList = new ArrayList<String>();
            sc = new Scanner(am.open(ipAgendaFile));
            sc.useDelimiter("\\s*,\\s*|\\n\\s*");
            cnt = 0;

            while (sc.hasNext()){
                ipAgendaList.add(sc.next());
                System.out.println(ipAgendaList.get(cnt) + " " + cnt);
                cnt++;
            }

        }
        catch (IOException e){
            Log.e("file open error: ", e.getMessage());
        }
        finally {
            sc.close();
        }

        /* Create new layout to display the agenda decks names */
        LinearLayout ll = (LinearLayout) findViewById(R.id.agendaScroll);

        for (int i = 0; i < cnt; i = i + numOfAgendaAttr){
            CheckBox ch = new CheckBox(this);
            ch.setText(ipAgendaList.get(i));

            /* The data is added to the view */
            ll.addView(ch);
        }
    }
}