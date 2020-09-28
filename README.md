# Slack Q&A Compiler 
### By Natalie Arellano & Mark Bender

### Overview
Our project for MCIT 591 uses the Slack API to automatically pull questions and answers from Slack to update a single reference document for MCIT students.

### Motivation

Students in 591 have many sources of information for assignments, one source being Slack. In the days leading up to an assignment due date, there are often many questions in the 591 Slack channel attempting to clarify certain aspects of the assignment. These are often interspersed with general banter, and it can be cumbersome to identify all the questions that have been asked about an assignment, along with their answers. The goal of this program is to collect the questions in one place, to give students an easy way of seeing what questions have been asked and which of these have been answered. 

### Functionality

When a student has a new question about an assignment, they can send a message in the channel directed to the homework bot, like so:

`@homework-bot Should we count blank values in our totals for question #5?`

The bot will record the question in a document, deriving the assignment number from the date that the question was asked.

Students can comment on the question by starting a thread. All responses in that thread will also be recorded by the bot.

When someone determines that a question has been answered, they can respond like so in the thread:

`@homework-bot This question is answered`

(Fuzzy matching is used here, so that as long as the response contains `@homework-bot` and `answer` the question will be marked as answered.)

Once a question has been answered, the bot will flag the question as answered and update the document accordingly. The bot will also ping the Slack channel with a link to download the document, so that students will then be able to access the most up-to-date information from Slack about the assignment.

See a video of the bot in action [here](https://drive.google.com/open?id=1eSxm5QZfF7H-puc8Tr_4ymE3QTyqjOwT)!

### CRC

We made several classes:

* **Runner** - the entry point to the program.
  * Responsibilities:
    * main()
  * Collaborators:
    * SlackSessionHandler
* **SlackSessionHandler** - establishes a connection with the Slack API. Sends and retrieves messages from Slack.
  * Responsibilities:
    * establish connection to Slack (happens in the constructor)
    * registerListener() - sets up code to run whenever a new message is received - note this handling happens in a separate thread of execution from main(); this was given to us by the library we were using, [simple-slack-api](https://github.com/Ullink/simple-slack-api). It's worth noting that each call to the handler blocks subsequent calls, so we didn't have to worry about two event handlers modifying the same data simultaneously!
  * Collaborators:
    * SlackMessageProcessor
* **SlackMessageProcessor** - given an incoming Slack message, decides what to do with it.
  * Responsibilities:
    * processMessage() - updates a Document object according to the data in the message and the data in the document, i.e. given a new Slack message:
      * If the message is a new question, create a new entry and add it to the document
      * If the message is a new response to an existing question, update the existing entry in the document.
    * Tells the DocEditor that it is time to write new data to the text document
    * Returns SlackDataToReturn back to the SlackSessionHandler
  * Collaborators:
    * DocEditor
    * Document
    * SlackSessionHandler
* **Document** - holds onto all the data we've received so far via a list of Entry objects.
  * Responsibilities:
    * Returns formatted data (e.g., getFullText())
  * Collaborators:
    * Entry
* **Entry** - an entry in a Document. Corresponds to a processed Slack message.
  * Responsibilities:
    * Returns formatted data (e.g., threadId, homeworkAssignment())
  * Collaborators:
* **DocEditor** - holds onto a Document object, and updates a text file with data from the Document.
  * Responsibilities:
    * Write data to a text file
    * Load data from an existing text file into memory (useful when we've already run the program and want to preserve history)
  * Collaborators:
    * Document
* **SlackDataToReturn** - a wrapper around data that Slack needs to send a message on behalf of the bot. This is returned by the SlackMessageProcessor to the SlackSessionHandler.
  * Responsibilities:
    * Hold structured data
  * Collaborators:

### Running the bot

Running the bot requires setting the environment variable `SLACK_API_TOKEN` in Eclipse - see instructions [here](https://stackoverflow.com/a/12810433).
