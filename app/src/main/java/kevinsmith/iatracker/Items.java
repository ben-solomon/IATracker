package kevinsmith.iatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class Items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        LinearLayout ll1 = (LinearLayout) findViewById(R.id.itemsPurchase);

        for (int i =0; i < 8; i++){
            CheckBox ch = new CheckBox(this);
            ch.setText("item checkbox (dynamically added checkbox)");
            ll1.addView(ch);
        }

        LinearLayout ll2 = (LinearLayout) findViewById(R.id.itemsOwned);

        for (int i =0; i < 8; i++) {
            CheckBox ch = new CheckBox(this);
            ch.setText("item checkbox (dynamically added checkbox)");
            ll2.addView(ch);
        }

    }
}
