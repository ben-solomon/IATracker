package kevinsmith.iatracker;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MissionsSelectNew extends AppCompatActivity {

    private Button mImperialDeckSelect;
    private int maxNumOfMissions = 13;  // default until the database is running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions_select);

        /* The selected campaign will dictate which and how many side missions are displayed.
        *   The side missions checkboxes will be dynamically added once the DB is up and running. */
        LinearLayout ll = (LinearLayout) findViewById(R.id.missionScroll);

        for (int i =0; i < maxNumOfMissions; i++){
            CheckBox ch = new CheckBox(this);
            ch.setText("mission checkbox (dynamically added checkbox)");   //default until database is running
            ll.addView(ch);
        }

        mImperialDeckSelect = (Button) findViewById(R.id.mImperialDeckSelect);
        mImperialDeckSelect.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v){
                 startActivity(new Intent(MissionsSelectNew.this, ImperialClassSelectNew.class) );
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
