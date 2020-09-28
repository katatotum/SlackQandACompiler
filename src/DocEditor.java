import java.util.ArrayList;

/**
 * The purpose of this class is to load a Google doc into memory,
 * and update the doc when things change.
 * @author Mark
 */
public class DocEditor {
	String docName;

	public DocEditor(String docName) {
		this.docName = docName;
	}

	/**
	 * This method loads the content from the google document called docName, creates an Entry instance for each entry,
	 * and returns an ArrayList of all those entries
	 
	 * @return the ArrayList of entries
	 */
	public ArrayList<Entry> loadDoc() {
		return null;
	}

	/***
	 * Given a list of entries, update the text in the document to reflect the current state of the entries.
	 
	 * @param entryContainer
	 */
	public void updateDoc(EntryContainer entryContainer) {
		// TODO Auto-generated method stub

	}
}
