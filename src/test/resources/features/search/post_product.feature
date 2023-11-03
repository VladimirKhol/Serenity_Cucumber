Feature: Search for the product

### Please use endpoint GET https://waarkoop-server.herokuapp.com/api/v1/search/demo/{product} for getting the products.
### Available products: "orange", "apple", "pasta", "cola"
### Prepare Positive and negative scenarios

  Scenario Outline: User expects to see the existing product in the list of products
    When he calls endpoint "<available_product>"
    Then he sees the title "<expected_title>" in the list of products
    Examples:
      | available_product | expected_title                                     |
      | apple             | Fernandes Super Pineapple Sparkling Lemonade 1,5 L |
      | pasta             | Grand'Italia Tortellini ai formaggi                |
      | cola              | Pepsi Cola fles                                    |

  Scenario Outline: User expects to see an error message when searching for not existing products
    When he calls endpoint "<bad_endpoint>"
    Then he sees an error message "Not found"

    Examples:
      | bad_endpoint |
      | c0la         |
      | COLA         |
      | aple         |
      | Pasta        |
      | 0range       |