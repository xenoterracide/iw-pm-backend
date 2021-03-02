# Build

build and run tests.
```shell
./gradlew build
```

# Domain Model
## User

```mermaid
graph TD;
    A-->B;
    A-->C;
    B-->D;
    C-->D;
```

classDiagram
  Animal <|-- Duck
  Animal <|-- Fish
  Animal <|-- Zebra
  Animal : +int age
  Animal : +String gender
  Animal: +isMammal()
  Animal: +mate()
  class Duck{
      +String beakColor
      +swim()
      +quack()
  }
  class Fish{
      -int sizeInFeet
      -canEat()
  }
  class Zebra{
      +bool is_wild
      +run()
  }

