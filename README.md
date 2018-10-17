# pProjects

In this repository are my most recent Portfolio-level Projects, hence "pProjects." The projects will be listed in chronological order with the newest versions of projects at the top and the project's name and commit date in italics.

<b>October 2018</b>

<i>A Game of Jeopardy! 0.4 - 10/16/18</i>

  The game of Jeopardy! now keeps the user's score throughout their experience, as well as pushing that score to a "Game Complete" page. Next, I will work on saving the user's score to the database and start working on a "spell check" feature. I will also work on limiting a user who has a final score in the negative to a consolation prize of $100 (if they get the Final Jeopardy question correct).

<i>A Game of Jeopardy! 0.3 - 10/15/18</i>

  I have figured out how to use JavaScript to hold onto the user's score through the rounds of Jeopardy. Next, I will be working on Final Jeopardy, which will allow the user to wager up to as many points as they have, as well as working on connecting the user's final score to the database.

<b>September 2018</b>

<i>A Game of Jeopardy! 0.2 - 9/18/18</i>

  This trivia game calls an API, http://jservice.io , and returns 25 questions each to a single and double Jeopardy! board. Basic auth along with a password encoder is used to keep track of players' data in a database. 

  On my second commit of this project, I have used JavaScript along with Thymeleaf to give the table that displays the Question Board the ability to remember which cell has been clicked on, and whether or not that particular cell's question has been answered. The score is remembered for the user (which is currently known as 'admin', that is to say that every user who creates an account is also an 'admin') throughout the 25 questions. The user can then click on "Go to Double Jeopardy!" and go to a round where the scores are doubled.

  Languages used: Java, Thymeleaf, SQL, HTML, CSS, JavaScript

<i>Issues:</i>

  • Spell Check
   - Some answers from the API include article adjectives, spaces, capitalization, ampersands and italic tags(e.g. '<i>The Shawshank Redemption</i>'). This makes a user's answer incorrect most of the time, even if the answer is the same in the user's mind. A solution for this could be to remove all article adjectives, spaces, capitaliztion and italic tags from both answers and then compare them. If a user's answer was actually right but spelled wrong, we could decide to only compare the first two and last characters of both answers while deleting article adjectives, spaces and other nuances.

  Nice to have:

  • 2 random 'daily doubles' per round 
  • A high score list