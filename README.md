# 🏅 SportEase — Sports Scheduling System

**SportEase** is a Java-based sports scheduling management system that simplifies organizing games, managing players, and generating daily match schedules.  
Built with **Object-Oriented Programming (OOP)** principles, it provides a structured and efficient way to plan and track sporting events.

---

## 🚀 Features
- 🧑‍🤝‍🧑 Add and manage players and teams  
- 🕒 Schedule and view daily games  
- ⚖️ Handle scheduling conflicts and invalid inputs  
- 🧩 Clean object-oriented structure with modular design  
- 🧪 Includes **JUnit** test cases for robust functionality validation  

---

## 🧩 Architecture Overview
The project follows a modular **Object-Oriented Architecture**, designed for scalability and reusability.

| Class | Description |
|--------|--------------|
| `Player` | Represents a player with attributes such as name and ID |
| `Game` | Stores details of each game like teams, time, and venue |
| `DaySchedule` | Manages all games for a specific day |
| `Schedular` | Central controller managing players, games, and day schedules |

---

## 🧠 Technical Concepts Used
- **Object-Oriented Programming (OOP)** – Abstraction, Encapsulation, Inheritance, Polymorphism  
- **Collections Framework** – Used `ArrayList`, `Set`, and `Map` for efficient data management  
- **Exception Handling** – Implemented custom exceptions and validations for user input  
- **Unit Testing** – Written using **JUnit** and **Hamcrest** for validation  
- **Iterative Development** – Continuous debugging, refactoring, and regression testing  

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the Repository
git clone https://github.com/YOUR-USERNAME/SportEase.git
cd SportEase

### 2️⃣ Compile the Source Files
javac -d bin src/schedular/*.java

### 3️⃣ Run the Application
java -cp bin schedular.Schedular

### 4️⃣ Run Unit Tests (Optional)

Make sure JUnit is configured properly, then run:

java -cp "bin;lib/junit.jar;lib/hamcrest.jar" org.junit.runner.JUnitCore schedular.TestSchedular

### 🧰 Tools & Technologies

- Language: Java
- IDE: Eclipse
- Testing: JUnit 4, Hamcrest
- Version Control: Git & GitHub

### 🧪 Testing Approach

- Designed and executed JUnit test cases to validate core logic.
- Used assertions for correctness and boundary checks.
- Performed regression testing after each major update to ensure stability.

### ⚡ Debugging Process

- Used stack traces to identify runtime issues.
- Followed iterative debugging — isolate, fix, and retest.
- Managed dependency issues and resolved compilation errors.

### 🧩 Future Enhancements

- 🌐 Add a GUI or web-based interface for scheduling.
- 📊 Track player stats and match histories.
- 📅 Enable schedule export in PDF or calendar format.
- 🕹️ Add admin and viewer roles for access control.
