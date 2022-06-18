<div id="top"></div>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
Powered By
<img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot" />

[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Issues][issues-shield]][issues-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/Group-20-ADP/School_Managemente">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">Group 20</h3>

  <p align="center">
    A Milestone Project
    <br />
    <a href="https://github.com/Group-20-ADP/School_Management"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Group-20-ADP">View Organization</a>
    ·
    <a href="https://github.com/Group-20-ADP/School_Management/issues">Report Bug</a>
    ·
    <a href="https://github.com/Group-20-ADP/School_Management/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

In the quest for seamless and effective organisational processes in a college, the technology
department of the college has been given the task to digitize and automate its academic-facing
processes.
The technology department has decided to use Domain Driven Design to actualize this. A section of
the technology team was given the responsibility to solicit requirements based on the as-is processes.
Thus, after many analysis meetings, they have come up with a domain model. A section of the domain
model is presented below:

[![Product Name Screen Shot][product-screenshot]](https://example.com)

<p align="right">(<a href="#top">back to top</a>)</p>



### Built With

Here's a list of Frameworks, IDE's and Libraries used throughout this application:

* [Spring_Boot](https://spring.io/projects/spring-boot)
* [Git](https://git-scm.com/)
* [Maven](https://maven.apache.org/)
* [Project_Lombok](https://projectlombok.org/)
* [MySql](https://mysql.com)
* [Apache_Commons](https://commons.apache.org/)
* [JUnit5](https://junit.org/junit5/)
* [Intellij IDEA](https://jetbrains.com/idea/)
* [Postman](https://www.postman.com/)
* [PHPMyAdmin](https://www.phpmyadmin.net/)


<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

The following is needed to run this application:

1. IDE(Preferably Intellij IDEA)
2. Git(vcs)
3. JDK 17
4. Wamp Server ==> SQL Server (Start Before running main application file)


### Installation

_Below is an on install the application on our environment:_

1. Get a free API Key at [https://example.com](https://example.com)
2. Clone the repo
   ```sh
   git clone https://github.com/Group-20-ADP/School_Management
   ```
3. Configure application.properties port and database port to your appropriate localhost:
   ```sh
    School_Management/src/main/resources/application.properties
    #port config
    server.port=8088 //set your custom port
    #dbconfig
    spring.datasource.url= jdbc:mysql://localhost:3306/schoolmanagementdb //(create dbname:schoolmanagementdb) and set your local port
    spring.datasource.username = root
    spring.datasource.password =
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    # Hibernate ddl auto (create, create-drop, validate, update)
    spring.jpa.hibernate.ddl-auto= update
    
    spring.jpa.properties.hibernate.show_sql = true
    spring.jpa.properties.hibernate.format_sql = true
   ```

4. Run SchoolManagementApplication.java (Entry Point)

<p align="right">(<a href="#top">back to top</a>)</p>




<!-- CONTACT -->
## Contact

Kurtney - 218138105@mycput.ac.za

Manasseh - 218009615@example.com

Amyr  - 214044750@mycput.ac.za

Athini - 213196379@mycput.ac.za

Aphiwe - 217157785@mycput.ac.za

Nur - 220014442@mycput.ac.za

Project Link: [https://github.com/Group-20-ADP/School_Management](https://github.com/Group-20-ADP/School_Management)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

Here's a list of helpful resources:

* [Stackoverflow](https://stackoverflow.com/questions/tagged/spring-boot)
* [Building an Application with Springboot](https://spring.io/guides/gs/spring-boot/)
* [Springboot_Tutorial](https://www.tutorialspoint.com/spring_boot/index.htm)
* [Organizing Layers Using Hexagonal Architecture, DDD, and Spring](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Group-20-ADP/School_Management?style=flat-square
[contributors-url]: https://github.com/Group-20-ADP/School_Management/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Group-20-ADP/School_Management?style=flat-square
[forks-url]: https://github.com/Group-20-ADP/School_Management/network/members
[issues-shield]: https://img.shields.io/github/issues/Group-20-ADP/School_Management?style=flat-square
[issues-url]: https://github.com/Group-20-ADP/School_Management/issues
[product-screenshot]: images/screenshot.png
