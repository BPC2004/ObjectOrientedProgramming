package quiz;

public abstract class Question {
    private int score;
    private String question;
    private String answer;

    public Question (String question, String answer, int score){
        this.question = question;
        this.answer = answer;
        setScore(score);
    }

    public String toString() {
        return this.question;
    }

    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(this.answer);
    }

    public String correctAnswer() {
        return answer;
    }

    public int getScore() {
        return this.score;
    }

    public String getQuestion(){
        return question;
    }

    public void setScore(int val) {
        if(val < 6 && val > 0){this.score = val;}
        else{this.score = 3;}
    }
}
