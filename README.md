# Simple-Tower-Defense

## Demo 


## Code Details

  Game: The JFrame of whole view and running the game.
  GameCourt: The JPanel of game court. Also, shows winning or lossing.
  GameGuide: The JFrame of game guide.
  Navbar: the JPanel to start and reset the game and access game guide.
  ToolBar: The JPanel to build and sell towers.
  Records: The JPanel that shows game level, player's health and money.

  Direction: enum with four directions.
  Status: enum with three status: begin, lose, win, reset.

  Player: records player data (health, money, player status).

  Map: records map data (map data, map image, coordinates and position).

  Tower: The abstract class of tower.
  Tower1: tower1 which targets and attacks a single enemy.
  Tower2: tower2 which targets and attacks all enemies in its attack range.
  Towers: record data of towers in the game. Also, methods to buy, sell, and
          update towers' targeted enemies are in this class.

  Bullet: Abstract class of bullets.
  Bullet1: Bullet that target one enemy.
  Bullet2: Bullet that target all enemies in attack range.

  Enemy: Abstract class of enemies.
  Enemy1: The only type of enemy.
  Enemies: Record data of enemies in the game. Updating enemies' poistion and 
  health. Set different groups of enemies for different game level.

  JUnit Tests of the game
    Enemy1Test
    MapTest
    Tower1Test
    Tower2Test
