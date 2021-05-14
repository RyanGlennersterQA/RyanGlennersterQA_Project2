Coverage 81.9%

Welcome to my Car Park Manager. This project has a functioning front end made using HTML, CSS and Javascript which
interacts with a back end made with a Java Spring Framework. It uses a MySQL database to store bookings and allows the user
to have full CRUD Functionality directly from the front end.

Getting Started

The project has been constantly saved through GitHub. You can get your own local copy. Once in the revelevant GitHub
repository you can proceed to fork and clone it.

1) Go to https://github.com/RyanGlennersterQA/RyanGlennersterQA_Project2

2) Once you're at this location, proceed to fork the repository which will take a copy of the project and move it to your personal git hub where you can open it. You do this by pressing fork in the top right corner.

3) Once you have your own copy you would need to make as clone of the project on your local machine. Open the location you would like the project to be stored (e.g Documents).

4 ) In the file explorer, right click and press git bash here.

5) When git opens use the command 'git clone' followed by the link of the repository of the project. The link is found by pressing the green 'code' button when you have the repository open and copying the url.

6) This will make a file in your desired location that you can edit or look at.

Opening the JAR file This project has also been saved in a jar file, which, if you just want to use the project and have no plans of editing anything would be the prefered way to open it.

To do this simply open up yourt command line or GIT Bash. You can then use the command 'java -jar' followed by the file name to run the project.



Prerequisites - Back End

What things you need to install the software and how to install them

As this project is written in Java you are going to need the latest version of java installed on your device.

To download java you can visit this link: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html When this link opens scroll down and make sure you're installing the correct version for your device. It will vary depending on operating system (MAS OS/Windows/Linux).

Once you have downloaded the relevant file it will be saved into your downloads. Using file explorer navigate to your downloads (on the left side of ther file explorer you should be able to press 'downloads'). Find the executable file, named something along the lines of 'jdk-14.0.1_window-x64_bin.exe"/"jdk-8u221-windows-x64.exe' and run it.

You will be presented with a pop up window that will guide you through the installation. For all of the windows I advise to just press next until everything is installed and you will finally be presented with a wiindow with a close button. On this screen it should tell you that 'java se development kit has been installed'. After you see this message press close and it is successfully installed.

Setting the environment variables on your PC (Windows).

Now java JDK has been installed there is one last thing to do.

Press the windows key (or just the 'tap here to search' in the bottom left corner of your screen) and search for path. Open this and then locate 'Edit the system environment variables'.

A system properties menu should open.

Locate 'Advanced' in the top menu and open this tab and then selecet environment variables at the bottom of this window.

Now we are going to chnage the system variables in this window. Select 'new...' In the pop up window we will be instructed to enter a variable name and value. In the name call it JAVA_HOME and for the value we want it to direct to out JDK folder. This will usually be found in your C drive, program files, Java and then the version you downloaded.

Press okay and you should now have your newly created variable in your variables.

Now to edit the path variable. In the same place as your JAVA_HOME variable you should be able to find a path variable. Now press edit (next to new... you pressed earlier).

You are now going to add the JAVA_HOME variable into this path we can do this by adding in: ;%JAVA_HOME%\bin;. Make sure to have the semi colons before and after and press 'ok' when you are satisfied it is done.

Now we are going to check this has worked. Again going down to the bottom left of your screen in the search section type in 'cmd' and hit enter.

Once cmd opens type in 'java' and press enter This should run and give you all the information about the java on your device. You can also check your version by typing java -version.

FOR DEVELOPMENT AND TESTING PURPOSES To open up the project for development and testing purposes you would need to instal maven, eclipse and spring boot.



Prerequisites - Front End

To Edit the front-end you will need to have access to Visual Studio Code.
Depending on which operating system you're on will depend on which download you follow.

First of all vist the link - https://visualstudio.microsoft.com/downloads/

Once on the link, locate the section for your operating system.

Follow the link to download the 'free' version and follow the instructions to download the software onto your device.

Visual Code will allow you to open and then edit the HTML, Javascript and CSS but the Front-End testing is done in eclipse.



Testing

For this project I used JUnit, Maven and selenium. The tests are stored within the eclipse file for the project. To locate these open CarParkManager the tests are in src/main/test.
The tests are split up into integration test, unit tests which are done on the controller and service class respectively.
Selenium is split up into pages and tests. The pages are home to all the web elements located on that page. The test class for those pages are home to the actual tests.

The aim of the testing was to primarily test the CRUD Functionaliies. I aimed for the 80% coverage.

Once you locate the test class, you can run the tests yourself. In the test class anything with the @Test annotation if the test. Right click on the tests and select 'run as' and choose JUnit.
The test will automatically run for you and show you the result.



Jira Board
https://ryanglennersterqa.atlassian.net/jira/software/c/projects/CPMB/boards/4/roadmap



License
This project is licensed under the MIT license - see the LICENSE.md file for details.




