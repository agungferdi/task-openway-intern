# QA Task 5: Test Case Documentation for Periplus Shopping Cart

## Test Case Components

A well-structured test case should include the following components:

1. **Test Case ID**: A unique identifier for the test case
2. **Test Case Title**: A clear, descriptive title that explains what's being tested
3. **Test Case Description**: A summary of what the test is verifying
4. **Preconditions**: Required setup and initial conditions before executing the test
5. **Test Steps**: Detailed, sequential steps to execute the test
6. **Expected Results**: What should happen after each step
7. **Actual Results**: What actually happened (filled during execution)
8. **Test Data**: Specific input data required for the test
9. **Test Environment**: Details about the environment where the test is executed
10. **Status**: Pass/Fail/Blocked
11. **Priority/Severity**: Importance level (High, Medium, Low)
12. **Created By**: Author of the test case
13. **Created Date**: When the test case was created
14. **Executed By**: Who executed the test
15. **Execution Date**: When the test was executed

## Example of a Well-Constructed Test Case

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-001 |
| **Test Case Title** | Add Product to Shopping Cart |
| **Test Case Description** | Verify that a user can successfully add a product to the shopping cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Search for a product (e.g., "harry potter")<br>3. Select a product from search results<br>4. Click "Add to Cart" button<br>5. Navigate to the shopping cart |
| **Expected Results** | 1. Homepage loads successfully<br>2. Search results display relevant products<br>3. Product details page opens<br>4. Product is added to cart with success message<br>5. Cart page shows the added product |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123<br>- Search query: "harry potter" |
| **Test Environment** | - Browser: Google Chrome 120.0<br>- OS: Windows 11<br>- Screen resolution: 1920x1080 |
| **Status** | Pass |
| **Priority/Severity** | High |
| **Created By** | Agung |
| **Created Date** | April 25, 2025 |
| **Executed By** | Agung |
| **Execution Date** | April 25, 2025 |

## Periplus Shopping Cart Test Cases

### TC-CART-001: Verify User Can Add Product to Shopping Cart

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-001 |
| **Test Case Title** | Add Product to Shopping Cart |
| **Test Case Description** | Verify that a user can successfully add a product to the shopping cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Search for a product (e.g., "harry potter")<br>3. Select a product from search results<br>4. Click "Add to Cart" button<br>5. Navigate to the shopping cart |
| **Expected Results** | 1. Homepage loads successfully<br>2. Search results display relevant products<br>3. Product details page opens<br>4. Product is added to cart with success message<br>5. Cart page shows the added product |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123<br>- Search query: "harry potter" |
| **Status** | Not Executed |
| **Priority/Severity** | High |

### TC-CART-002: Verify User Can Add Multiple Quantities of a Product

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-002 |
| **Test Case Title** | Add Multiple Quantities of a Product |
| **Test Case Description** | Verify that a user can add multiple quantities of the same product to the shopping cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Search for a product<br>3. Select a product from search results<br>4. Change quantity to 3<br>5. Click "Add to Cart" button<br>6. Navigate to the shopping cart |
| **Expected Results** | 1. Homepage loads successfully<br>2. Search results display relevant products<br>3. Product details page opens<br>4. Quantity field updates to 3<br>5. Product is added to cart with success message<br>6. Cart page shows the product with quantity 3 |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123<br>- Search query: "dictionary"<br>- Quantity: 3 |
| **Status** | Not Executed |
| **Priority/Severity** | Medium |

### TC-CART-003: Verify Price Calculation in Shopping Cart

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-003 |
| **Test Case Title** | Price Calculation in Shopping Cart |
| **Test Case Description** | Verify that the shopping cart correctly calculates the total price based on product prices and quantities |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Search for a product<br>3. Select a product from search results<br>4. Note the product price<br>5. Add product to cart<br>6. Search for a second product<br>7. Select a product from search results<br>8. Note the product price<br>9. Add product to cart<br>10. Navigate to the shopping cart |
| **Expected Results** | 1. Homepage loads successfully<br>2-9. Products are added successfully<br>10. Cart displays both products with correct individual prices<br>11. Subtotal equals the sum of all product prices<br>12. Total includes any applicable taxes and shipping fees |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123 |
| **Status** | Not Executed |
| **Priority/Severity** | High |

### TC-CART-004: Verify User Can Update Product Quantity in Cart

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-004 |
| **Test Case Title** | Update Product Quantity in Cart |
| **Test Case Description** | Verify that a user can update the quantity of a product in the shopping cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. User has at least one product in the shopping cart<br>4. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Click on shopping cart icon<br>3. Find a product in the cart<br>4. Change the quantity from 1 to 2<br>5. Click update or apply changes button |
| **Expected Results** | 1. Homepage loads successfully<br>2. Cart page opens with products<br>3. Product is displayed in cart<br>4. Quantity field updates to 2<br>5. Cart updates with new quantity<br>6. Price subtotal is recalculated based on new quantity |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123<br>- New quantity: 2 |
| **Status** | Not Executed |
| **Priority/Severity** | High |

### TC-CART-005: Verify User Can Remove Product from Cart

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-005 |
| **Test Case Title** | Remove Product from Cart |
| **Test Case Description** | Verify that a user can remove a product from the shopping cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. User has at least one product in the shopping cart<br>4. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Click on shopping cart icon<br>3. Find a product in the cart<br>4. Click on remove or delete button for the product |
| **Expected Results** | 1. Homepage loads successfully<br>2. Cart page opens with products<br>3. Product is displayed in cart<br>4. Product is removed from cart<br>5. Cart total is updated<br>6. If cart becomes empty, empty cart message is displayed |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123 |
| **Status** | Not Executed |
| **Priority/Severity** | High |

### TC-CART-006: Verify Cart Persistence After Logout/Login

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-006 |
| **Test Case Title** | Cart Persistence After Logout/Login |
| **Test Case Description** | Verify that shopping cart contents persist after user logs out and logs back in |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Add a product to cart<br>3. Verify product is in cart<br>4. Log out of the account<br>5. Log back in to the account<br>6. Navigate to shopping cart |
| **Expected Results** | 1. Homepage loads successfully<br>2. Product is added to cart successfully<br>3. Product appears in cart<br>4. User is logged out successfully<br>5. User is logged in successfully<br>6. Previously added product is still in the cart |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123 |
| **Status** | Not Executed |
| **Priority/Severity** | Medium |

### TC-CART-007: Verify Stock Limitation Enforcement

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-007 |
| **Test Case Title** | Stock Limitation Enforcement |
| **Test Case Description** | Verify that the system enforces stock limitations when adding products to cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Search for a product with limited stock (may need to research)<br>3. Select the product<br>4. Try to add a quantity higher than the available stock<br>5. Observe the system's response |
| **Expected Results** | 1. Homepage loads successfully<br>2. Search results display relevant products<br>3. Product details page opens<br>4. System prevents adding more than available stock<br>5. Error message indicates the maximum quantity allowed |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123<br>- Search query: (product with limited stock) |
| **Status** | Not Executed |
| **Priority/Severity** | High |

### TC-CART-008: Verify Cart Functionality for Guest User

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-008 |
| **Test Case Title** | Cart Functionality for Guest User |
| **Test Case Description** | Verify that a guest user (not logged in) can add products to cart |
| **Preconditions** | 1. User is not logged in<br>2. Internet connection is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Search for a product<br>3. Select a product from search results<br>4. Click "Add to Cart" button<br>5. Navigate to the shopping cart |
| **Expected Results** | 1. Homepage loads successfully<br>2. Search results display relevant products<br>3. Product details page opens<br>4. Product is added to cart with success message<br>5. Cart page shows the added product<br>6. User should be able to see checkout options that include login or guest checkout |
| **Test Data** | - Search query: "mystery novel" |
| **Status** | Not Executed |
| **Priority/Severity** | Medium |

### TC-CART-009: Verify Cart Updates When Product Becomes Unavailable

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-009 |
| **Test Case Title** | Cart Updates When Product Becomes Unavailable |
| **Test Case Description** | Verify that the cart handles the scenario when a product in the cart becomes unavailable |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. User has added a product to cart<br>4. The product is then set as out of stock (simulated scenario) |
| **Test Steps** | 1. Add a product to cart<br>2. Simulate product becoming unavailable (this is a theoretical test)<br>3. Refresh cart page<br>4. Observe cart behavior |
| **Expected Results** | 1. Product is added to cart successfully<br>2. Product availability changes in system<br>3. Cart refreshes<br>4. Cart displays appropriate message about product unavailability<br>5. System prevents proceeding to checkout with unavailable items |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123 |
| **Status** | Not Executed |
| **Priority/Severity** | Medium |

### TC-CART-010: Verify Application of Discount Code in Cart

| Field | Value |
|-------|-------|
| **Test Case ID** | TC-CART-010 |
| **Test Case Title** | Application of Discount Code in Cart |
| **Test Case Description** | Verify that a valid discount code can be applied to the shopping cart |
| **Preconditions** | 1. User has a valid account on Periplus<br>2. User is logged in<br>3. User has at least one product in the cart<br>4. A valid discount code is available |
| **Test Steps** | 1. Navigate to Periplus homepage<br>2. Click on shopping cart icon<br>3. Enter a valid discount code in the appropriate field<br>4. Apply the discount code<br>5. Observe cart total |
| **Expected Results** | 1. Homepage loads successfully<br>2. Cart page opens with products<br>3. Discount code field accepts input<br>4. Discount is applied successfully<br>5. Cart total is reduced by the appropriate discount amount<br>6. Discount is reflected in the order summary |
| **Test Data** | - Username: test@example.com<br>- Password: TestPassword123<br>- Discount code: (valid code) |
| **Status** | Not Executed |
| **Priority/Severity** | Medium |