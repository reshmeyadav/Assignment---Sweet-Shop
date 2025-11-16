# 🍬 Sweet Shop Application

A full-stack Sweet Shop management and browsing platform built using **React (frontend)** and **Spring Boot (backend)** with **PostgreSQL** hosted on **Neon**.  
This application allows users to browse sweets, filter by price/category, search, and perform admin CRUD operations.

---

## Live Preview

Try out **Sweet Shop** using the links and demo credentials below:

### 🔗 Application Links

- **Live Portal:** [https://sweet-shop-voltrex.netlify.app/](https://sweet-shop-voltrex.netlify.app/)
> ⚠️ **Note:** This project is hosted on a free cloud service.  
> The server may take a few seconds to "wake up" on the first request, so you might experience some initial latency.

### 🧑‍💼 Demo credentials

- **Admin:** admin
- **Password:** admin1234

- **Demo User:** shadow_voltrex
- **Password:** 12345678

- **Frontend Repository Link:** [https://github.com/reshmeyadav/SweetShop-Frontend](https://github.com/reshmeyadav/SweetShop-Frontend)

---

# 🧩 Features

### 👥 User Features
- Browse all sweets  
- Search sweets by name  
- Filter by category  
- Filter by minimum/maximum price  
- View sweet details  
- Fully responsive UI  

### 🛠️ Admin Features
- Add new sweets  
- Update sweets  
- Delete sweets  
- Input validation  
- Secure JWT-based authentication  

### 🔐 Security
- Spring Security 6  
- JWT Authentication  
- Role-based Access Control (`ROLE_USER`, `ROLE_ADMIN`)  

### 🗄️ Database
- PostgreSQL  
- Hosted on **Neon DB**  
- Managed using JPA/Hibernate  

---

# ⚙️ Tech Stack

### **Frontend**
- React  
- Vite  
- Tailwind CSS  
- Axios  
- Netlify Deployment  

### **Backend**
- Java 21  
- Spring Boot  
- Spring Security + JWT  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Render Deployment  

### **Database**
- Neon PostgreSQL Cloud

---

# 📦 Backend Setup

1. Clone the backend repository:
```
git clone https://github.com/reshmeyadav/SweetShop.git
````

2. Add .env File:
```
DATABASE_URL=""
DATABASE_USERNAME=""
DATABASE_PASSWORD=""
JWT_SECRET_KEY=""
JWT_EXPIRATION=""
PORT=""
FRONTEND_URL=""
```


---

# 🎨 Frontend Setup

1. Clone the frontend repository:

   ```sh
   git clone https://github.com/reshmeyadav/SweetShop-Frontend
   ```

2. Install dependencies:

   ```sh
   npm install
   ```

3. Add environment variable:

   ```env
   VITE_API_URL=
   ```

4. Start frontend:

   ```sh
   npm run dev
   ```

---

# 🔥 API Endpoints

### **Sweets API**

| Method | Endpoint           | Description                |
| ------ | ------------------ | -------------------------- |
| GET    | `/api/sweets`      | Get all sweets             |
| GET | `/api/sweets/search` | Search sweets by name, category, min/max price |
| POST   | `/api/sweets`      | Add new sweet (Admin only) |
| PUT    | `/api/sweets/{id}` | Update sweet (Admin only)  |
| DELETE | `/api/sweets/{id}` | Delete sweet (Admin only)  |

### **Auth API**

| Method | Endpoint         | Description       |
| ------ | ---------------- | ----------------- |
| POST   | `/api/auth/login`    | Login + JWT token |
| POST   | `/api/auth/register` | Register new user |

---

# 🧠 My AI Usage

This project was developed with the help of **ChatGPT** and **Lovable AI**.
Here is a clear and transparent explanation as required:

### **AI Tools Used**

* **ChatGPT (OpenAI)**
* **Lovable AI** (for React UI generation)

### **How I Used Them**

* I used **ChatGPT** to generate initial backend code structures, fix configuration issues, get help with Spring Security/JWT, and generate project documentation.
* I used **Lovable AI** to create frontend React components, page layouts, and responsive Tailwind designs.

### **My Personal Contribution**

Although I used AI tools to generate initial versions of many project files **(backend + frontend)**,
**I personally modified, corrected, and optimized all the code myself.**
I debugged all issues, fixed errors caused by the AI-generated code, and ensured that the final implementation was fully functional and production-ready.

---
