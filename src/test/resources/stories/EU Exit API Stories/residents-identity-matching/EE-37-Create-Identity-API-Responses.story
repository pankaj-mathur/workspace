Scenario: Customer matches with no first name
Meta:
@manual

Given the customer matches, using the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
When the endpoint is called with the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
Then the API responds with a 200 response
And the body should contain 'status: FOUND'

Examples:
| ninoQ 	 | surnameQ | dateOfBirthQ | firstnameQ | corrIdH |
| AA123456A | 	Adamson | 01-Jan-1900   | 	-  		|   1     |


Scenario: Customer doesn't match and no firstname provided

Given the customer doesn't match, using the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
When the endpoint is called with the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
Then the API responds with a 200 response
And the body should contain 'status: NOT_FOUND'

Examples:
| ninoQ 	 | surnameQ | dateOfBirthQ | firstnameQ | corrIdH |
| XX123456 | 	Xenio   | 01-Jan-1900   | 	-  		|   10     |



Scenario: Customer matches and first name provided

Given the customer matches, using the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
When the endpoint is called with the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
Then the API responds with a 200 response
And the body should contain 'status: FOUND'

Examples:
| ninoQ 	 | surnameQ | dateOfBirthQ   | firstnameQ   | corrIdH |
| AA123456A | 	Adamson   | 01-Jan-1900   | 	Adam  	|   1     |


Scenario: Customer doesn't match and firstname provided

Given the customer doesn't match, using the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
When the endpoint is called with the parameters [ninoQ], [surnameQ], [dateOfBirthQ], [firstnameQ], [corrIdH]
Then the API responds with a 200 response
And the body should contain 'status: NOT_FOUND'

Examples:
| ninoQ 	 | surnameQ | dateOfBirthQ   | firstnameQ   | corrIdH |
| AA12345 	 | 	Allam   | 01-Jan-1900   | 	Joe  		|   1     |
| 150 		 | 	Adamso  | 01-Jan-1900   | 	John  		|   2     |
| AA12345 	 | 	Smith   | 01-Jan-1900   | 	West  		|   3     |
| AA123456   |	Adamson | 01-Jan-1900   | 	Adam    	|   1     |





