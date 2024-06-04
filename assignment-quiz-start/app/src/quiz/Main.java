package quiz;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Questionnaire();
    }
	
	private static List<Question> questions = new ArrayList<>();
	private static List<Question> wrong = new ArrayList<>();
	private static int scoreRound1;
	private static int scoreRounds;

	public static void Questionnaire(){
		questions.add(new OpenQuestions("What is the big O complexity of binary search?", "O(log N)"));
		questions.add(new OpenQuestions("How would you read an integer i from scanner s in Java?", "i = s.nextInt();", 2));
		questions.add(new OpenQuestions("What is the minimum amount of constructors you have to define for a class in Java?", "0", 2));
		questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?", new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1, 4));
		questions.add(new MultipleChoiceQuestion("How do you print \"Hello world\" on a line in Java?", new String[] { "System.out.print(\"Hello world\");", "System.out.println(\"Hello world\");", "cout << \"Hello world\";" }, 1));
		questions.add(new MultipleChoiceQuestion("How do you read a non-empty word in Java using scanner s?", new String[] { "s.nextline()", "s.next(\"\\S+\")", "s.next(\"\\a*\")", "s.next(\"\\S*\")", "s.next(\"\\\\s+\")", "s.next(\"\\s+\")", "s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")", "s.nextString()" }, 7, 1));
		questions.add(new ThisOrThatQuestion("Every class must have a constructor", "Right", "Wrong", 1));
		questions.add(new ThisOrThatQuestion("Is there a difference between an interface and an abstract class?", "Yes", "No", 0, 5));
		questions.add(new ThisOrThatQuestion("Is there a maximum to the amount of constructors a class can have in Java?", "Yes", "No", 1));

		scoreRound1 = 0;
		scoreRounds = 0;
		Scanner scan = new Scanner(System.in);
		for(Question i : questions){
			System.out.println(i.toString());
			String answer = scan.nextLine();
			if(!(i.isCorrect(answer))){
				System.out.println("Incorrect");
				wrong.add(i);
			}
			else{
				System.out.println("Correct");
				scoreRound1 += i.getScore();
			}
		}

		for(Question i : wrong){
			System.out.println(i.toString());
			String answer = scan.nextLine();
			if(!(i.isCorrect(answer))){
				System.out.println("Incorrect");
			}
			else{
				System.out.println("Correct");
				scoreRounds += i.getScore();
			}
		}
		System.out.println("Score for the first round: " + scoreRound1);
		System.out.println("End score: " + scoreRounds);
		scan.close();
	}
}