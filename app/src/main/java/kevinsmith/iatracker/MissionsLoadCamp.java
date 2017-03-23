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
// what does the 8 in i<8 represent? Also ll1 and ll2 look a lot like l12 and 1l1 etc 
//(I should be the last one to criticize variable names since mine are pretty ambiguous, but this is more about readability) -BS
