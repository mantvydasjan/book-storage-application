# Book-storage application

### Endpoints list:

#### Book controller
| Method    | Mapping                     | Description                                                               |
|-----------|-----------------------------|---------------------------------------------------------------------------|
| **POST**  | /books                      | put a book into the system                                                |
| **GET**   | /books/{barcode}            | retrieve book’s information                                               |
| **PATCH** | /books/update/{barcode}     | update any of its detail providing the barcode                            |
| **GET**   | /books/totalPrice/{barcode} | calculate the total price                                                 |
| **GET**   | /books                      | request a list of all barcodes for the books in stock grouped by quantity |

#### Antique Book controller
| Method    | Mapping                       | Description                                                               |
|-----------|-------------------------------|---------------------------------------------------------------------------|
| **POST**  | /antique                      | put a book into the system                                                |
| **GET**   | /antique/{barcode}            | retrieve book’s information                                               |
| **PATCH** | /antique/update/{barcode}     | update any of its detail providing the barcode                            |
| **GET**   | /antique/totalPrice/{barcode} | calculate the total price                                                 |

#### Science Journals controller
| Method    | Mapping                          | Description                                                               |
|-----------|----------------------------------|---------------------------------------------------------------------------|
| **POST**  | /journals                        | put a book into the system                                                |
| **GET**   | /journals/{barcode}              | retrieve book’s information                                               |
| **PATCH** | /journals/update/{barcode}       | update any of its detail providing the barcode                            |
| **GET**   | /journals/totalPrice/{barcode}   | calculate the total price                                                 |

Book entity JSON example: 

{
"barcode": 78482331,
"name": "Thinking in Java",
"author": "Bruce Eckel",
"quantity": 40,
"pricePerUnit": 39.99
}

Antique Book entity JSON example: 

{
"barcode": 98753,
"name": "The Queen",
"author": "N. Ortega",
"quantity": 3,
"pricePerUnit": 299,
"releaseYear": 1900
}

Science Journal entity JSON example:

{
"barcode": 98759,
"name": "Computers",
"author": "Uncle BOB",
"quantity": 9,
"pricePerUnit": 19,
"scienceIndex": 2
}