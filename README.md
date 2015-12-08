### Team Members:
- Lanny Wong
- Nathan Wuenstel
- Brandon Ciancio

### Project Goal: 
Create a web-service that sends an email to one or many users. The email recipients and email contents are based on parameters. The parameters that we would require are: a collection of emails, a subjectLine, and messageContent.
				   
### Rest url + paths
* BASE URL: http://tomcat-mademailservice.rhcloud.com/NewEmailWebservice_war
* /rest/sendEmail/test
	* This returns a string "Hey it Worked"
* /rest/sendEmail/{sbj}/{msg}/{recipient}"
	* sbj / msg / recipient = normal string. 
* /rest/sendEmail/personalize/{sbj}/{msg}/{"recipients":[{"email":"A_EMAIL","name":"A_NAME"},{"email":"A_EMAIL","name":"A_NAME"}]}
	* sbj / msg = normal string
	* recipients = a jsonString follow the template.
	
### How to use our Email Webservice:
- Two different URL path options 
	- one takes an arrary of recipients' address in string form
	- one takes an array of reciptient objects
