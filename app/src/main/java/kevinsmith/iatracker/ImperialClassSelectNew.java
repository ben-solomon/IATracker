/* This activity allows users to select Imperial Player's class deck
 *
  * NOTE: Currently, there is no minimum or maximum set, so a user can select any number of radio buttons.
  *       In the future, only 1 radio will be able to be selected at once  */

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
import android.widget.RadioButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImperialClassSelectNew extends AppCompatActivity {

    private Button mAgendaSelect;                           // button to next activity
    private int maxNumOfImpClasses = 1;                     // maximum of IP class decks
    private int cnt;                                        // store number of items retrieved from the text file
    private int numOfClassAttr = 19;                        // number of values on each line of the text file
    private String ipClassFile = "ip_class_decks.txt";      // text file name containing the card data for that particular card category
    ArrayList<String> ipClassList;                          // store the values from the text file


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperial_class_deck);

        /* Each IP class deck name will populate with a corresponding radio button */
        populateData();

        /* The user can proceed to the Imperial Agenda decks selection activity */
        mAgendaSelect = (Button) findViewById(R.id.mAgendaSelect);
        mAgendaSelect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(ImperialClassSelectNew.this, AgendaSelectNew.class) );
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

    /* Populate each IP class deck name with a corresponding checkbox. Any other data is skipped over. */
    public void populateData() {

        AssetManager am = getAssets();
        Scanner sc = null;

        /* Open the file, which contains delimiters: ",  " and newline characters */
        try {
            ipClassList = new ArrayList<String>();
            sc = new Scanner(am.open(ipClassFile));
            sc.useDelimiter("\\s*,\\s*|\\n\\s*");
            cnt = 0;

            while (sc.hasNext()){
                ipClassList.add(sc.next());
                System.out.println(ipClassList.get(cnt) + " " + cnt);
                cnt++;
            }

        }
        catch (IOException e){
            Log.e("file open error: ", e.getMessage());
        }
        finally {
            sc.close();
        }

        /* Create new layout to display the IP class decks names */
        LinearLayout ll = (LinearLayout) findViewById(R.id.imperialClassDecks);

        /* Create the radio buttons to display the names stored in the list */
        for (int i = 0; i < cnt; i = i + numOfClassAttr){
            RadioButton ch = new RadioButton(this);
            ch.setText(ipClassList.get(i));

            /* The data is added to the view */
            ll.addView(ch);

            /* The following class deck has one extra card, so a special check was needed */
            if (ipClassList.get(i).equals("Nemeses")){
                i += 2;
                System.out.println(ipClassList.get(i-2));
            }
        }
    }
}