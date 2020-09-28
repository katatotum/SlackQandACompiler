import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class EntryContainerTest {

	@Test
	public void howManyOpenQuestionsTestWhenThereAreNoEntries() {
		ArrayList<Entry> entries = new ArrayList<Entry>();
		EntryContainer entryContainer = new EntryContainer(entries);

		assertEquals(0, entryContainer.nOpenQuestions());
	}

	@Test
	public void howManyOpenQuestionsTestWhenThereAreEntries() {
		ArrayList<Entry> entries = new ArrayList<Entry>();

		Entry entry1 = new Entry();
		Entry entry2 = new Entry();
		Entry entry3 = new Entry();
		entry3.setAnswered(true);

		entries.add(entry1);
		entries.add(entry2);
		entries.add(entry3);

		EntryContainer entryContainer = new EntryContainer(entries);

		assertEquals(2, entryContainer.nOpenQuestions());
	}

}
