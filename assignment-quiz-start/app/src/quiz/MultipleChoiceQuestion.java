package quiz;

public class MultipleChoiceQuestion extends Question{
    private String answers[];
    private int correctAnswer;

    public MultipleChoiceQuestion (String question, String[] answers, int correctAnswer, int score){
        super(question, "", score);
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public MultipleChoiceQuestion (String question, String [] answers, int correctAnswer ){
        super(question, "", 3);
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString(){
        String string = "";
        string += getQuestion() + "\n";
        for(int i = 97; i < answers.length + 97; i++){
            string += (char) i + ") " +  this.answers[i - 97] + "\n";
        }
        return string;
    }

    @Override
    public String correctAnswer(){
        return "" + (char) (correctAnswer + 97);
    }

    public int getCorrectAnswer(){
        return correctAnswer;
    }

    public String getAnswer(int i){
        return answers[i];
    }

    @Override
    public boolean isCorrect(String answer){
        return answer.equals("" + (char)(correctAnswer + 97));
    }
}
