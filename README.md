# spring-graphql

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
