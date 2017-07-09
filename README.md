# BlackJack

This program emulates a simple version of the BlackJack Game.

**Rules**

Rules followed for the implementation:
1. Each player gets two cards initially. 
2. Scoring points are assigned as it is in the actual game.
3. For each round, each player can choose to “hit” or “stay”.
4. If the players chooses to hit, calculate the sum of cards in his hand. If it exceeds 21, he/she loses.Else, other player 
   continues.
5. This project assumes that both the players do not continue to choose "Stay" indefinitely.
6. As soon as the player exceeds 21, the other player wins the game.
7. The case in the actual game, where the person who has the closest sum to 21 wins the game is not considered as there are 
   only two players ).
8. Only 1 deck of cards is considered rather than multiple decks.
9. For the sake of simplicity, the second player's card(opponent) is not hidden while printing in order to better 
   understand how the game is progressing. 
10.In order to view the player's hands after every turn, feel free to uncomment the line *74/75/95/96*.
11.In case of an invalid input character, the user will skip the next turn of the other player in order to continue with a 
   fair game. 
