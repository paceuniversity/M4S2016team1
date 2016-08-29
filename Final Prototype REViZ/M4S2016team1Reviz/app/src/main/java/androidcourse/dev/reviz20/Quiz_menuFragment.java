package androidcourse.dev.reviz20;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class Quiz_menuFragment extends Fragment {

    public Quiz_menuFragment() {
    }

    private int currentQuestion;
    private String [] questions;
    private String [] answers;
    private Button btnvalider;
    private Button btnnextquestion;
    private TextView txtquestion;
    private TextView txtreponse;
    private EditText editreponse;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_quiz_menu, container, false);
        init();
        //return inflater.inflate(R.layout.fragment_quiz_menu, container, false);
        return rootView;

    }

    // fonction d'initialisation
    public void init()
    {
        questions = new String[]{"L'argent qu'ils ... ont volé.",
                "Quelle est la capitale du Mali"};
        answers = new String[]{"leur","Bamako"};
        currentQuestion = -1;
        btnvalider = (Button) rootView.findViewById(R.id.btnvalider);
        btnnextquestion = (Button) rootView.findViewById(R.id.btnquestion);
        txtquestion = (TextView) rootView.findViewById(R.id.txtquestions);
        txtreponse = (TextView) rootView.findViewById(R.id.txtreponse);
        editreponse = (EditText) rootView.findViewById(R.id.editreponse);
        showQuestion();
        btnvalider.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                checkAnswer();
            }});
        btnnextquestion.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                showQuestion();
            }});
    }

    /*
* This method
* 1: increment currentQuestion index
* 2: check if it is equal to the size of the array and rest
if necessary
* 3: display the question at currentQuestion index in
question view
* 4: Empty answer view
*/
    public void showQuestion()
    {
        currentQuestion++;
        if(currentQuestion == questions.length)
            currentQuestion =0;
        txtquestion.setText(questions[currentQuestion]);
        txtreponse.setText("");
        editreponse.setText("");
    }
    /*
    * This method return true if the answer equals to correct
    answer
    * (Ignoring case)
    */
    public boolean isCorrect(String answer)
    {
        return (answer.equalsIgnoreCase(answers[currentQuestion]));
    }
    /* this method :
    * 1: Read the text ( answer) from the answerTextEdit
    * 2: call the isCorrect method
    * 3: display the appropriate message.
    */
    public void checkAnswer()
    {
        String answer = editreponse.getText().toString();
        if(isCorrect(answer))
            txtreponse.setText("Vous avez trouvé!");
        else
            txtreponse.setText("Désolé, la bonne réponse est "+answers[currentQuestion]);
    }
}
