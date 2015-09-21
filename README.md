# bolGame
The bol.com Game

## Prerequisites

- Apache Maven 3.x
- Java JDK

## Game Rules

Rules
Game Play
The player who begins with the first move picks up all the stones in anyone of his own six pits, and sows the stones on to the right, one in each of the following pits, including his own big pit. No stones are put in the opponents' big pit. If the player's last stone lands in his own big pit, he gets another turn. This can be repeated several times before it's the other player's turn.

Capturing Stones
During the game the pits are emptied on both sides. Always when the last stone lands in an own empty pit, the player captures his own stone and all stones in the opposite pit (the other players' pit) and puts them in his own pit.


The Game Ends
The game is over as soon as one of the sides run out of stones. The player who still has stones in his pits keeps them and puts them in his/hers big pit. Winner of the game is the player who has the most stones in his big pit.

## Usage

- git clone https://github.com/aslanbekirov/bolGame.git
- cd  bolGame 
- mvn clean package 
- java -cp target/BolGame.jar com.bol.test.Main 

Enjoy the Game :))
