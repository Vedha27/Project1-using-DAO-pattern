# Project1-using-DAO-pattern# 
🧑‍💼 Employee Management System - JDBC DAO Project

A **Java-based console application** for managing employee records using **JDBC and DAO design pattern**. The project demonstrates how to build scalable and maintainable Java applications by separating business logic from data persistence.

---

## 📌 Features

- 🔍 View all employees
- ➕ Add a new employee
- ✏️ Update existing employee details
- ❌ Delete an employee
- 📄 Fetch employee by ID

---

## 🛠️ Technologies Used

| Technology     | Description                            |
|----------------|----------------------------------------|
| Java           | Core programming language              |
| JDBC           | Java Database Connectivity API         |
| MySQL          | Relational database                    |
| DAO Pattern    | To abstract and encapsulate DB logic   |
| JDBC Connector | `mysql-connector-java-x.x.xx.jar`      |

---

## 🧩 Project Structure

```plaintext
EmployeeManagementSystem/
├── src/
│   └── com/ems/
│       ├── model/
│       │   └── Employee.java
│       ├── dao/
│       │   ├── EmployeeDAO.java
│       │   └── EmployeeDAOImpl.java
│       ├── service/
│       │   └── EmployeeService.java
│       ├── util/
│       │   └── DBConnection.java
│       └── Main.java
├── lib/
│   └── mysql-connector-java-8.x.x.jar
├── README.md
└── employee_schema.sql
