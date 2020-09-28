import java.util.ArrayList;

/***
 * The purpose of this class is to retrieve new Slack messages from the API
 * and create new instances of SlackMessage.
 * @author Natalie
 *
 */
public class SlackMessageRetriever {

	/***
	 * Establish a new connection with the API.
	 */
	public SlackMessageRetriever() { // probably one of the arguments will be the API token

	}

	/***
	 * Check for new messages. Still TBD whether this will be accomplished via
	 * webhooks (preferred, but probably harder) or by periodically polling for new messages.
	 */
	public ArrayList<SlackMessage> checkForMessages() {
		return null;
	}

}
