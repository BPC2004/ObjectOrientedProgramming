package quiz;

public class OpenQuestions extends Question{
    public OpenQuestions (String question, String answer, int score){
        super(question, answer, score);
    }

    public OpenQuestions (String question, String answer){
        super(question, answer, 3);
    }
}
