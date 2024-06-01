# Snake and Ladder Game

This is a Java implementation of the classic Snake and Ladder game.

## Getting Started

1. **Prerequisites**: Java Development Kit (JDK) installed.
2. **Clone**: Clone this repository to your local machine.
3. **Config**: Adjust game settings in `config.yml`.
4. **Run**: Execute `Main.java` to start the game.

## Design Patterns and principles used

Strategy Pattern

- In our provided code, the Strategy Pattern is used in the MovementStrategy interface and its implementations (
  SumStrategy, MaxStrategy, MinStrategy)

Dependency Injection

- The SnakeAndLadder class uses the DiceRoller interface as a dependency. This allows for flexibility and decoupling, as
- SnakeAndLadder isn't concerned with the specifics of how the dice are
  rolled; it just relies on the DiceRoller interface.

Polymorphism (as principle) :

- This has helped us to unify all boardElements like snakes,ladders,mines and crocodiles. And addition of new types will
  not have huge impact on the code base.

ISP- Interface segregation principle(future scope):

- This could've been used for ActionElements so that not all classes need to implement every method.

## Game Configuration

The game configuration is specified in the `config.yml` file. This file allows you to customize various aspects of the
game, such as the board size, the number of snakes and ladders, the movement strategy, the number of dice used for
rolling, and the initial positions of players.

### Parameters

- **boardSize**: Specifies the size of the game board. For example, `10` represents a 10x10 board.

- **numberOfSnakes**: Indicates the number of snakes present on the board.

- **numberOfLadders**: Indicates the number of ladders present on the board.

- **movementStrategy**: Defines the strategy used for calculating dice roll outcomes. Strategies include SUM, MAX, and
  MIN.

- **numberOfDice**: Specifies the number of dice used for rolling. For example, `1` indicates a single die.

- **snakes**: Provides the positions of snakes and their corresponding tails on the board. Each entry represents a
  snake's head and tail position.

- **ladders**: Provides the positions of ladders and their corresponding tops on the board. Each entry represents a
  ladder's bottom and top position.

- **crocodiles**: (Not used in the provided implementation) Specifies the positions of crocodiles on the board.

- **mines**: (Not used in the provided implementation) Specifies the positions of mines on the board.

- **players**: Lists the players participating in the game along with their initial positions on the board.

## Customization

- Extend the game by adding new elements or modifying logic.
