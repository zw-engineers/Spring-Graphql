# spring-graphql

## Pre-requisites: 
* Java 11+
* Spring Boot 2.1.7+
* GraphQL Spring Boot starter
* GraphiQL tool _to execute graphql queries_

## How to startup the application:

### Starting University App

### Architecture

<img src="https://user-images.githubusercontent.com/29547780/89707242-496c1b00-d964-11ea-9a46-c01dc0a0f647.jpg" />

* To start the `University` application just navigate into the university app directory containing the `build.gradle` file and just
start the app by running the command `./gradlew bootRun` and it should start the application on port 8081.
* You can test that you are recieving a list of `Students` with degrees and tutors by calling the following API:
`http://localhost:8081/api/university/students`

and you should have an output as below:

```json
[
  {
    "name": "artemas",
    "surname": "muzanenhamo",
    "degree": {
      "degree": "software engineering"
    },
    "tutor": {
      "name": "jessica",
      "surname": "stevens",
      "degree": {
        "degree": "software engineering"
      }
    }
  },
  {
    "name": "thomas",
    "surname": "jenkins",
    "degree": {
      "degree": "bio-chemistry"
    },
    "tutor": {
      "name": "lavern",
      "surname": "masoja",
      "degree": {
        "degree": "bio-chemistry"
      }
    }
  },
  {
    "name": "sarah",
    "surname": "smith",
    "degree": {
      "degree": "computer science"
    },
    "tutor": {
      "name": "randal",
      "surname": "macbeth",
      "degree": {
        "degree": "computer science"
      }
    }
  }
]
```

### Starting the `GraphQL` application
* Navigate to the `graphql` application directory containing the `build.gradle` file and you should start the application with the following command:
`./gradlew bootRun`. The application should be started on port 8080
* You will need a GraphQl client which will enable you to run queries against the data returned from the `graphql` application. 
There are a few clients as below:
    * [GraphiQl](https://electronjs.org/apps/graphiql)
    * [Insomnia + GraphQl](https://insomnia.rest/graphql/)
* Download any of the clients above and you should be able to access the graphql endpoint at: `http://localhost:8080/graphql`.
* I have two top queries:
    * **Get Student By Name** - This query returns a student given an existing valid name
    ```graphQl
        type Query {
            getAllStudents: [Student]
        }
    ```
    * Below is an example to execute this query:
    ```graphQl
        {
          getStudentByName(name: "artemas") {
            name
            surname
            degree {
              degree
            }
            tutor{
              name
              surname
              degree {
                degree
              }
            }
          }
        }

    ```
    
    * **Get All Students** - This query will return all the students. This data matches what is returned by the `University` application.
    ```
        type Query {
            getAllStudents: [Student]
        }
    ```
    
    * Below is how you execute this query:
    ```graphQl
        {
          getAllStudents {
            name
            surname
            degree {
              degree
            }
            tutor {
              name
              surname
              degree {
                degree
              }
            }
          }
        }
    ```
