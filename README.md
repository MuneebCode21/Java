# 🎢 Amusement Park Management System

A full desktop management application built in **Java Swing** using object-oriented programming principles.

## Highlights

- Modern multi-screen Swing GUI
- Dashboard with live park metrics
- Ticket sales and printable receipt preview
- Ride management and ride operations
- Visitor registration
- Food & beverage ordering
- Employee management
- Search and filtering
- Data persistence to local CSV files
- Event log and activity feed
- Custom validation and reusable UI components
- Clean package structure suitable for a GitHub portfolio

## OOP Concepts Demonstrated

- Encapsulation with domain models
- Inheritance (`Person` → `Visitor` / `Employee`)
- Abstraction via service layers and interfaces
- Polymorphism through model and service behavior
- Composition between park, services, and UI controllers
- Enums for controlled domain states
- Collections and stream-style filtering
- Exception handling and validation
- File I/O for persistence

## Run

### With Java directly

Requires **JDK 17+**.

```bash
cd src
javac park/app/ParkApplication.java park/config/*.java park/model/*.java park/service/*.java park/ui/*.java park/util/*.java
java park.app.ParkApplication
```

### With an IDE

Import the project as a Java project and run:

`src/park/app/ParkApplication.java`

No external libraries are required.

## Project Structure

```text
amusement-park-management/
├── README.md
├── .gitignore
├── data/
│   ├── employees.csv
│   ├── rides.csv
│   ├── tickets.csv
│   ├── visitors.csv
│   └── orders.csv
└── src/
    └── park/
        ├── app/
        ├── config/
        ├── model/
        ├── service/
        ├── ui/
        └── util/
```

## Suggested CV Description

**Amusement Park Management System — Java / Swing**  
Developed a multi-module desktop management system featuring ticket sales, visitor registration, ride operations, food ordering, employee administration, dashboards, validation, and persistent local data storage using object-oriented design.
