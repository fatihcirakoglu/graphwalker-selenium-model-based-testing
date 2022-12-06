# graphwalker-selenium-model-based-testing
Demonstration  of Model Based testing with Graphwalker and Selenium

- This project tests https://www.pazarama.com/ with 4 test cases using Grapwlker and Selenium frameworks with the
help of model based testing. 

1. PazaramaLoginLogout
This test is created to test login and logout path with happy path. 
![PazaramaLoginLogout](https://user-images.githubusercontent.com/33651899/205932379-ae14515b-b9a4-401f-bc1a-b244849daa0e.JPG)

2. PazaramaFailLogin
This test is created to test login fail scenario with wrong password within sad path. 
![PazaramaFailLogin](https://user-images.githubusercontent.com/33651899/205932441-fb3be717-df4c-403f-9cf6-2073e90f3121.JPG)

3. PazaramaSearchItem
This test is created for verifying search functionality within happy path
![PazaramaSearchItem](https://user-images.githubusercontent.com/33651899/205932513-8e2ae275-6fbd-4b60-ad97-72498dbef5fa.JPG)

4. PazaramaAddShoppingCart
This test is created for verifying search functionality within happy path
![PazaramaAddShoppingCart](https://user-images.githubusercontent.com/33651899/205932558-3a3b6b68-a16e-4994-889d-10bc688ec660.JPG)

- All implemented test cases are in below path int the project: 
...\src\main\java\com\company

- For running the test cases, just go to project folder and run:
mvn -X compile exec:java -Dexec.cleanupDaemonThreads=false -Dexec.mainClass="com.company.Runner"

- For opening Grapwalker Models:
1. Run below command on commanline 
java -jar graphwalker-studio-4.3.2.jar
2. Open a browser and use url:
http://localhost:9090/studio.html
