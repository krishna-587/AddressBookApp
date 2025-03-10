# 📒 Address Book App
A **Spring Boot**-based backend application for managing contact information, storing data in **MySQL**, and providing a RESTful API for seamless interaction.

---

## 🚀 Features
✔️ Add, update, delete, and retrieve contacts  
✔️ RESTful API endpoints for CRUD operations  
✔️ Integrated with **MySQL** for persistent data storage  
✔️ Structured project using **Spring Boot**  
✔️ Exception handling for better reliability  

---

## 🛠 Tech Stack
- **Java** (Spring Boot)  
- **Spring Data JPA** (Hibernate)  
- **MySQL** (Database)  
- **Spring Boot REST API**  
- **Lombok** (For cleaner code)  

---

## 📌 Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/krishna-587/AddressBookApp.git
cd AddressBookApp
```

### 2️⃣ Configure MySQL Database
- Create a MySQL database named `address_book_db`.
- Update **`application.properties`** (src/main/resources):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/address_book_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the Application
```sh
mvn spring-boot:run
```
The app will start at **http://localhost:8080** 🚀  

---

## 🎯 Future Enhancements
🚀 Add authentication & authorization (Spring Security)  
🚀 Implement pagination & sorting  
🚀 Deploy on cloud platforms  

---

## 🤝 Contributing
Contributions are welcome! Feel free to fork this repo and submit pull requests.  

---

## 📜 License
This project is licensed under the **MIT License**.  

🔗 **GitHub Repo:** [AddressBookApp](https://github.com/krishna-587/AddressBookApp)
