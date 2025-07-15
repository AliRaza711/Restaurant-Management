# 🍽️ Restaurant Management System (Java Console App)

This is a simple yet functional **Restaurant Management System** written in Java. It allows both admins and customers to interact with a restaurant's menu — add, update, delete items (for admins), and view, search, sort, and order items (for customers). Data is stored using a custom **linked list-based structure**.

---

## 📦 Features

### 👨‍💼 Admin Panel
- 🔐 Password-protected login (`abc.123`)
- ➕ Add new menu items (with name, price, and popularity)
- ✏️ Update existing items (price and popularity)
- ❌ Delete menu items
- 📋 View full menu

### 👨‍🍳 Customer Panel
- 📖 View menu
- 🔍 Search items by name
- 💵 Filter items by price range
- 🔃 Sort menu by:
  - Price (ascending/descending)
  - Popularity (ascending/descending)
- 🛒 Place orders and get total bill

---

## 🛠️ Tech Stack

- **Language**: Java
- **Data Structure**: Custom Linked List (`Node`)
- **User Input**: `Scanner`
- **Validation**: Regex + Range-based validation

---

## 🔑 Admin Credentials

```text
Username: Admin (implicit)
Password: abc.123
```

---

## 🚀 How to Run

1. **Clone this repository**
   ```bash
   git clone https://github.com/AliRaza711/Restaurant-Management.git
   ```

2. **Open the project in IntelliJ IDEA or any Java-compatible IDE**

3. **Run the file:** `Main.java`

4. **Use the console as Admin or Customer**

---

## 🧠 Code Structure

```
src/com/company/
│
├── Main.java         # Main menu and user interaction logic
├── RM.java           # Restaurant operations (add, update, delete, sort, filter, order)
├── Node.java         # Linked List Node structure
└── Validation.java   # Input validation and admin password logic
```

---

## 📸 Preview

```
--- Welcome to the Restaurant Management System ---
1. Admin Login
2. Customer Login
3. Exit
Please select an option (1-3):
```

---

## 🙌 Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📄 License

This project is open-source and free to use for educational purposes.

---

## 🙏 Support This Project

If you found this helpful:

⭐ Star this repo  
🔁 Share it with your friends  
📥 Fork or clone to contribute

---

> Built with ❤️ by [Ali Raza](https://github.com/AliRaza711)
