
#### Requirements:

1.  **Class Design:**

    -   Create a class `Student` with the following private attributes:
        -   `String name`
        -   `int id`
    -   Provide public getter methods for each attribute.
    -   Provide a constructor to initialize all attributes.
2.  **StudentManager Class:**

    -   Create a class `StudentManager` with the following private attribute:
        -   `ArrayList<Student> students` - a list to store students.
    -   Implement the following public methods:
        -   `void addStudent(Student student)` - Adds a new student to the list.
        -   `Student getStudentById(int id)` - Returns a student based on their ID.
        -   `ArrayList<Student> getAllStudents()` - Returns a list of all students.
        -   `boolean removeStudentById(int id)` - Removes a student from the list using their ID.
3.  **Main Class:**

    -   Create a `Main` class with a `main` method to demonstrate the functionality of the `StudentManager` class.
    -   In the `main` method:
        -   Create several `Student` objects.
        -   Add these students to the `StudentManager`.
        -   Retrieve and display a student by their ID.
        -   Display all students in the list.
        -   Remove a student by their ID and display the list of students again to confirm removal.