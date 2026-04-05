# Spring Security – JWT Authentication & Authorization Flow

This project demonstrates how **Spring Security** works behind the scenes with **JWT (JSON Web Token)** for securing REST APIs.  
It covers the complete flow: generating a JWT token, validating it, extracting user details, and protecting endpoints using token-based authentication.

---

## 🚀 Features Implemented

### 🔐 **User Registration**
- Registers new users with encoded passwords (BCrypt).
- Saves user details in the database.

### 🔑 **User Login**
- Accepts email & password.
- Validates credentials using Spring Security.
- Generates a **JWT Access Token** on successful login.

### 🧾 **JWT Token Flow**
The project demonstrates:
- How JWT is created
- What data it contains
- How it is attached to requests
- How the filter validates the token before API access

### 🧱 **Custom Security Filter**
A custom `JwtAuthenticationFilter` is used to:
1. Extract token from the header  
2. Validate and parse the JWT  
3. Set authentication in the SecurityContext  


### 📡 **Protected API Endpoints**
- Example: `/api/user/**` requires a valid token.
- Unauthenticated requests are blocked with HTTP 401.

---

Client Login → Spring Authenticates User → JWT Issued →
Client Stores JWT → Sends token in Header →
Filter Validates Token → User Accesses Secured APIs



### 1️⃣ **User logs in**
- Sends email + password
- Credentials verified using `AuthenticationManager`

### 2️⃣ **JWT is generated**
- Contains userId, email, roles, issuedAt, expiration

### 3️⃣ **JWT sent back to client**
- Client must store it (localStorage / sessionStorage)

### 4️⃣ **Client sends token in every request**
Authorization: Bearer <token>

yaml
Copy code

### 5️⃣ **Filter checks & validates**
- Expiration  
- Signature  
- User details  

### 6️⃣ **If valid → request proceeds**
If invalid → 403 Unauthorized

---

## 📁 Project Structure

src/main/java/com/example/springsecurity/
│
├── controller/ # Auth and User controllers
├── service/ # JWT service, user service
├── filters/ # JWT Authentication Filter
├── repository/ # JPA Repositories
├── config/ # Security configurations
└── entity/ # User entity with roles

yaml
Copy code

---

## 🧪 API Endpoints

### **Register**
POST /auth/signup

markdown
Copy code

### **Login (Generates JWT)**
POST /auth/login


### **Access Protected Resource**
GET /api/user/profile
Authorization: Bearer <token>

---

## 🛠️ Technologies Used
- Spring Boot  
- Spring Security  
- JWT (jjwt library)  
- JPA / Hibernate  
- PostgreSQL / MySQL  
- ModelMapper  
- Maven / Gradle  

