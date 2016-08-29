package androidcourse.dev.reviz20;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A placeholder fragment containing a simple view.
 */
public class NouveauCompteFragment extends Fragment {

    // déclaration des variables

    private Button btnnewcompte;
    private EditText txtpseudo;
    private EditText txtmail;
    private EditText txtpwd;
    private EditText txtage;
    private String genre;
    private ProgressDialog etatEnr;
    private DatabaseReference rootRef;

    public NouveauCompteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nouveau_compte, container, false);

        rootRef = FirebaseDatabase.getInstance().getReference();

        // initialisation des zones de texte
        txtpseudo = (EditText)rootView.findViewById(R.id.txtpseudo);
        txtmail = (EditText)rootView.findViewById(R.id.txtmail);
        txtpwd = (EditText)rootView.findViewById(R.id.txtpwd);
        txtage = (EditText)rootView.findViewById(R.id.txtage);
        //genre = "homme";
        btnnewcompte=(Button) rootView.findViewById(R.id.btnnewcompte);
        btnnewcompte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controleSaisie();
            }
        });

        return rootView;
    }

    public void controleSaisie(){
        String pseudo = txtpseudo.getText().toString().trim();
        String mail = txtmail.getText().toString().trim();
        String pwd = txtpwd.getText().toString().trim();
        String age = txtage.getText().toString().trim();

        if(TextUtils.isEmpty(pseudo)){
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Please enter pseudo", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        if(TextUtils.isEmpty(mail)){
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Please enter mail", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        if(TextUtils.isEmpty(pwd)){
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Please enter password", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        if(TextUtils.isEmpty(age)){
            Toast t = Toast.makeText(getActivity().getApplicationContext(), "Please enter your age", Toast.LENGTH_LONG);
            t.show();
            return;
        }

        InscriptionUser NewUser= new InscriptionUser(pseudo,mail,pwd,age);
        rootRef.push().setValue(NewUser);
        Toast t = Toast.makeText(getActivity().getApplicationContext(), "Success !", Toast.LENGTH_LONG);
        t.show();

        Intent intent = new Intent(getActivity(), Connexion.class);
        startActivity(intent);

    }
}
