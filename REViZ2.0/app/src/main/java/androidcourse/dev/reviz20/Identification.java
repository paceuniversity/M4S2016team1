package androidcourse.dev.reviz20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Identification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identification);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void SeConnecter(View v) {

        Intent intent = new Intent(Identification.this, Connexion.class);
        startActivity(intent);
    }

    public void Sinscrire(View v) {

        Intent intent = new Intent(Identification.this, NouveauCompte.class);
        startActivity(intent);
    }

}
