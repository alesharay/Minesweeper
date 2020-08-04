# MINESWEEPER

#### Group 9 - CS 4398 SWE Project

## To Do

### Process
 
- [x] Create a UML class diagram with:
    - [x] classes
    - [x] abstract classes
    - [x] interfaces related by:
        - [x] generalization
        - [x] association
        - [x] other relationships as needed and packaged (model, view, controller). 
    - [x] The classes should contain:
        - [x] your first take at attributes and operations 
        - [x] (that should include constructors and at least one main method). 
    - [x] The diagram should contain:
        - [x] interfaces
        - [x] abstract classes
        - [x] classes that define an MVC architecture 
            - [x] (i.e. interfaces Model, View, Controller, ModelListener; class ModelEvent (or other Events
            ); abstract classes AbstractModel, AbstractController) in addition to your model specific classes. 
    - [x] You can update your classes and interfaces in the code later and reverse engineer a class diagram
     consistent with your code. 
    - [x] The classes should include some initial set of exceptions and operation definitions should mention if they
      throw them.
- [x] Use the class diagram to create a skeleton of the source code 
    - [x] start from the model package including:
        - [x] interfaces
        - [x] classes that define an MVC 
    - [x] then the rest of the controller and view interfaces and classes; 
    - [x] your first iteration of the model package should be relatively complete before proceeding to the rest of
     the controller and view)
- [x] Incrementally edit the source code to include the rest of attribute and operation declarations (NOT
 implementations yet) with 
    - [x] proper javadoc comments for classes, attributes and operations. 
    - [x] Focus on usefulness of API (the kinds of operations and their formal parameter lists, return types
    , exceptions). 
    - [x] As you create additional operation declarations think about contingencies that may happen when executing an
     operation and create corresponding exception classes and specify that an operation throws them. 
    - [x] Also, add stubs into operations that throw exceptions so that this code (without implementations) would
      compile.
- [x] Make sure your code compiles while doing the increments (nothing to run yet because it only contains declarations
 and stubs).
- [x] Produce an initial javadoc documentation (with all scopes of visibility allowed)
- [x] Reverse engineer the code in the current state into a UML class diagram
- [x] Analyze the consistent class diagram and javadoc docs and make changes to the code if necessary. Iterate steps 4
,5,6,7 until satisfied with your initial model
- [x] Identify an initial set of methods to implement; write JUnit testcases for them; then implementations; test them
 and iterate until satisfied
- [ ] Proceed in increments 
    - [ ] write test
    - [x] write implementation
    - [ ] test the implementation
    - [x] change javadoc comments, if necessary, until you implement the functionality of the model package first. 
    - [ ] You should be able to test all the functionality of the classes in the model package without controller and
     view classes
- [x] Proceed in increments to cover the rest of the functionality
- [ ] Conduct acceptance tests; fix faults if found.
- [x] Reverse engineer the code to produce a consistent UML class diagram
- [x] Create a final javadoc
 

## Submission
 
- [ ] Turn in the assignment electronically to the TRACS drop box.
    - [ ] Only one student per group needs to upload the submission archive.
- [ ] The files of the problem should be archived into one archive file. 
    - [ ] The archive should preserve the directory structure starting from the root directory of the software system.
- [ ] If you start your project from scratch and follow the MVC architectural style then classes should be in packages
 <systemName>.model, <systemName>.view, <systemName>.controller. 
    - [x] If needed there can be a package <systemName>.util in addition to the ones already mentioned.
- [ ] The archive file should contain:
    - [ ] Description of execution of acceptance testcases illustrated with screenshots of all the windows and pop-up
     windows of the system along an acceptance testcase
    - [x] UML class diagram
    - [x] System statechart diagrams
    - [ ] Textual description of the structure of your system and implemented algorithms critical for the system's
     behavior
    - [x] Source code (archive of the project directory structure)
    - [x] API docs produced by javadoc, if using Java
    - [ ] Unit testcases in the code (for the Model and Controller classes and their methods or for most critical
     classes that contribute most to the behavior of your system), use JUnit if using Java
