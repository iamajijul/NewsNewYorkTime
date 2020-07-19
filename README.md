# NYT

This Application fetching all the latest article from New York Times Magazine with Offline facility.

The app follows the MVVM architecture with the repository pattern, alongside Dagger_Hilt for DI.

#### Folder structure

There are 6 main folders: base, db, di, helper, network, ui
* base: This folder contain all Base classes like BaseActivityClass
* db: This folder contain all Room database related work
* di: Contain Dagger_Hilt related files
* helper: Helper classes to build this application ex. extension class
* network: Retrofit network related classes present in this folder
* ui: All views related classes present in this folder. The app follows MVVM architecture coding pattern 
for this project.

### Design, libraries and other stuff applied

* Data binding
* Room
* ViewModel and LiveData
* Coroutines
* Dagger_Hilt for dependency injection
* Retrofit
* MVVM architecture + Repository pattern
* Junit4 
* Espresso
* Navigation Architecture Component
* Constraint Layout
* Google Material Components

Whole project written in kotlin language.



### Testing!

I have written unit test for two main class "BaseRepository.kt"(For network operation test) and 
"ArticleRepository.kt"(For Database operation check). Run the test by clicking on run icon beside the 
test method. Also tested UI visibility for one class "FragmentListOfArticles.class".




### Permission!

1. Internet permission

### Note!
This app saving data for offline viewing, after fetching one time, if user lose the internet connection
then this app will show the data from database.