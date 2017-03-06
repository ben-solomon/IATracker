package kevinsmith.iatracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MissionsLoadCamp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missions_load_camp);

        LinearLayout ll1 = (LinearLayout) findViewById(R.id.storyMissionScroll);

        for (int i =0; i < 8; i++){
            CheckBox ch = new CheckBox(this);
            ch.setText("mission checkbox (dynamically added checkbox)");
            ll1.addView(ch);
        }

        LinearLayout ll2 = (LinearLayout) findViewById(R.id.sideMissionScroll);

        for (int i =0; i < 8; i++) {
            CheckBox ch = new CheckBox(this);
            ch.setText("mission checkbox (dynamically added checkbox)");
            ll2.addView(ch);
        }
    }
}
