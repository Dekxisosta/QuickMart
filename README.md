# QuickMart PoS System

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java Swing](https://img.shields.io/badge/Java%20Swing-%232D234B.svg?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/Paradigm-OOP-blueviolet?style=for-the-badge)

> [!note]
> Sample POS terminal built with **Java Swing**, themed after Honkai: Star Rail.

---

## Preview

![Preview](assets/images/preview.gif)

## Screenshot

![Screenshot](assets/images/preview.png)

## UML Diagram

![Diagram](assets/images/diagram.png)

---

## Key Features

> [!important]
> - 🔐 **Secure login** — operator authentication
> - 🧾 **Receipt rendering** — HTML/CSS via `JEditorPane`
> - 🗑️ **Void item / clear cart** controls
> - ⚡ **Fast input** — amount + quantity buttons
> - 💾 **Persistent transaction logging**
> - 🧩 **Modular architecture** — `model` / `gui` / `theme` / `controller`
> - 🎨 **Custom themed UI** — HSR-inspired

---

## Configuration

> [!warning]
> To avoid `NullPointerException` errors on startup, you **must** mark the directory containing your images and icons as the **Resources Folder** in your IDE.
> If this is not done, the app will crash because it cannot locate the assets.

---

## Login

> [!caution]
> Credentials are **hard-coded** for this project's intended scope. They can be decoupled into a `UserRepository` class if needed.
>
> | Field | Value |
> |-------|-------|
> | **User** | `acheron` |
> | **Pass** | `hsr1234` |

---

## Author's Note

> [!note]
> **Development time:** 2 days
>
> I always wanted to build a POS system — it was fun diving into Java Swing's libraries,
> though the lack of modern styling support was frustrating. Very verbose;
> constantly overriding and extending components just to get basic visuals.
>
> Won't be extending this further, but a **`.jar` or `.exe` download** will likely be dropped at some point.

---

> [!warning]
> **Disclaimer:** This project is a non-commercial, fan-made application and is not affiliated with or endorsed by **HoYoverse (miHoYo)**. All game-related assets and trademarks are the property of their respective owners. Assets are used strictly for demonstrative purposes to showcase UI/UX implementation and resource-handling capabilities.
