package androidcourse.dev.reviz20;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ThematiquesFragment extends Fragment {

    public ThematiquesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thematiques, container, false);

        String[] fruits = {"Français","Mathématiques","Histoire-Géographie","Langue vivante 1","Physique","Chimie"};
        List<String> fruitAL = new ArrayList<String>(Arrays.asList(fruits));

        ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.listviewitem,
                R.id.textviewitem,
                fruitAL);

        ListView lv = (ListView) rootView.findViewById(R.id.listviewstates);
        lv.setAdapter(fruitAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getActivity(), FrancaisMenu.class);
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getActivity(), Mathematiques.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(getActivity(), Histoire.class);
                    startActivity(intent);
                }
            }
        });

        return rootView;
    }
}
