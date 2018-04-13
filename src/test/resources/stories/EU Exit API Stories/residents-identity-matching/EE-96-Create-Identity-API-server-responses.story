Scenario: Service not found

!-- Given a running instance of the residents identity matching microservice
When a customer submits a request for a non-existing entry point, such as notReal
Then return a 404 error code

Scenario: HTTP method used to contact the microservice is not GET
!-- Given a running instance of the residents identity matching microservice
When a customer submits a request using a HTTP method differing from GET
Then return a 405 error code

Scenario: Server error
!-- Given a running instance of the residents identity matching microservice
When an error is generated at the service's end
Then return a 500 error code 
And return an error type (internal server error)