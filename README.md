# Android_demo_app
simple demo Android application that shows a counter on the screen that the user can increment
Alexandru Ilinu
Android demo app

This application, despite its simplicity, is relevant from a didactic point of view, since it has been build using common best practices. 
The application displays a text box where a counter is shown. The user can increment the counter, by pressing the INCREMENT button. The user can save the current value of the counter by pressing the STORE button. At a later time, the user can load the previously stored value of the counter by pressing the LOAD button. 
The application architecture is built on the recommended guide provided by Google [1], and which is suggested by most courses, and blog posts, as well as the official documentation as the standard way of designing Android applications. I have used the MVVM design pattern. This pattern is a way to split the application into separate interconnected modules, each having a specific responsibility. In this way, one can create cleaner and more modular applications, with the different modules being developed by potentially different programmers. This ensures the “separation of concerns” principle. 
The application consists of 3 layers. The View, which is represented by the Activity (in this case, the MainActivity class), is responsible with the way in which the items are displayed to the user. The second layer is the ViewModel, which stores the state of the application and handles the business logic. The third layer is the Data layer, which is implemented using the repository pattern (in this case, it is the Repository interface). This layer is responsible for providing a clean interface between the data and the rest of the application. In this way, the application does not need to know how the data is stored or represented. 
In this particular case, the Repository only has two simple methods, namely: storeNumber(), which takes as a parameter an int (the number to be stored), and loadNumber(), which returns the number previously stored. If the loadNumber() is called before any call to storeNumber(), then there is no number to be retrieved and the ReadBeforeWriteException is thrown. If an error occurs during the reading or writing of the number, then we throw a ReadException or a WriteException, respectively. 
I have decided to store the value of the counter into a file on the internal storage, so I have created the InternalFileRepository class, which is an implementation of Repository. Since it needs to call the getFilesDir() method to create the file, it needs an Application object as a parameter. 
When the storeNumber() method is invoked, we create a file named number and write the value to the file using a BufferedWriter on that file. If an IOException occurs during the write() call, we wrap the exception into the custom higher-level WriteException. This is because the caller of the method does not have to worry about the low-level details. Moreover, if we later decide to change the Repository to store the data into a database, for example, we don’t have to change the interface. However, I have still passed the IOException as a parameter to the generic WriteException, so that I can display a detailed description of the cause of the error later. I have used the try-with-resources block to ensure that the BufferedWriter is properly closed even if the IOException is generated in the write() call. 
The loadData() method of the Repository works in a similar way. If the FileNotFoundException is thrown when trying to open the file in the internal memory, we assume that the file hasn’t been created yet and throw the ReadBeforeWriteException. We can see how this is a completely different error situation from the ReadException, so it is natural to have different exception classes. 
The ViewModel stores the application state, so that we don’t lose the value of the counter when a configuration change occurs, such as a screen rotation. Moreover, we store the value of the counter into a LiveData object, so that the UI always shows the latest value. The ViewModel implements the increment() method, that increments the value of the counter using the setValue() methods. Since the counter may need to be initialized with a given value, I have implemented a ViewModelFactory, so that I can pass the Application reference as well (which is needed for the Repository). 
The Activity contains references to the UI elements (the TextView that shows the counter value) and the callbacks associated to the buttons. It also contains a reference to the ViewModel and it calls methods in the ViewModel when a specific action is required. If the action fails, an informative message is displayed to the user by using a Toast object. We display a user-friendly message such as “Error on writing.” followed by a more technical detailed message which serves for identifying the source of the error. 
We can see how we don’t have any reference to a Context object inside ViewModel or Repository (so we don’t worry about memory leaks). 
Although the complex architecture of the application was not necessary in that case, it might show some good design principles that are useful when building large applications.  
[1] https://developer.android.com/jetpack/guide