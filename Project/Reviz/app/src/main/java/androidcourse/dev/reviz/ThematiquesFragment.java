package androidcourse.dev.reviz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ThematiquesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ThematiquesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThematiquesFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ThematiquesFragment() {
        // Required empty public constructor
    }



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThematiquesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThematiquesFragment newInstance(String param1, String param2) {
        ThematiquesFragment fragment = new ThematiquesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thematiques, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_thematiques, container, false);

 /*           String[] people = {"John", "Peter", "Luis"};

            ArrayAdapter<String> peopleAdapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1,
                    people);

            ListView lv1 = (ListView) rootView.findViewById(R.id.listviewlayout);
            lv1.setAdapter(peopleAdapter);
*/
            String[] fruits = {"Anglais", "Français", "Mathématiques"};
            List<String> fruitAL;
            fruitAL = new ArrayList<String>(Arrays.asList(fruits));

            ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.fragment_thematiques,
                    R.id.textviewitem1,
                    fruitAL);

            ListView lv = (ListView) rootView.findViewById(R.id.lstthematiques);
            lv.setAdapter(fruitAdapter);


            //ArrayAdapter<String> fruitAdapter = new ArrayAdapter<String>(getActivity(),
            //        android.R.layout.simple_list_item_1,
            //        fruits);


            //ListView lv = (ListView) rootView.findViewById(R.id.listviewlayout);
            //lv.setAdapter(fruitAdapter);

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        Log.i("hello", "Anglais");
                    } else if (position == 1) {
                        Log.i("hello", "Français");
                    } else if (position == 2) {
                        Log.i("hello", "Mathématiques");
                    }
                }
            });

            return rootView;
        }
    }
}
