# Task Tracker

A full-stack task management web application built with Spring Boot and Angular.

## 🚀 Features

- Create, read, update, and delete tasks
- Mark tasks as complete
- Project and due date management
- RESTful API backend
- Modern, responsive frontend interface

## 🛠️ Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **MySQL Database**
- **Maven**

### Frontend
- **Angular 19.1**
- **TypeScript**
- **RxJS**

## 📋 Prerequisites

- Java 17 or higher
- Node.js and npm
- MySQL Server
- Maven

## ⚙️ Installation & Setup

### Backend Setup

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd TaskTracker
   ```

2. Configure MySQL database:
   - Create a database named `tasktracker`
   - Update database credentials in `tasktracker/src/main/resources/application.properties`

3. Set the database password as an environment variable:
   ```bash
   # Windows PowerShell
   $env:DB_PASSWORD="your_password"
   
   # Linux/Mac
   export DB_PASSWORD="your_password"
   ```

4. Run the Spring Boot application:
   ```bash
   cd tasktracker
   mvn spring-boot:run
   ```

The backend API will be available at `http://localhost:8080`

### Frontend Setup

1. Navigate to the frontend directory:
   ```bash
   cd frontend/task-tracker-app
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   ng serve
   ```

The frontend will be available at `http://localhost:4200`

## 📁 Project Structure

```
TaskTracker/
├── tasktracker/                    # Spring Boot backend
│   ├── src/main/java/
│   │   └── com/example/tasktracker/
│   │       ├── Controller/         # REST controllers
│   │       ├── Model/              # JPA entities
│   │       ├── Service/            # Business logic
│   │       ├── Repo/               # Data repositories
│   │       ├── DTO/                # Data transfer objects
│   │       ├── Mapper/             # Entity-DTO mappers
│   │       └── Exceptions/         # Custom exceptions
│   └── src/main/resources/
│       └── application.properties  # Configuration
│
└── frontend/task-tracker-app/      # Angular frontend
    └── src/app/
        ├── models/                 # TypeScript interfaces
        ├── services/               # HTTP services
        └── task-list/              # Task list component
```

## 🔌 API Endpoints

- `GET /api/tasks` - Get all tasks
- `GET /api/tasks/{id}` - Get task by ID
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task
- `GET /api/projects` - Get all projects
- `GET /api/duedates` - Get all due dates


## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

Anna Dima

---

⭐ Star this repository if you find it helpful!
