# 🎟️ Ticket Booking System (Java + Gradle + JSON)

This is a basic **Java console application** designed to simulate a **Ticket Booking System**. It is built for learning and practicing:

- Core Java
- Project structure
- Gradle for build automation
- JSON file as a local database
- Password encryption
- Mapping camelCase to snake_case for JSON compatibility

---

## 🛠️ Features

- Sign up

- Login

- Fetch Bookings

- Search Trains

- Book a seat

- Cancel my Booking


---


---

## 🧰 Tech Stack

- **Java 17**
- **Gradle**
- **Jackson** – For reading/writing JSON
- **BCrypt** – For secure password hashing
- **Local JSON files** – Used as a mock database

---

## 🔐 Password Encryption

Passwords are hashed using **BCrypt**, ensuring they are not stored in plain text.  
Encryption is handled in the `UserServiceUtil` class using:


 ## Learning Goals

- Organize Java code using packages (model, service, util)

- Use JSON as a local storage alternative to databases

- Understand how to structure a basic CRUD Java app

- Learn Gradle build and dependency management

- Implement secure password storage using BCrypt

## 🚀 How to Run

### Using Terminal

```bash
git clone https://github.com/YOUR_USERNAME/ticket-booking-system.git
cd ticket-booking-system
./gradlew run
```


## 📈 Future Enhancements

- ✅ Add support for **Admin login** and **train management**.
- 🕒 Store timestamps using Java `LocalDateTime`.
- 📄 Export bookings as **PDF** files.
- 🗃️ Connect to an actual database (e.g., **SQLite** or **PostgreSQL**).
- 🧾 Add proper **logging** and **exception handling**.


