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

public class HeroSelectNew extends AppCompatActivity {

    private Button mSaveBtn;
    private int maxHeroes = 4;
    private int minHeroes = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_select_new);

        /* Hero selection options depend on which campaign was previously selected and which heroes are eligble */
        LinearLayout ll = (LinearLayout) findViewById(R.id.heroScroll);
        for (int i =0; i < maxHeroes; i++){
            CheckBox ch = new CheckBox(this);
            ch.setText("hero checkbox (dynamically added checkbox)");   //default until database is running
            ll.addView(ch);
        }


        mSaveBtn = (Button) findViewById(R.id.mSaveBtn);
        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

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
