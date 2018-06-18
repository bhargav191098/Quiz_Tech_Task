package u.com.example.quiz;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankCric {

    // declare list of Question objects
    List <Question> list = new ArrayList<>();
    MyDataBaseHelperCric myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelperCric(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("India played it's first Test cricket match against?",
                    new String[]{"England", "Pakistan", "Australia", "South Africa"}, "England"));
            myDataBaseHelper.addInitialQuestion(new Question("India played its first T20 match against?",
                    new String[]{"Pakistan", "South Africa", "Afghanistan", "England"}, "South Africa"));
            myDataBaseHelper.addInitialQuestion(new Question("Pakistan's contribution to world cricket is: ",
                    new String[]{"No-Ball", "Run Out", "Reverse Swing", "LBW"}, "Reverse Swing"));
            myDataBaseHelper.addInitialQuestion(new Question("The nickname of Glenn McGrath is what?",
                    new String[]{"Ooh Aah", "Pigeon", "Big Bird", "Penguin"}, "Pigeon"));
            myDataBaseHelper.addInitialQuestion(new Question("What name is given to the score 111 in cricket?",
                    new String[]{"Nelson", "Stump", "Macro", "Pony"}, "Nelson"));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}