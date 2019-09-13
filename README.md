# spring-graphql

## Pre-requisites: 
* Java 11+
* Spring Boot 2.1.7+
* GraphQL Spring Boot starter
* GraphiQL tool _to execute graphql queries_

## How to startup the application:

### Starting University App

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
