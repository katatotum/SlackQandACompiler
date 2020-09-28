import java.util.ArrayList;

/***
 * The purpose of this class is to hold data about homework questions.
 * @author Natalie && Mark
 *
 */
public class Entry {
	ArrayList<SlackMessage> responses;
	boolean answered;

	public Entry() {

	}

	/***
	 * Return the response that has the most number of "votes".
	 * Working idea: people can react to a message with an obscure emoji (TBD)
	 * to indicate that they believe a message contains the answer to the question.
	 * @return
	 */
	public SlackMessage answer() {
		return null;
	}

	/***
	 * Return the assignment number that the question relates to based on the date
	 * that the question was asked.
	 * @return
	 */
	public String homeworkAssignment() {
		return null;
	}

	/***
	 * Indicate whether the question is new since the last time we updated the document.
	 * Possible point of communication between Slack side of program and document side (maybe
	 * the Slack Manager can set this).
	 * @return
	 */
	public boolean isNew() {
		return false;
	}

	// Getters and Setters

	/***
	 * Indicate whether the question is answered.
	 * @return
	 */
	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

}
