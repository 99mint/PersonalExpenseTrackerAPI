# Personal Expense Tracker API 💰

A RESTful API built with Spring Boot for tracking and managing daily expenses. This project helps you monitor your spending habits by categorizing expenses and providing insights into your financial activities.

## ✨ Features

- ✅ Add new expenses with amount, category, date, and description
- ✅ Retrieve all expenses
- ✅ Filter expenses by date range
- ✅ Filter expenses by category
- ✅ Update existing expenses
- ✅ Delete expenses
- ✅ Calculate total spending by category

## 🛠️ Tech Stack

- **Backend Framework:** Spring Boot 3.x
- **Language:** Java 17+
- **Database:** MySQL
- **Build Tool:** Maven
- **API Testing:** Postman
- **ORM:** Spring Data JPA (Hibernate)

## 📦 Prerequisites

Before running this project, make sure you have:

- Java JDK 17 or higher installed
- MySQL 8.0+ installed and running
- Maven 3.6+ installed
- Postman (for API testing)
- Your favorite IDE (IntelliJ IDEA, Eclipse, VS Code)

## 🚀 Installation

### 1. Clone the Repository

```bash
git clone https://github.com/99mint/personal-expense-tracker-api.git
cd personal-expense-tracker-api
```

### 2. Create MySQL Database

```sql
CREATE DATABASE expense_tracker;
```

### 3. Configure Database Connection

Create `src/main/resources/application.properties`:

```properties
spring.application.name=personal-expense-tracker-api

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasou[application-example.properties](src/main/resources/application-example.properties)rce.password=your_password_here

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Server Configuration
server.port=8080
```

### 4. Build the Project

```bash
mvn clean install
```

### 5. Run the Application

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

### Base URL
```
http://localhost:8080/api/expenses
```

### Endpoints Overview

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/expenses` | Add a new expense |
| GET | `/api/expenses` | Get all expenses |
| GET | `/api/expenses/date-range/{startDate}/{endDate}` | Get expenses by date range |
| GET | `/api/expenses/category/{category}` | Get expenses by category |
| GET | `/api/expenses/category/{category}/total` | Get total spending by category |
| PATCH | `/api/expenses/{id}` | Update an expense |
| DELETE | `/api/expenses/{id}` | Delete an expense |

## 📝 Request/Response Examples

### 1. Add an Expense

**Endpoint:** `POST /api/expenses`

**Request Body:**
```json
{
  "amount": 150.50,
  "category": "FOOD",
  "date": "2024-02-03",
  "description": "Lunch at restaurant"
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "amount": 150.50,
  "category": "FOOD",
  "date": "2024-02-03",
  "description": "Lunch at restaurant"
}
```

### 2. Get All Expenses

**Endpoint:** `GET /api/expenses`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "amount": 150.50,
    "category": "FOOD",
    "date": "2024-02-03",
    "description": "Lunch at restaurant"
  },
  {
    "id": 2,
    "amount": 50.00,
    "category": "TRANSPORT",
    "date": "2024-02-03",
    "description": "Uber ride"
  }
]
```

### 3. Get Expenses by Date Range

**Endpoint:** `GET /api/expenses/date-range/2024-02-01/2024-02-05`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "amount": 150.50,
    "category": "FOOD",
    "date": "2024-02-03",
    "description": "Lunch at restaurant"
  }
]
```

### 4. Get Expenses by Category

**Endpoint:** `GET /api/expenses/category/FOOD`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "amount": 150.50,
    "category": "FOOD",
    "date": "2024-02-03",
    "description": "Lunch at restaurant"
  },
  {
    "id": 5,
    "amount": 200.00,
    "category": "FOOD",
    "date": "2024-02-04",
    "description": "Grocery shopping"
  }
]
```

### 5. Get Total Spending by Category

**Endpoint:** `GET /api/expenses/category/FOOD/total`

**Response:** `200 OK`
```json
350.50
```

### 6. Update an Expense

**Endpoint:** `PATCH /api/expenses/1`

**Request Body:**
```json
{
  "amount": 175.00,
  "description": "Updated: Dinner at restaurant"
}
```

**Response:** `200 OK`
```json
{
  "id": 1,
  "amount": 175.00,
  "category": "FOOD",
  "date": "2024-02-03",
  "description": "Updated: Dinner at restaurant"
}
```

### 7. Delete an Expense

**Endpoint:** `DELETE /api/expenses/1`

**Response:** `204 No Content`

## 🧪 Testing with Postman

### Import Postman Collection

1. Open Postman
2. Click "Import" button
3. Create a new collection named "Expense Tracker API"
4. Add the following requests:

#### Example Request Setup

**Add Expense:**
- Method: POST
- URL: `http://localhost:8080/api/expenses`
- Headers: `Content-Type: application/json`
- Body (raw JSON):
```json
{
  "amount": 150.50,
  "category": "FOOD",
  "date": "2024-02-03",
  "description": "Lunch at restaurant"
}
```

**Get All Expenses:**
- Method: GET
- URL: `http://localhost:8080/api/expenses`

**Get by Date Range:**
- Method: GET
- URL: `http://localhost:8080/api/expenses/date-range/2024-02-01/2024-02-05`

**Get by Category:**
- Method: GET
- URL: `http://localhost:8080/api/expenses/category/FOOD`

**Get Total by Category:**
- Method: GET
- URL: `http://localhost:8080/api/expenses/category/FOOD/total`

**Update Expense:**
- Method: PATCH
- URL: `http://localhost:8080/api/expenses/1`
- Body (raw JSON):
```json
{
  "amount": 175.00
}
```

**Delete Expense:**
- Method: DELETE
- URL: `http://localhost:8080/api/expenses/1`

## 📁 Project Structure

```
personal-expense-tracker-api/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mint/personal_expense_tracker_api/
│   │   │       ├── controller/
│   │   │       │   └── ExpenseController.java
│   │   │       ├── service/
│   │   │       │   └── ExpenseService.java
│   │   │       ├── repository/
│   │   │       │   └── ExpenseRepository.java
│   │   │       ├── entity/
│   │   │       │   └── Expense.java
│   │   │       └── PersonalExpenseTrackerApiApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│       └── java/
│
├── pom.xml
└── README.md
```

## 🎯 Learning Outcomes

By building this project, you'll learn:

- ✅ RESTful API design principles
- ✅ Spring Boot application structure
- ✅ CRUD operations with Spring Data JPA
- ✅ MySQL database integration
- ✅ Request mapping and path variables
- ✅ Enum usage in Java
- ✅ Date handling with LocalDate
- ✅ BigDecimal for precise financial calculations
- ✅ API testing with Postman

## 🐛 Troubleshooting

### Common Issues

**1. Database Connection Error**
```
Error: Access denied for user 'root'@'localhost'
```
**Solution:** Check your MySQL username and password in `application.properties`

**2. Port Already in Use**
```
Error: Port 8080 is already in use
```
**Solution:** Change the port in `application.properties`:
```properties
server.port=8081
```

**3. Table Not Created**
```
Error: Table 'expense_tracker.expense' doesn't exist
```
**Solution:** Make sure `spring.jpa.hibernate.ddl-auto=update` is set in properties file

## 🚀 Future Enhancements

- [ ] Add user authentication (JWT)
- [ ] Implement pagination for large datasets
- [ ] Add expense statistics and analytics
- [ ] Create monthly/yearly spending reports
- [ ] Add budget limits and alerts
- [ ] Implement expense tags
- [ ] Add currency conversion support
- [ ] Create a frontend UI (React/Angular)

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Your Name**
- GitHub: https://github.com/99mint
- LinkedIn: www.linkedin.com/in/abhay-rajput-081927360

## 🙏 Acknowledgments

- Spring Boot Documentation
- Spring Data JPA Guide
- MySQL Documentation
- RESTful API Best Practices

---

**Happy Coding! 🎉**

If you found this project helpful, please give it a ⭐️!
