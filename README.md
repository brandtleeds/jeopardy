# pProjects

In this repository are my most recent Portfolio-level Projects, hence "pProjects." The projects will be listed in chronological order with the newest projects at the top.

October 2018

  10/15/18

  I have figured out how to use JavaScript to hold onto the user's score through the rounds of Jeopardy. Next, I will be working on
  Final Jeopardy which will allow the user to wager up to as many points as they have, as well as working on connecting the user's
  final score to the database.

September 2018

A Game of Jeopardy!

  This trivia game calls an API, http://jservice.io , and returns 25 questions each to a single and double Jeopardy! board. Basic auth along with a password encoder is used to keep track of players' data in a database. 

  9/18/18

  On my second commit of this project, I have used JavaScript along with Thymeleaf to give the table that displays the Question Board the ability to remember which cell has been clicked on, and whether or not that particular cell's question has been answered. The score is remembered for the user (which is currently known as 'admin', that is to say that every user who creates an account is also an 'admin') throughout the 25 questions. The user can then click on "Go to Double Jeopardy!" and go to a round where the scores are doubled.

  Issues:

  • Cannot return user_score from JavaScript to server-side model/database
   - Thymeleaf might not be the best way to go about creating this project. I can currently get the inlined JavaScript (in admin/game.html & admin/doubleJeopardy.html) to tally the score and disable table data cells from being answered twice, yet I cannot figure out how to return the final score of the round to the server-side model. This is a huge bug in the game because although a player can answer questions, their score cannot be saved.

  • Spell Check
   - Some answers from the API include article adjectives, spaces, capitalization and italic tags(e.g. '<i>The Shawshank Redemption</i>'). This makes a user's answer incorrect most of the time, even if the answer is the same in the user's mind. A solution for this could be to remove all article adjectives, spaces, capitaliztion and italic tags from both answers and then compare them. If a user's answer was actually right but spelled wrong, we could decide to only compare the first two and last characters of both answers.

  To Do:

  • Make finalJeopardy() in the GameService.

  Nice to have:

  • 2 random 'daily doubles' per round 
  • A high score list