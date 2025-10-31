# 🧾 Complaint Registration & Resolution System

A **console-based Java application** designed to manage user complaints efficiently with separate roles for **Users** and **Admins**.  
Users can file and track complaints, while Admins can view, update, and manage all complaints in the system.

---

## 🧩 Overview

The **Complaint Registration & Resolution System** allows users to log in, file complaints, and view their complaint status.  
Admins have additional privileges to view all complaints, update their statuses, and manage users.

This project demonstrates **Object-Oriented Programming (OOP)** principles such as:
- Encapsulation  
- Abstraction  
- Modularity  
- Class interaction and reusability  

This project was developed as part of learning **Java and OOP concepts** and simulates a simple complaint management workflow in a real-world environment.

---

## 🚀 Features

### 👤 User Module
- Login with valid credentials  
- File a new complaint  
- View complaints filed by the user  
- Logout securely  

### 🛠️ Admin Module
- Login as Admin  
- View all complaints  
- Update complaint status (`PENDING`, `IN_PROGRESS`, `RESOLVED`)  
- Add new users (with `USER` or `ADMIN` roles)  
- Logout  

### 🧱 Other Highlights
- Uses **ArrayList** for complaint and user management  
- Menu-driven **console-based UI**  
- Modularized code with well-defined classes  
- Thread-safe complaint registration using `synchronized` method  

---

## 🖥️ Tech Stack

| Component | Technology |
|------------|-------------|
| **Programming Language** | Java (JDK 8 or above) |
| **Framework/Library** | None (Core Java) |
| **IDE Used** | Eclipse / IntelliJ IDEA / VS Code |
| **Database** | In-memory storage using Lists |
| **Execution** | Command-line / Terminal |

---

## 📂 Project Structure
ComplaintBox/
│

├── MainApp.java

├── LoginManager.java   ## Manages user login and credentials

├── User.java  ## Represents a user entity (USER/ADMIN)

├── Complaint.java ## Represents a complaint entity

├── ComplaintManager.java ## Handles complaint creation and updates

├── UserService.java ## Defines actions available for normal users

├── AdminService.java # #Defines actions available for administrators

└── README.md ## Project documentation


---
## Output 
Screenshot
<img width="1662" height="927" alt="image" src="https://github.com/user-attachments/assets/770e6510-9b7f-42c2-8dca-869eccebc0a2" />


## ⚙️ How to Run

### Step 1: Clone the Repository
```bash
git clone https://github.com/<your-username>/ComplaintBox.git
```
### Step 2: Navigate to the Source Directory
cd ComplaintBox/src

### Step 3: Compile the Java Files
javac *.java

### Step 4: Run the Application
java MainApp

## 🔮 Future Improvements

✅ Add database connectivity (MySQL or PostgreSQL)

✅ Implement GUI (JavaFX / Swing)

✅ Encrypt passwords for better security

✅ Add timestamps for each complaint

✅ Add complaint categories and search functionality

✅ Export complaints as CSV or PDF reports

✅ Add notification/email system for updates

🧑‍💻 Author

Prity Kumari
🎓 B.Tech in Computer Science

💼 Aspiring Software Developer

📧 [prity.mini3110@gmail.com]
