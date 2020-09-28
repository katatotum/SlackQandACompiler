import java.util.ArrayList;

/***
 * The purpose of this class is to hold on to a list of entries and
 * update the list when we get new messages.
 * It can also return data about the list of entries, such as
 * how many questions are unanswered.
 * @author Natalie && Mark
 *
 */
public class EntryContainer {
	ArrayList<Entry> allEntries;

	public EntryContainer(ArrayList<Entry> entries) {
		this.allEntries = entries;
	}

	/***
	 * Given a list of Slack messages, iterate through questions.
	 * If any of the messages are a new question, create a new question and add it to the
	 * list of questions.
	 * If any of the messages are a new response to an existing question, update the question.
	 */
	public void processMessages(ArrayList<SlackMessage> messages) {

	}

	// Helper methods that we expect to need for processMessages

	/***
	 * Returns the number of entries that do not have an answer.
	 * @return
	 */
	public int nOpenQuestions() {
		int total = 0;
		if (allEntries.isEmpty()) {
			return total;
		}
		else {
			for (Entry entry : this.allEntries) {
				if (!entry.isAnswered()) {
					total++;
				}
			}
			return total;
		}
	}

	/***
	 * Indicate whether a message is a new @mention of the homework bot.
	 * If so, we'll probably want to create a new Question.
	 * @return
	 */
	private boolean isNewAtMention(SlackMessage message) {
		return false;
	}

	/***
	 * Indicate whether a message is a new response to an existing Question that
	 * we are tracking.
	 * If so, we'll probably want to create a new response to that Question.
	 * @return
	 */
	private boolean isNewResponse(SlackMessage message) {
		return false;
	}

}
