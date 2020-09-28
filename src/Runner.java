import java.util.ArrayList;

/***
 * The purpose of this class is to run our program.
 * @author Natalie && Mark
 *
 */
public class Runner {
	SlackMessageRetriever slackMessageRetriever;
	EntryContainer entryContainer;

	public void Run() {

		// Initialize document
		String docName = "MCIT 591 Q&A";

		DocEditor docEditor = new DocEditor(docName);

		// Load data from the document into memory
		ArrayList<Entry> questions = docEditor.loadDoc();
		entryContainer = new EntryContainer(questions);

		// Open a connection to slack
		slackMessageRetriever = new SlackMessageRetriever();


		while (true) {
			// Check for new Slack messages
			ArrayList<SlackMessage> newMessages = slackMessageRetriever.checkForMessages();

			// Update the data in memory with new data from Slack
			entryContainer.processMessages(newMessages);

			// Iterate through questions, check if any are new or have new responses.
			// Update the document accordingly.
			docEditor.updateDoc(entryContainer);

			// Sleep for ten seconds
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
