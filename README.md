# Installation
## Code

build and run tests.
```shell
./gradlew build
```
## Browser
### Mermaid

Install the chrome extension for
[Mermaid](https://chrome.google.com/webstore/detail/mermaid-diagrams/phfcghedmopjadpojhmmaffjmfiakfil)
to view documentation correctly.

# Domain Model
## User

```mermaid
classDiagram
    class Identifiable {
        <<interface>>
        +UUID getId();
    }

    class AuthnIdentity {
        -String foreignUserId
    }

    class Profile {
    }

    class User {
    }

    User --|> Identifiable
    User *--> AuthnIdentity
    User *--> Profile
```
