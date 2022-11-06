# Assignment #6: Product CRUD complementation.

Implement the missing methods of the product module according to the endpoint format.

* Controller
    * Implement a getProduct method.
    * Implement a getProductStock method.

* Repository
    * Implement the signature of a method that allows querying a product by its GTIN code and with status 1.
    
* Service
    * Implement the createProduct method considering the following validations:
        - Validate that the new product category exists. 
        - The GTIN code and product name are unique.
        - If when trying to make a new registration there is already a product with the same GTIN but it has status 0, 
        then you must change the status of the existing product to 1 and update its data with those of the new registration.
