WTMachineTest Project
----------------------
This is an Android aplication that fetches data from a remote server using Retrofit, store the data in a local Room database, and display it in a RecyclerView.

Requiremants :-
Android Studio version - Hedgehog | 2023.1.1
Retrofit library version - retrofit:2.9.0
Room library version - 2.6.1
Glide library version - glide:5.0.0-rc01

Usage :-
The app will fetch data from the API and display it in a RecyclerView on the main screen.
The user can scroll through the list of items and click on the item to see more details on the separate screen.
The app will also store the data locally using Room database.
The app will use a repository pattern to manage the data flow between the API and database.
The app will use a ViewModel to interact with the repository and expose the data to the UI.

Architecture :-
Used an architecture to organize the code and components to make the app more scalable, testable, and maintainable.

Additional Libraries :-
Retrofit : This library is used to fetch data from API and store the data to Room and displays it in a RecyclerView.
Room - This library is used to store and retrieve data locally.
Glide - This library is used to load images fraom url and display it to ImageViews.
