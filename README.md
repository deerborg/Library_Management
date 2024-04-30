# Library Management System API

This project provides a RESTful API for managing various operations in a library management system. It includes controllers for managing books, authors, categories, publishers, and book borrowing operations.

## BookBorrowingController

This controller manages book borrowing operations.

| Endpoint                           | HTTP Method | Description                                           |
|-----------------------------------|-------------|-------------------------------------------------------|
| /v1/authors/{id}                  | GET         | Retrieves information about a specific book borrowing.|
| /v1/authors                       | POST        | Creates a new book borrowing record.                  |
| /v1/authors                       | POST        | Updates an existing book borrowing record.            |
| /v1/authors/{id}                  | DELETE      | Deletes a specific book borrowing record.             |
| /v1/authors                       | GET         | Retrieves all book borrowing operations paginated.    |

## AuthorController

This controller manages author operations.

| Endpoint                           | HTTP Method | Description                                           |
|-----------------------------------|-------------|-------------------------------------------------------|
| /v1/authors/{id}                  | GET         | Retrieves information about a specific author.        |
| /v1/authors                       | POST        | Creates a new author record.                          |
| /v1/authors                       | PUT         | Updates an existing author record.                    |
| /v1/authors/{id}                  | DELETE      | Deletes a specific author record.                     |
| /v1/authors                       | GET         | Retrieves all authors paginated.                      |

## BookController

This controller manages book operations.

| Endpoint                           | HTTP Method | Description                                           |
|-----------------------------------|-------------|-------------------------------------------------------|
| /v1/books/{id}                    | GET         | Retrieves information about a specific book.          |
| /v1/books                         | POST        | Creates a new book record.                            |
| /v1/books                         | PUT         | Updates an existing book record.                      |
| /v1/books/{id}                    | DELETE      | Deletes a specific book record.                       |
| /v1/books                         | GET         | Retrieves all books paginated.                        |

## CategoryController

This controller manages category operations.

| Endpoint                           | HTTP Method | Description                                           |
|-----------------------------------|-------------|-------------------------------------------------------|
| /v1/categories/{id}               | GET         | Retrieves information about a specific category.      |
| /v1/categories                    | POST        | Creates a new category record.                        |
| /v1/categories                    | POST        | Updates an existing category record.                  |
| /v1/categories/{id}               | DELETE      | Deletes a specific category record.                   |
| /v1/categories                    | GET         | Retrieves all categories paginated.                   |

## PublisherController

This controller manages publisher operations.

| Endpoint                           | HTTP Method | Description                                           |
|-----------------------------------|-------------|-------------------------------------------------------|
| /v1/publishers/{id}               | GET         | Retrieves information about a specific publisher.     |
| /v1/publishers                    | POST        | Creates a new publisher record.                       |
| /v1/publishers                    | PUT         | Updates an existing publisher record.                 |
| /v1/publishers/{id}               | DELETE      | Deletes a specific publisher record.                  |
| /v1/publishers                    | GET         | Retrieves all publishers paginated.                   |
