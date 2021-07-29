## Portfolio Projects

In this repository are my most recent Portfolio-level Projects. The projects will be listed in chronological order with the newest versions of projects at the top and the project's name and commit date in italics.

<b>July 2021</b>

<i>A Game of Jeopardy! 0.7 - 7/28/2021</i>

  • Got the game online at: http://34.222.120.111:8080/jeopardy_v0.7/

  • Cleaned up the interface

  It's been a long time! I took a long break from programming to explore other things. I'm back.

  I have got an instance of my Jeopardy game working on AWS, using EC2 and RDS. The game runs on a Tomcat server. Finally you can play vintage Jeopardy to your heart's content. :)

  To do:

    • Make the spell check more robust, fixing the previously mentioned issues.

  Languages/Tools used: Java, Spring Boot, Tomcat, SQL, Hibernate, HTML, CSS, JavaScript, Thymeleaf

<b>October 2019</b>

<i>A Game of Jeopardy! 0.6 - 10/23/19</i>

  I have added a spell check, the Jaro-Winkler distance string metric, which measures an "edit distance" between two strings. The distance comes out as a percentage, 0% meaning two strings are far apart, 100% meaning they are the exact same. I have set the level of "Correctness" to 70%, meaning if someone gets an answer correct but misspells a letter or three, the game counts the user's answer as correct.
  
  To do: 
    
  • Remove article adjectives from the spell check and a user's answer for a more accurate comparison. Many answers from jService contain article adjectives and many do not when they seem like they should be there. This can also happen from the user's end, adding article adjectives when the game doesn't have them, resulting in a Jaro-Winkler distance under 70%, even if the user got an answer correct.
      - As a side note, some of the answers from jService have "italic tags" around book and movie titles, which also need to be removed.
    
  • Limit user who's final score is in the negative to a consolation prize of $100

<b>October 2018</b>

<i>A Game of Jeopardy! 0.5 - 10/31/18</i>

  The game now saves the user's high score to the database if it is above 0. 

  To do: Spell Check & Comparison | Limit user who's final score is in the negative to a consolation prize of $100

<i>A Game of Jeopardy! 0.4 - 10/16/18</i>

<b><i>Game Now Usable</i></b>

  The game of Jeopardy! now keeps the user's score throughout their experience, as well as pushing that score to a "Game Complete" page. Next, I will work on saving the user's score to the database and start working on a "spell check" feature. I will also work on limiting a user who has a final score in the negative to a consolation prize of $100 (if they get the Final Jeopardy question correct).

<i>A Game of Jeopardy! 0.3 - 10/15/18</i>

  I have figured out how to use JavaScript to hold onto the user's score through the rounds of Jeopardy. Next, I will be working on Final Jeopardy, which will allow the user to wager up to as many points as they have, as well as working on connecting the user's final score to the database.

<b>September 2018</b>

<i>A Game of Jeopardy! 0.2 - 9/18/18</i>

  This trivia game calls an API, http://jservice.io , and returns 25 questions each to a single and double Jeopardy! board. Basic auth along with a password encoder is used to keep track of players' data in a database. 

  On my second commit of this project, I have used JavaScript along with Thymeleaf to give the table that displays the Question Board the ability to remember which cell has been clicked on, and whether or not that particular cell's question has been answered. The score is remembered for the user throughout the 25 questions. The user can then click on "Go to Double Jeopardy!" and go to a round where the scores are doubled.

<i>Issues:</i>

  • Spell Check
   - Some answers from the API include article adjectives, spaces, capitalization, ampersands and italic tags(e.g. '<i>The Shawshank Redemption</i>'). This makes a user's answer incorrect most of the time, even if the answer is the same in the user's mind. A solution for this could be to remove all article adjectives, spaces, capitaliztion and italic tags from both answers and then compare them. If a user's answer was actually right but spelled wrong, we could decide to only compare the first two and last characters of both answers while deleting article adjectives, spaces and other nuances.

  Nice to have:

  • 2 random 'daily doubles' per round 
  • A high score list
