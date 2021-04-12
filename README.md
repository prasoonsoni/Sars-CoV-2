# Sars-CoV-2😷
## Your personal pandemic assistant 📱
## <a id="raw-url" href="https://www.mediafire.com/file/mv5z4f57tg0ne4z/Sars-CoV-2.apk/file">Download APK</a> 

Intended User
> It can be used by anyone.
## Features 📲
- Splash Screen.
- Get Started Screen.
- Sign in / Sign up.
- Call & Send SMS to Covid helpline.
- A small quiz related to Covid.
- PM Relief Fund information available.
- All Indian states Covid data.
- Your Location information.
- Precautions & Symptoms.
- All countries data search available.
- Feedback form.
- Logout option.
## User Interface Mocks 💻
> Screen 1 (Splash Screen)
![image](https://user-images.githubusercontent.com/75159757/114435889-57a0c400-9be2-11eb-9eab-318111706a61.png)

> Screen 2 (Get Started Screen)
![image](https://user-images.githubusercontent.com/75159757/114436393-e3b2eb80-9be2-11eb-824b-1e53f8c6c33f.png)

> Screen 3 (Sign in / Sign up)
![image](https://user-images.githubusercontent.com/75159757/114436652-37253980-9be3-11eb-879a-391d570116a0.png)

> Screen 4 (Home Screen)
![image](https://user-images.githubusercontent.com/75159757/114437235-e6faa700-9be3-11eb-9b35-50400fba63d1.png)
![image](https://user-images.githubusercontent.com/75159757/114437141-c6cae800-9be3-11eb-9c50-b3c95900748d.png)

> Screen 5 (Search Country)
![image](https://user-images.githubusercontent.com/75159757/114437652-743dfb80-9be4-11eb-8148-6075b81a28d6.png)

> Screen 6 (Precautions)
![image](https://user-images.githubusercontent.com/75159757/114437701-85870800-9be4-11eb-8e4f-a4d17f60f10d.png)

> Screen 7 (Symptoms)
![image](https://user-images.githubusercontent.com/75159757/114437976-d139b180-9be4-11eb-9431-b6a28e70cf8d.png)

> Screen 8 (Feedback Form)
![image](https://user-images.githubusercontent.com/75159757/114438278-2a094a00-9be5-11eb-9047-c2e666da7bf9.png)

> Screen 9 (About)
![image](https://user-images.githubusercontent.com/75159757/114438804-da774e00-9be5-11eb-8648-c5974ed1c6a3.png)

## Key Considerations 🔑
1. **How will your app handle data persistance ?**
     - ***The app uses Firebase authentication for user registration and Firebase realtime database for storing all the feedbacks and suggestions given by the user.***
2. **Libraries used in the application.**
     - ***Firebase libraries for data handling (VERSION: 19.3.0)***
     - ***Picasso (VERSION: 2.5.2)to handle the loading and caching of images.***
     - ***Volley library(VERSION: 1.2.0) for API calling and handling.***
     - ***Lottie library (VERSION: 3.4.0) for animations.***
     - ***Eazegraph library(VERSION: 1.2.5) for pie chart.***
## Required Tasks 🧿
***This is the section where you can take the main features of your app (declared above)
and break them down into tangible technical tasks that you can complete one at a
time until you have a finished app.***
1. **Task 1: Project Setup**
     - *Configure libraries*
     - *Build UI for Splash Screen*
     - *Build UI for Sign in / Sign up*
     - *Setup of Firebase services*

2. **Implement UI for Each Activity**
     - *Build UI for MainActivity*
     - *Setup the Navigation Drawer.*
     - *Code implementation for the activities till task 2.*
3. **Implementation of Volley Library for fetching data**
     - *Implementation of Volley*
     - *Fetch data from the API*
     - *Show the fetched Data in the UI*

4. **Task 4: Additional Features**
     - *Implementing map for viewing your location*
     - *Creating Precautions Activity*
     - *Creating Symptoms Activity*
     - *Creating About Activity*
## Declarations 🏹
- ***This app is written solely in the Java Programming Language.***
- ***The app enables RTL layout switching on all layouts.***
- ***If it performs a short duration, on-demand requests (such as search), the app uses an AsyncTask.***
- ***If it needs to pull or send data to/from a web service or API only once, or on a per request basis (such as a search application), the app uses an IntentService to do so.***
- ***It uses Location of your device to show it on Map.***








































