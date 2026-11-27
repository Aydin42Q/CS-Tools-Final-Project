# Aydin Qazi's CS Tools Final Project (Java Chess Roguelike Dungeon Crawler)

## Project Overview

This project is a chess-inspired, turn-based roguelike dungeon crawler developed primarily using Java's standard library. The player controls the Vagabond (`V`), who moves like a chess King and must clear each board by defeating all the enemies.

Each board contains obstacles and enemies based on chess pieces. Enemies follow their respective movement patterns and have different cooldowns between turns. The player must avoid enemy attacks, capture enemy pieces, and manage a limited number of body doubles to survive.

The goal of this project is to create a functional strategy game while gaining experience with object-oriented programming, collision detection, enemy AI, turn-based combat, and game state management.

## Changes from Original Plan

The project was originally planned as a procedurally generated dungeon crawler where the player would explore rooms and corridors, fight enemies, and find an exit.

I decided to change the game into a chess-themed roguelike dungeon crawler, where each level is a chess board that the player must clear before moving on.

The main changes are:

- **Level Design:** Instead of rooms and corridors, levels will consist of chess-style boards with obstacles and enemies.
- **Player Movement:** The player now controls the Vagabond, who moves like a chess King.
- **Objective:** Rather than finding an exit, the player must capture every enemy on the board.
- **Enemies:** Enemies are based on chess pieces and move according to their respective rules, with cooldowns determining how often they can act.
- **Combat:** Instead of a traditional health system, the player has three body doubles that act as lives. When an enemy captures the player, it sacrifices itself and removes one body double.
- **Check:** Enemies can put the player in check, even while on cooldown. Unlike normal chess, the player can move into check or stay there.
- **Procedural Generation:** Random board generation has been moved to a later version so I can focus on getting the basic game working first.

Although the gameplay has changed, much of the original project still applies. The board representation and terminal display can still be used, and the project will continue to focus on enemy AI, collision detection, and object-oriented programming.

## Minimum Viable Product (MVP)

The first version will include:

1. **Board Representation:** Display a chess-style board containing obstacles, enemies, and the player using ASCII characters.
2. **Player Movement:** Allow the Vagabond to move like a chess King using terminal commands, while preventing movement outside the board or through obstacles.
3. **Enemy Movement:** Implement chess-based movement patterns and individual turn cooldowns for enemies.
4. **Combat:** Allow the player to capture enemies instantly. Enemies that successfully capture the player will remove one body double and sacrifice themselves.
5. **Check System:** Detect when the player is in check, while still allowing movement into or through threatened positions.
6. **Win/Loss Conditions:** The player clears the board by eliminating all enemies and loses when captured without any body doubles remaining.
7. **Terminal Interface:** Display the board and relevant game information while accepting player inputs.

The MVP will focus on making a single board fully playable before adding randomized levels and upgrades.

### Enemy Types

Enemies will be based on traditional chess pieces, with some changes to their movement and behavior.

| Enemy | Movement | Action Frequency |
|---|---|---|
| Page | One square horizontally or diagonally | Every turn |
| Knight | Standard chess Knight movement | Every turn |
| Bishop | Standard diagonal movement | Every 2 turns |
| Rook | Standard horizontal/vertical movement | Every 2 turns |
| Queen | Combined Bishop and Rook movement | Every 3 turns |

Each enemy will have its own cooldown determining when it can move.

Enemies can still put the player in check while on cooldown, but they cannot capture the player until they are able to act again.

### Combat Mechanics

Combat will use a combination of chess captures and a limited number of lives.

- The Vagabond starts with three body doubles.
- Moving onto an enemy's square captures it immediately.
- When an enemy captures the Vagabond, the enemy is removed and one body double is lost.
- If the Vagabond is captured with no body doubles remaining, the game ends.
- All enemies can put the Vagabond in check based on their movement patterns.
- Being in check does not cause damage by itself.
- The player can choose to remain in check, potentially sacrificing a body double to remove a dangerous enemy.

## Future Plans (V2.0+)

After the MVP is complete, potential improvements include:

- **Procedural Board Generation:** Generate boards of different sizes with randomized obstacles and enemy placements.
- **Roguelike Progression:** Add multiple levels with increasing difficulty and different enemy arrangements.
- **Player Upgrades:** Allow the Vagabond to gain abilities between boards, such as moving twice as far while in check.
- **Advanced Enemy AI:** Improve enemy movement and decision-making.
- **Graphical User Interface:** Replace the terminal display with a dedicated graphical application.
- **Sprites and Animations:** Add visual representations of the player, enemies, and board.

### Features Outside Project Scope

The following features will not be implemented as part of the current project:

- Multiplayer functionality
- Permanent character leveling and skill trees
- Save states and loading previous sessions
- Inventory, equipment, and crafting systems

## Tech Stack

### Programming Language
- **Java 25**

### Libraries and Utilities
- `java.util.Random` — Random number generation for future board layouts and enemy placement.
- `java.util.ArrayList` — Storage and management of enemies and other game objects.
- `java.util.Scanner` — Reading player input from the terminal.
- `java.lang.System` — Printing the board and game information to the terminal.

### Development Tools
- Visual Studio Code with Java extensions
- Git and GitHub for version control
- Java Development Kit (JDK) 21

### Data Storage
- A two-dimensional array will represent the game board.
- Java objects and collections will store player information, enemies, cooldowns, and other game data.
- All information will be stored in memory during gameplay.
- No database or persistent storage is required for the MVP.

### External Data Sources

None. The game will operate entirely offline without external APIs, web services, or internet connectivity.

## Development Milestones

1. **Project Setup:** Initialize the Git repository and establish the project structure.
2. **Board Representation:** Implement a two-dimensional board and terminal rendering using ASCII characters.
3. **Player Movement:** Implement Vagabond movement, terminal input, and collision detection.
4. **Enemy Placement:** Implement enemy spawning and placement on valid board tiles.
5. **Enemy Movement:** Implement chess-based movement patterns, turn-based behavior, and individual cooldowns.
6. **Combat and Check:** Implement captures, body doubles, and detection of threatened positions.
7. **Game Completion:** Implement win/loss conditions and game restarting.
8. **Testing and Documentation:** Test game mechanics, fix bugs, and finalize the MVP.

Procedural generation, upgrades, and other roguelike features will be added after the basic game is working.