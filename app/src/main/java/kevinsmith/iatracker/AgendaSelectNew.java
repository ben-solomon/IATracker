package kevinsmith.iatracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.CheckBox;

public class AgendaSelectNew extends AppCompatActivity {

    private Button mHeroSelect;
    private int maxAgendaDeck = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda_new);

        /*The selected campaign will dictate which and how many side missions are displayed.
         *   The side missions checkboxes will be dynamically added once the DB is up and running. */
        LinearLayout ll = (LinearLayout) findViewById(R.id.agendaScroll);

        for (int i =0; i < maxAgendaDeck; i++){
            CheckBox ch = new CheckBox(this);
            ch.setText("checkbox agenda option (dynamically added checkbox)");   //default until database is running
            ll.addView(ch);
        }

        mHeroSelect = (Button) findViewById(R.id.mHeroSelect);
        mHeroSelect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(AgendaSelectNew.this, HeroSelectNew.class) );
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
