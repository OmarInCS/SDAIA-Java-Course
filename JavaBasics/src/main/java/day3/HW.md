#### Part 1: OOP Basics (20 points)

1.  **Class and Object Creation (5 points)**

    -   Create a `Person` class with attributes `name`, `age`, and `address`. Include constructors, getters, and setters.
    -   Write a `main` method to create and display details of two `Person` objects.
2.  **Inheritance and Polymorphism (5 points)**

    -   Create a subclass `Student` that extends `Person` and adds attributes `studentId` and `course`.
    -   Override the `toString` method to display all details of a `Student`.
3.  **Encapsulation and Data Validation (10 points)**

    -   Modify the `Person` class to validate that `age` is between 0 and 150. Throw an `IllegalArgumentException` if the value is out of range.
    -   Ensure that `studentId` in the `Student` class is a positive integer.

#### Part 2: Abstract Classes and Interfaces (20 points)

1.  **Abstract Classes (10 points)**

    -   Create an abstract class `PersonRecord` with an abstract method `String getDetails()`.
    -   Modify `Person` and `Student` to extend `PersonRecord` and implement `getDetails` to return a string with the person's details.
2.  **Interfaces (10 points)**

    -   Create an interface `ComparableById` with a method `boolean compareById(int id)`.
    -   Implement `ComparableById` in `Student` class. The method should return `true` if the `studentId` matches the given id.

#### Part 3: Collections (20 points)

1.  **Using Collections (10 points)**

    -   Create a class `School` that manages a list of `Student` objects using an `ArrayList`.
    -   Implement methods to add a student, remove a student by `studentId`, and display all students.
2.  **Sorting and Searching (10 points)**

    -   Implement a method in `School` to sort the students by name.
    -   Implement a method to find a student by `studentId` using binary search.

#### Part 4: File Read/Write Operations (20 points)

1.  **Writing to Files (10 points)**

    -   Implement a method in `School` to write the list of students to a text file (`students.txt`). Each student's details should be written on a new line.
2.  **Reading from Files (10 points)**

    -   Implement a method in `School` to read student details from the text file (`students.txt`) and populate the `ArrayList` of students.