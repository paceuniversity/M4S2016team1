package androidcourse.dev.reviz20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class FrancaisMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_francais_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void Oral(View v) {

        Intent intent = new Intent(FrancaisMenu.this, FrancaisOral.class);
        startActivity(intent);
    }

    public void Ecrit(View v) {

        Intent intent = new Intent(FrancaisMenu.this, FrancaisEcrit.class);
        startActivity(intent);
    }

}
