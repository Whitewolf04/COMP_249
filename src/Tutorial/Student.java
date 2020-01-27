package Tutorial;

/**
 * This is a student class which can be used to manage students and calculate their scores.
 * 
 * @author Tuan To
 * @version  1.0.0
 */

public class Student {
	private int[] quizScore = new int[3];
	private int midtermScore, finalScore;
	private double overallScore;
	private char letterGrade;
	
	public int getQuizScore(int index) {
		if (index >= quizScore.length) {
			System.out.println("index not available");
			return -1;
		} else {
			return quizScore[index];
		}
	}
	
	// Accessor methods
	public int getMidtermScore() {
		return midtermScore;
	}
	
	public int getFinalScore() {
		return finalScore;
	}
	
	public double getOverallScore() {
		return overallScore;
	}
	
	public char getLetterGrade() {
		return letterGrade;
	}
	
	// Mutator methods
	public void setMidtermScore(int score) {
		midtermScore = score;
	}
	public void setFinalScore(int score) {
		finalScore = score;
	}
	
	public void setquizScore(int index, int score) {
		if (index >= quizScore.length) {
			System.out.println("index not available");
		} else {
			quizScore[index] = score;
		}
	}
	
	public void setOverallScore(double score) {
		overallScore = score;
	}
	
	public void setLetterGrade(char letter) {
		letterGrade = letter;
	}
	
	/**
	 * This method calculates the overall score based on pre-set weights
	 */
	public void calculateOverallScore() {
		double weightedQuizScore = 0.0, weightedMidtermScore, weightedFinalScore;
		for(int k = 0; k < 3; k++) {
			weightedQuizScore += quizScore[k]*0.05;
		}
		weightedMidtermScore = midtermScore * 0.35;
		weightedFinalScore = finalScore * 0.5;
		
		overallScore += weightedQuizScore + weightedMidtermScore + weightedFinalScore;
	}
	
	public void finalLetterGrade() {
		if(overallScore > 90) {
			letterGrade = 'A';
		} else if(overallScore < 60) {
			letterGrade = 'F';
		} else {
			if(overallScore <= 90 && overallScore > 80) {
				letterGrade = 'B';
			} else if(overallScore <= 80 && overallScore > 70) {
				letterGrade = 'C';
			} else if(overallScore <= 70 && overallScore >= 60) {
				letterGrade = 'D';
			}
		}
	}
}
