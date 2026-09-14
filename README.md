# Smart Campus Complaint & Maintenance Management System

## Overview
The Smart Campus Complaint & Maintenance Management System is a lightweight, easy-to-use Java application designed to track and manage campus infrastructure issues. Built entirely in Core Java, it allows students to report complaints, administrators to track and assign these tasks, and maintenance workers to mark them as resolved. The system operates natively in the console and relies on simple file-based serialization for data storage.

## Features
- **Role-Based Access:** Log in seamlessly as a Student, Admin, or Maintenance staff.
- **Complaint Logging:** Students can quickly create complaints with a title and description.
- **Complaint Assignment:** Admins can view all reported issues and assign them to specific maintenance workers.
- **Status Tracking:** Maintenance workers can view their specific tasks and mark them as `RESOLVED`.
- **Persistent Data Storage:** Data is automatically saved and loaded from a `.dat` file ensuring no data is lost between sessions.
- **Background Auto-Saving:** Utilizes basic Java Multithreading to save data in the background upon exit.

## Technologies/Tools Used
- **Language:** Core Java (JDK)
- **Data Structures:** Java Collections Framework (`ArrayList`, `List`)
- **Persistence:** Java File I/O Streams (`ObjectOutputStream`, `ObjectInputStream`)
- **IDE Support:** VS Code natively compatible (no Maven or build tools required)

## Steps to Install & Run the Project
1. **Prerequisites:** Ensure you have the Java Development Kit (JDK) installed on your system.
2. **Clone / Extract:** Open the `smart-campus-system` folder in Visual Studio Code.
3. **Compile the Code:**
   Open a terminal inside the `src/campus` folder and run:
   ```bash
   javac *.java
   ```
4. **Run the Application:**
   After compilation, start the system by running:
   ```bash
   java Main
   ```
   *(Alternatively, simply open `Main.java` in VS Code and click the "Run" button in the top right corner).*

## Instructions for Testing
To thoroughly test the application flow, follow these steps:
1. **Run the program** and choose `1` to log in as a **Student** (e.g., username "alice").
2. Select `1` from the Student Menu to **Create a new complaint** (e.g., "Broken AC in Room 101").
3. **Logout** (Choice `3`) and log back in as an **Admin** (e.g., username "admin").
4. Choose `1` to view all complaints, taking note of the Complaint ID.
5. Choose `2` to **Assign the complaint** to a maintenance worker (e.g., username "bob").
6. **Logout** and log in as **Maintenance** (username "bob").
7. Choose `1` to verify the complaint is assigned to you, then choose `2` to **Resolve** it.
8. **Exit the program** (Choice `4` from the login menu) to trigger the background save process. 
9. Relaunch the program; you will see the complaint data is perfectly preserved!
