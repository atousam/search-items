# search-items

This project contains search among items of google book and albums of iTunes. You can change propeties of your configs through application.yml file. Configs which are related to searching items are stored in following config:
```
contract:
  external:
    book:
      google:
        url: https://www.googleapis.com
        key: <your google API key>
        max: 5
    album:
      itune:
        url: https://itunes.apple.com/search
        max: 5
```
Please change it according to your preferences.

# Run
1. Build project by maven:
   mvn clean package
2. Go to the root of the project in an open terminal and run command:
   Docker compose up

 The project will start successfully. 
 Swagger URL: http://localhost:8080/swagger-ui/index.html

