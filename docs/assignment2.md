# Java Consolidation Exercise
**Classes, Inheritance, Interfaces & Collections**

## Goal
Work in **pairs or groups of three** to design and implement a small Java program that demonstrates:

- Classes and objects  
- Inheritance  
- Interfaces  
- Collections  
- Processing objects from a `main` method  

Focus on **clear structure and correct use of concepts**, not complex logic.

---

## Task Overview

1. **Choose a domain** (or invent your own).
2. **Design a small class hierarchy** using inheritance.
3. **Define at least one interface** that represents shared behaviour.
4. **Create several objects**, store them in a collection.
5. **Process them in `main`** (e.g. loop, call methods, print output).

You do **not** need user input, files, databases, or a GUI.

---

## Minimum Requirements

Your solution must include:

- ✅ One **abstract superclass** (or base class)
- ✅ At least **two subclasses**
- ✅ One **interface** with at least one method
- ✅ At least **one collection** (`List`, `Set`, or `Map`)
- ✅ A `main` method that:
  - creates objects
  - adds them to a collection
  - loops over the collection
  - calls methods using **polymorphism**

---

## Example Domains (Optional)

You may use one of these or invent your own.

### 1. Vehicles
- `Vehicle` (abstract class)
- `Car`, `Bike`, `Truck` (subclasses)
- `Serviceable` interface (`service()`)
- Store vehicles in a `List<Vehicle>` and process them

### 2. Media Library
- `MediaItem` (abstract class)
- `Book`, `Movie`, `Game`
- `Playable` or `Readable` interface
- Store items in a collection and display details

### 3. Zoo / Animals
- `Animal` (abstract class)
- `Dog`, `Cat`, `Bird`
- `Feedable` or `SoundMaker` interface
- Loop over animals and trigger behaviour

### 4. Staff / Organisation
- `Employee` (base class)
- `Manager`, `Developer`, `Admin`
- `Payable` interface
- Store employees and perform a simple calculation

---

## Suggested Approach

1. Sketch your classes and interfaces on paper first
2. Write the superclass
3. Add subclasses
4. Define and implement the interface
5. Write a simple `main` method to demonstrate everything

Avoid over-engineering.

---

## Stretch Tasks (Optional)

- Use a `Set` instead of a `List`
- Use a `Map` (e.g. ID → object)
- Override `toString()`
- Add a second interface

---

## What We’re Looking For

- Clear use of **inheritance and interfaces**
- Correct use of **collections**
- Evidence of **polymorphism**
- Readable, well‑named code