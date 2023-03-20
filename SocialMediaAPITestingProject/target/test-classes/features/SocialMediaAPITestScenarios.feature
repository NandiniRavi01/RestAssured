Feature: Social Media API

Scenario: User can create a new post
Given a user is logged in
When the user creates a new post with desired text
Then the post should be created successfully

Scenario: User can comment on a post
Given a user is logged in
When the user comments on a post
Then the comment should be submitted successfully

Scenario: User can view a list of users
Given a user is logged in
When the user sends a request to view the list of all users
Then the list of all users should be retuned successfully

Scenario: User can filter and view specific user
Given a user is logged in
When the user searches based on "<Criteria>" "<Value>"
Then the user details should be fetched and displayed for the customer

Examples:
|Criteria|Value|
|name|Leanne Graham|
|id|2|
|username|Bret|
|website|ambrose.net|
|email|Sherwood@rosamond.me|

Scenario: To verify if the posts by a particular user is retrieved when the condition is satisfied
Given a user is logged in
When the user tries to retrieve posts based on "<Criteria>" "<Value>"
Then the posts should be retrieved
Examples:
|Criteria|Value|
|userId|1|
|id|5|

Scenario: To verify if the comments on a particular post can be retrieved
Given a user is logged in
When the user tries to retrieve comments on a post based on "<Criteria>" "<Value>"
Then the comments should be retrieved
Examples:
|Criteria|Value|
|postId|2|
|email|Jeremy.Harann@waino.me|

Scenario: User can retrieve all the posts
Given a user is logged in
When the user sends a request to view all the posts
Then all the posts should be fetched successfully

Scenario: User can retrieve all the comments
Given a user is logged in
When the user sends a request to view all the comments
Then all the comments should be fetched successfully

Scenario: User can delete a post
Given a user is logged in
When the user sends a request to delete a post
Then the post should be deleted successfully

Scenario: User can delete a comment
Given a user is logged in
When the user sends a request to delete a comment
Then the comment should be deleted successfully

Scenario: User can edit a post
Given a user is logged in
When the user edits the post
Then the post should be updated successfully

Scenario: User can edit a comment
Given a user is logged in
When the user edits the comment
Then the comment should be updated successfully

Scenario: User can update a post using patch method
Given a user is logged in
When the user edits the post using patch method
Then the post should be updated successfully

Scenario: User can update a comment using patch method
Given a user is logged in
When the user edits the comment using patch method
Then the comment should be updated successfully