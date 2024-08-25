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

# Technologies:
1. Using Actuator to expose health check.
  End point: http://localhost:8080/actuator/health   
2. Using Actuator to expose prometheus metrics, in upstream response time
  End point: http://localhost:8080/actuator/prometheus
3. Using circuit breaker in time out of upstream services (google and iTune)
4. Using Redis to cache responses of books and albums


# Run
1. Build project by maven:
   mvn clean package
2. Go to the root of the project in an open terminal and run command:
   Docker compose up

 The project will start successfully. 
 Swagger URL: http://localhost:8080/swagger-ui/index.html

 To test using graphQL you can use URL: http://localhost:8080/graphiql?path=/graphql
 Type your desired parameters is text area. Sample:
 query {
  searchItemsGrQl(term: "hot") {
    books {
      title,
    subtitle,
    authors,
    publishedDate,
    publisher,
    description,
    pageCount,
    categories
    }
    musics {
      kind,
    artistId,
    collectionId,
    artistName,
    collectionName,
    trackName,
    collectionCensoredName,
    trackCensoredName,
    releaseDate
    }
  }
}


