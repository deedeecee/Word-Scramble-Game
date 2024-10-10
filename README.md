# Word-Scramble-Game
The Word Scramble Game is a fun and interactive game built using Spring Boot. The objective is for a player to guess a randomly chosen word whose letters have been scrambled. Players are given 3 attempts to guess the word, and with each incorrect guess, the game reveals part of the original word as a hint. If the player is unable to guess the word after the final attempt, the complete word is displayed.

## Features
- A random word is selected from the word repository and its letters are scrambled.
- Players have 3 attempts to guess the word.
- After each incorrect attempt, the game reveals a few of the starting characters of the word to provide a hint.
- If the player fails to guess the word in 3 attempts, the complete word is revealed.
- The game is implemented using Spring Boot with a clean, RESTful API structure.

## Technologies Used
- **Java 17+**
- **Spring Boot 3+**
- **Maven** as the build tool
- **JUnit** for unit testing
- **Lombok** to reduce boilerplate code
- **Spring Data JPA** for word repository management

## Future Enhancements
- **Add a scoreboard** to track players' performance.
- Implement a **difficulty level** with varying word lengths.
- Improve the **web UI** using technologies like **Thymeleaf** or **React**.
- Enhance the **word repository** by integrating with an external dictionary API.

## Preview
![image](https://github.com/user-attachments/assets/52443675-97ef-4c77-9d4b-d126cfc5ebc9)
