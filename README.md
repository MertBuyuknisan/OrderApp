Food Ordering App (OrderApp)

A food ordering application developed with Kotlin, utilizing modern Android architectural principles.

About This Project

OrderApp is a mobile application that allows users to select meals from a restaurant, add them to their cart, and manage their orders online. This project was developed using modern technologies and best practices within the Android development ecosystem. The application is built on the MVVM (Model-View-ViewModel) architecture, adopting principles such as the Repository pattern and Dependency Injection.

Key Features

Homepage: Displays a list of meals with a RecyclerView and includes a search functionality.

Food Detail: A screen that shows the details of a selected meal and allows the user to specify the order quantity.

Cart Management:

Add items to the cart from the homepage or detail screen.

List items in the cart and view the total amount.

Remove items from the cart.

Network Operations: All data is fetched in real-time from a remote server (API).

Architecture and Technical Stack

This project uses the following architectural principles and technologies to create a modern and scalable application:

Architecture: MVVM (Model-View-ViewModel) + Repository Pattern

Language: Kotlin

Asynchronous Programming: Coroutines

UI: Fragment & Navigation Component, RecyclerView, Data Binding, Lottie

Dependency Injection: Hilt

Networking: Retrofit2

Image Loading: Glide

Jetpack Components: ViewModel, LiveData, Navigation

API Information

The application uses the following web services to manage food and cart data:


Endpoints:

tumYemekleriGetir.php: Lists all meals.

sepeteYemekEkle.php: Adds a new meal to the cart.

sepettekiYemekleriGetir.php: Retrieves the meals in the user's cart.

sepettenYemekSil.php: Deletes a meal from the cart.

Screenshots







<img width="400" height="600" alt="500" src="https://github.com/user-attachments/assets/cca68a72-ef24-4887-af41-f8e51eeb0872" />

<img width="400" height="600" alt="500" src="https://github.com/user-attachments/assets/10ea20a7-7acb-422d-a1fa-204f8c0ebf38" />

<img width="400" height="600" alt="500" src="https://github.com/user-attachments/assets/746ea158-3e86-479d-a72e-8931f3bc425d" />

<img width="400" height="600" alt="500" src="https://github.com/user-attachments/assets/b69bd560-184a-4530-933a-760563ef43f6" />




