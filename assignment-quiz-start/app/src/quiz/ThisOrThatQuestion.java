package quiz;

public class ThisOrThatQuestion extends MultipleChoiceQuestion{
    public ThisOrThatQuestion(String question, String answer1, String answer2, int correctAnswer, int score) {
        super(question, new String[]{answer1, answer2}, correctAnswer, score);
    }

    public ThisOrThatQuestion(String question, String answer1, String answer2, int correctAnswer) {
        super(question, new String[]{answer1, answer2}, correctAnswer);
    }

    @Override
    public String correctAnswer(){
        return getAnswer(getCorrectAnswer());
    }

    @Override
    public boolean isCorrect(String answer){
        return answer == getAnswer(getCorrectAnswer());
    }

    @Override
    public String toString(){
        return getAnswer(0) + " or " + getAnswer(1) + ": " + getQuestion();
    }
}
