package kevinsmith.iatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class HeroDecks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_decks);

        LinearLayout ll1 = (LinearLayout) findViewById(R.id.heroDecks);

        for (int i =0; i < 8; i++){
            CheckBox ch = new CheckBox(this);
            ch.setText("hero ability checkboxes (dynamically added checkbox)");
            ll1.addView(ch);
        }

    }
}
