# Requirements

| Requirement ID | User Story ID | Requirement | Acceptance Criteria | Effort | Priority | Status |
|----------------|---------------|-------------|---------------------|--------|----------|--------|
|            000 |           000 | Everyone has the correct libraries downloaded and working on their pc. | Everyone is able to start coding with the correct libraries. | 1 | Necessary | Satisfied |
|            001 |           000 | Everyone has a separate working branch on Github and knows how to work with the master branch. | Everyone has a separate branch on Github and is able to merge with the master branch. | 1 | Necessary | Satisfied |
|            002 |           001 | When the registration button is clicked, the registration page is displayed. | There exist a registration scene where information can be inputted.  | 8 | Necessary | Satisfied |
|            003 |           001 | There should be a text entry for user information such as first and last name, email, and password. | There are textbox for entry of user information. | 8 | Necessary | Satisfied |
|            004 |           001 | When the confirmation button is clicked, the system checks to make sure all fields are filled out. | There is a confirmation button that checks that all fields are filled out. | 8 | Necessary | Satisfied |
|            005 |           001 | When the confirmation button is clicked, the system checks to make sure all fields are valid inputs | Checks that the information is valid. First Name is only one word, Last Name is only one word, Email contains a @, and password meets the password minimum requirements. | 8 | Necessary | Satisfied |
|            006 |           001 | When the confirmation button is clicked, the system checks the inputted information against the database to ensure no duplicate emails. | System takes the given email and checks it against the database for duplicates and returns an error statement if a duplicate is found | 8 | Necessary | Satisfied |
|            007 |           001 | When the confirmation button is clicked and all the information is checked, there should be a success notification | After all the checks, the user should be notified that it was successful | 8 | Necessary | Satisfied |
|            008 |           002 | There should be a login page. | There exist a login scene where information can be inputted. | 13 | Necessary | Satisfied |
|            009 |           002 | There should be a text entry for ID/Email and password. | There is a textbox for entry for ID/Email and password. | 13 | Necessary | Satisfied |
|            010 |           002 | When the login button is clicked, the system checks that the email and password exist in the database. | System takes the inputted information and checks the information with the database and logs in accordingly. | 13 | Necessary | Satisfied |
|            011 |           002 | When the forgot password button is clicked, changes the scene to the forgot password scene. | The scene is changed to the forgot password scene. | 13 | Necessary | Satisfied |
|            012 |           002 | There should be a button that leads to registration page. | There should be a button on the login scene that changes the scene to the registration scene. | 13 | Necessary | Satisfied |
|            013 |           004 | There should be a button that leads to product creation page. | There is a button that leads to the product creation scene. | 8 | Necessary | Satisfied |
|            014 |           004 | There should be a text entry for product name, product description, and product price. | There is a text entry to identify the product name, product description, and product price. | 8 | Necessary | Satisfied |
|            015 |           004 | There should be a list to pick the type of genre for the product item. | There is a check list to select the type of genre to search for. | 8 | Important | Satisfied |
|            016 |           004 | When the file upload button is clicked, the user can upload files from their computer. | The system can upload files and store them. | 8 | Important | Working |
|            017 |           004 | When the confirmation button is clicked, the system checks that all fields are valid and filled out. | The system can store all the given information into the database or provide error messages where there are invalid information. | 8 | Important | Satisfied |
|            018 |           018 | There should be a Login and Sign up label on Forgot page | The "Login" and "Sign up" label will be use to go back to login and registration page. | 1 | Important | Satisfied |
|            019 |           018 | When "Login" or "Sign up" label is clicked, change the scene to login scene or registration scene respectively. | The "Login" and "Sign up" label will lead to login or registration page respectively. | 2 | Important | Satisfied |
|            020 |           018 | There should be a text field for email on Forgot page | This is the text field that allow user to input their email. | 1 | Important | Satisfied |
|            021 |           018 | There should be a "Send" button on Forgot page | The "Send" button will tell the system to check the data within the text field. | 3 | Important | Satisfied |
|            022 |           018 | When "Send" button is clicked, the system will check if the email exist in the database. | System takes the inputted email and checks the information with the database. | 4 | Important | Satisfied |
|            023 |           018 | When "Send" button is clicked and the email exist within the database, send an email with a username and password to the inputted email. | System sends an email with username and password to a valid email address. | 5 | Important | Working |
|            024 |           020 | When "edit" button is clicked, the text field for first name, last name, and email should be editable. | User can change their information directly on the same page without going to different page. | 10 | Important | Satisfied |
|            025 |           020 | The side bar should have a link to different pages such as store and library. | User can move to differnet pages using the side bar within the profile page  | 1 | Important | Satisfied |
|            026 |           020 | When the "submit" button is clicked, the data within the database will be updated. | The new data get updated to database | 9 | Important | Satisfied |
|            027 |           009 | User's wish list is update and store locally as a text file everytime user login. | User's wish list is automatically update everytime they login to the program. | 5 | Necessary | Satisfied |
|            028 |           009 | User's wish list is stored and ready to use inside of the user class | This will help with updating user wish list ui in the future. | 7 | Necessary | Satisfied |
|            029 |           021 | User's profile can be access from main page | user can click on the profile button on the main page and arrive at the profile page | 3 | Necessary | Satisfied |
|            030 |           021 | User can access their wishlist from the pain page | user can click on the profile drop down and click on "wishlist" button and view wishlist page | 3 | Important | working |
|            031 |           021 | User can access help page from main page | clicking the "?" button links the user to the customer support page | 3 | Necessary | Satisfied |
|            032 |           012 | User can filter the available products by price | clicking "filters..." and "price" and selecting price maximum will tell the system to only list products within the given price range and it correctly shows on the UI | 8 | Necessary | working |
|            033 |           012 | User can sort the available products by price | clicking the "sort by..." and "price" will tell the system to sort the product list by price lowest->highest | 8 | Necessary | Important |
|            034 |           011 | User can see the list of all reviews made by other users | A chart of all reviews for the product is visible. | 21 | Important | Satisfied |
|            035 |           011 | User can make a review for a product. | User is able to type a review for the product, provide a star rating, and submit their review. | 21 | Important | Satisfied |
|            036 |           011 | User can make a star rating on the product | Clicking on the choice box will allow for the user to choose a rating of their choice. | 21 | Important | Satisfied |
|            037 |           011 | User can write a review on the product | There is a text field that allows the user to type their review. | 21 | Important | Satisfied |
|            038 |           011 | The review is stored into the database after the confirm button is clicked | The database contains the review with the star rating. | 21 | Important | Working |
|            039 |           022 | There should be a table that shows every product user own. | User should be able to see the list of all of the products they own. | 9 | Important | Satisfied |
|            040 |           022 | There should be links to home page and profile page from library page. | User should be able to navigate to other pages via library page. | 4 | Important | Satisfied |




