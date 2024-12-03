<img src="/src/main/resources/images/passportFullWhite.png" alt="Passport logo" width="200">

## Overview
Passport is a secure and efficient password manager designed for multiple users, compatible with both Linux and Windows systems.

## Features
- Support for multiple users
- Account activity history 
- Password storage
- Text note storage
- Credit card storage
- Inbuild password generator
- Item categories
- Filtering and searching of items 

## Build instructions 
### Prerequisites
Before building Passport, ensure you have the following installed:
- Git
    - `sudo apt install git`
    - `winget install git`
- Java 17+
    - `sudo apt install openjdk-17-jdk`
    - `winget install eclipse-adoptium.temurin.17.jdk`
- Apache Netbeans
    - `sudo snap install netbeans --classic`
    - `flatpak install flathub org.apache.netbeans`
    - `winget install apache.netbeans`

### Building via Apache Netbeans 
1. Clone the repository: `git clone https://github.com/flarom/passport`
2. Open NetBeans and load the project:
    1. Launch Apache Netbeans
    2. Select **File > Open project**
    3. Navigate to and select the cloned Passport folder
3. Build and run the project:
    Press **F6** to compile and execute Passport

## Code structure
  ### Source Packages
<table>
<tr><td>passport        </td><td>Responsible for program initialization, configuration and main screen                                               </td></tr>
<tr><td>Dialogs.Editors </td><td>Responsible for editing/creating items in the database through graphical interfaces                                 </td></tr>
<tr><td>Dialogs.Logon   </td><td>Responsible for logging in/creating accounts for the database                                                       </td></tr>
<tr><td>Dialogs.Misc    </td><td>Responsible for various dialogs, such as a document viewer or a color picker                                        </td></tr>
<tr><td>Helpers         </td><td>Responsible for additional support for program screens, such as helping to control the application with a keyboard  </td></tr>
<tr><td>Objects         </td><td>Responsible for database objects, and representing some of the objects graphically.                                 </td></tr>
</table>

## Used libs
- [Swing](https://docs.oracle.com/javase/6/docs/technotes/guides/swing/)
- [SQLite JDBC](https://github.com/xerial/sqlite-jdbc)
- [Flyway](https://github.com/flyway/flyway)
- [FlatLaf](https://github.com/JFormDesigner/FlatLaf)
- [Txtmark](https://github.com/rjeschke/txtmark)
---

<img src="/src/main/resources/images/passportTinyWhite.png" alt="passportTinyWhite" width="100" align="right">
