## Installation
### Preconditions:

* Java JDK 8 installed
* Apache Maven installed
* Project code with Cucumber feature files and step definitions

### Local test run:

1. Open a terminal.
2. Navigate to your project directory.
3. Run the command: `mvn clean verify`
4. To take a look at report go to target/site/serenity/, find index.html and open it

### Remote test run:

1. Go to [GitLabProject](https://gitlab.com/volodymyrkholostoy/sidemo).
2. Navigate to [Build -> Pipelines](https://gitlab.com/volodymyrkholostoy/sidemo/-/pipelines).
3. Click Run pipeline button
4. Wait till pipelines end
5. To take a look at report go to [Deploy -> Pages](https://gitlab.com/volodymyrkholostoy/sidemo/pages)  
6. Click generated link in Access pages

## Adding new coverage

1. Navigate to src/test/resources/features/
2. Create a new .feature file
3. Start to add a new feature with scenarios
* For example:
```gherkin
Feature: Search for the product

Scenario Outline: User expects to see the existing product in the list of products
When he calls endpoint "<available_product>"
Then he sees the title "<expected_title>" in the list of products
Examples:
| available_product | expected_title                                     |
| apple             | Fernandes Super Pineapple Sparkling Lemonade 1,5 L |
| pasta             | Grand'Italia Tortellini ai formaggi                |
| cola              | Pepsi Cola fles                                    |
```
* Define the steps for your new scenarios using Given, When, and Then keywords. You should implement these steps in your step definition class.

## Changes

### POM file:

* Have been updated some versions
* Deleted useless tags, dependencies
* Added missed tags

### Project skeleton:

#### main package
* into src/main/java have been added packages: env, utilities
* env package keeps classes for handle the application properties
* utilities package keeps classes to handle the files

#### test package
* we have the Definition class, which describe Cucumber actions
* steps package keeps classes by which we can interact with application

