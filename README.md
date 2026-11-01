
# Aydin Qazi's CS Tools Final Project (Java Procedrual Dungeon Crawler)

## Project Overview

This project is a procedurally generated, turn-based dungeon crawler developed primarily using Java's standard library. Each playthrough will generate a randomized dungeon containing rooms, corridors, enemies, and an exit.

The player must navigate the dungeon, interact with enemies through basic combat, and reach the exit before running out of health.

The goal of this project is to develop a functional game while gaining experience with object-oriented programming, procedural generation, collision detection, enemy AI, and game state management.

## Minimum Viable Product (MVP)

The first version will include:

1. **Procedural Dungeon Generation:** Generate randomized rooms and corridors that form a navigable dungeon.
2. **Player Movement:** Allow movement using WASD commands, with collision detection to prevent movement through walls.
3. **Enemy Interaction:** Implement basic enemy movement, health, and turn-based combat.
4. **Win/Loss Conditions:** The player wins by reaching the exit and loses when their health reaches zero.
5. **Terminal Interface:** Display the dungeon, enemies, player, and relevant information using ASCII characters.

## Future Plans (V2.0+)

After the MVP is complete, potential improvements include:

- **Graphical User Interface:** Replace terminal output with a dedicated graphical application.
- **Sprites and Animations:** Introduce visual representations of characters, enemies, and dungeon environments.
- **Continuous Game Loop:** Add real-time keyboard input and game updates without requiring Enter after each command.
- **Advanced Enemy AI:** Improve enemy navigation through more sophisticated pathfinding algorithms.

### Features Outside Project Scope

The following features will not be implemented as part of the current project:

- Multiplayer functionality
- Character progression, leveling, and skill trees
- Save states and loading previous sessions
- Inventory, equipment, and crafting systems

## Tech Stack

### Programming Language
- **Java 21**

### Libraries and Utilities
- `java.util.Random` — Random number generation for procedural dungeons.
- `java.util.ArrayList` — Storage and management of enemies, rooms, and other game objects.
- `java.util.Scanner` — Reading player input from the terminal.
- `java.lang.System` — Printing game information and the dungeon to the terminal.
- **JUnit (optional)** — Automated testing of game mechanics.

### Development Tools
- Visual Studio Code with Java extensions
- Git and GitHub for version control
- Java Development Kit (JDK) 21

### Data Storage
- A two-dimensional array will represent the dungeon map.
- Java objects and collections will store player attributes, enemy information, and game state.
- All information will be stored in memory during gameplay.
- No database or persistent storage is required for the MVP.

### External Data Sources
None. The game will operate entirely offline without external APIs, web services, or internet connectivity.

## Development Milestones

1. **Project Setup:** Initialize the Git repository and establish the project structure.
2. **Map Representation:** Implement a two-dimensional dungeon map and terminal rendering.
3. **Player Movement:** Implement keyboard movement and collision detection.
4. **Procedural Generation:** Generate randomized rooms and connecting corridors.
5. **Entity Placement:** Implement player spawning, enemy spawning, and exit placement.
6. **Enemy AI:** Implement basic enemy movement and turn-based behavior.
7. **Combat:** Implement player/enemy health and combat mechanics.
8. **Game Completion:** Implement win/loss conditions and game restarting.
9. **Testing and Documentation:** Test game mechanics, fix bugs, and finalize the MVP.
