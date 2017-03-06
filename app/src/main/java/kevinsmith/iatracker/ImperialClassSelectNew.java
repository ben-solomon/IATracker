package kevinsmith.iatracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class ImperialClassSelectNew extends AppCompatActivity {

    private Button mAgendaSelect;
    private int numOfDecks = 3; //default until database is running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperial_class_deck);


        /* Imperial deck options depend on which campaign was previously selected and which decks are eligble */
        LinearLayout ll = (LinearLayout) findViewById(R.id.imperialClassDecks);

        for (int i =0; i < numOfDecks; i++){
            RadioButton ch = new RadioButton(this);
            ch.setText("deck radio button (dynamically added radio)");   //default until database is running
            ll.addView(ch);
        }

        mAgendaSelect = (Button) findViewById(R.id.mAgendaSelect);
        mAgendaSelect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(ImperialClassSelectNew.this, AgendaSelectNew.class) );
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
