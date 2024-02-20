### What is difference between Apply() and Call()





### Javascript ES6+ new features

##### ES6 (ECMAScript 2015)

1. **Let and Const**: Block-scoped variables (`let`) and constants (`const`) for better scope management.
2. **Arrow Functions**: Concise syntax for writing functions. For example, `(x, y) => x + y`.
3. **Template Literals**: Enhanced string literals that allow embedded expressions and multi-line strings using backticks (```). For example, ``Hello, ${name}!``.
4. **Default Parameters**: Functions can have default values for parameters. For example, `function(x, y = 1) { ... }`.
5. **Destructuring Assignment**: Syntax that makes it possible to unpack values from arrays or properties from objects into distinct variables. For example, `const {a, b} = obj;`.
6. **Promises**: An API for asynchronous programming, representing a value that may be available now, in the future, or never.
7. **Modules**: Language-level support for module definition and import/export of variables and functions.
8. **Classes**: Syntactic sugar over JavaScript's existing prototype-based inheritance, making it easier to work with object constructors and prototypes.



### React Component Passing from Parent to Child

Passing through **Props**

Props are short for "properties" and allow you to pass data from a parent component down to its child (or children) components.

```react
import React from 'react';
import UserDetails from './UserDetails';

// Parent Component
class UserProfile extends React.Component {
    render() {
        const userName = "John Doe";
        const userAge = 30;

        return (
            <div>
                <h2>User Profile:</h2>
                <UserDetails name={userName} age={userAge} />
            </div>
        );
    }
}

export default UserProfile;
```

```react
import React from 'react';

// Child Component
class UserDetails extends React.Component {
    render() {
        // Accessing props using this.props
        const { name, age } = this.props;

        return (
            <div>
                <p>Name: {name}</p>
                <p>Age: {age} years old</p>
            </div>
        );
    }
}

export default UserDetails;
```



### What is React Component



### 