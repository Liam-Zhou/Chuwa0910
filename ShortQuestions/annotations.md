### @Override
In an inheritance relationship, a child class override the same method of a parent class.

### @Service
Representing the service layer of a springboot application, usually contains the busniess logic.

### @Entity, @Table
Used to connect the database to the Springboot API.
```
@Entity
@Table(
        name = "posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
```
