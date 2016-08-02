package androidcourse.dev.reviz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Thematiques extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thematiques);

        String[] fruits = {"Anglais", "Français", "Mathématiques"};
        List<String> fruitAL;
        fruitAL = new ArrayList<String>(Arrays.asList(fruits));

        ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(this,
                R.layout.fragment_thematiques,
                R.id.textviewitem1,
                fruitAL);

        ListView lv = (ListView) findViewById(R.id.lstthematiques);
        lv.setAdapter(fruitAdapter);
    }
}
