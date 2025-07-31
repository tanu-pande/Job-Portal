# 💼 Job Portal System

A simple web-based Job Portal System where employers can post job openings and applicants can view and apply for jobs.

## 🚀 Features

- 🔐 User login (with dummy authentication for demo)
- 📝 Register new users
- 🖥️ Admin dashboard
- 📄 Post a new job
- 📃 View all job listings
- 📬 Apply for a job
- 📁 View submitted applications
- 📋 View registered users (dummy page)

## 🛠️ Built With

- **Java 17**
- **Spring Boot 3.5.4**
- **Spring MVC + Thymeleaf**
- **Spring Data JPA**
- **MySQL**
- **Maven**

## 📂 Project Structure

jobportal/
├── src/
│ └── main/
│ ├── java/com/example/jobportal/
│ │ ├── controller/
│ │ ├── model/
│ │ └── repository/
│ └── resources/
│ ├── templates/
│ │ ├── home.html
│ │ ├── login.html
│ │ ├── register.html
│ │ ├── dashboard.html
│ │ ├── jobs.html
│ │ ├── post_job.html
│ │ ├── apply_form.html
│ │ ├── apply_success.html
│ │ ├── applications.html
│ │ └── users.html
│ └── application.properties
└── pom.xml


## ⚙️ Setup Instructions

1. Clone the repository:


git clone https://github.com/your-username/jobportal.git
cd jobportal

2.Create a MySQL database:
sql
CREATE DATABASE jobportal;

3.Configure your MySQL credentials in src/main/resources/application.properties:
properties
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

4.Run the application:
mvn spring-boot:run
Visit in your browser:

5.arduino
http://localhost:8080
| *Page*     | *URL*                                                                  |
| ------------ | ------------------------------------------------------------------------ |
| Home         | [http://localhost:8080/](http://localhost:8080/)                         |
| Login        | [http://localhost:8080/login](http://localhost:8080/login)               |
| Dashboard    | [http://localhost:8080/dashboard](http://localhost:8080/dashboard)       |
| View Jobs    | [http://localhost:8080/jobs](http://localhost:8080/jobs)                 |
| Post a Job   | [http://localhost:8080/jobs/new](http://localhost:8080/jobs/new)         |
| Applications | [http://localhost:8080/applications](http://localhost:8080/applications) |

📸 Screenshots:
![image alt](https://github.com/tanu-pande/Job-Portal/blob/6694cd5f37310808a6c15199372e61bd653f963d/Screenshot%202025-08-01%20010059.png)
![image alt](https://github.com/tanu-pande/Job-Portal/blob/89382ed56216595f93299c80c2cca86bc935f7ba/Screenshot%202025-08-01%20010128.png)
![image alt]()
![image alt]()
![image alt]()
