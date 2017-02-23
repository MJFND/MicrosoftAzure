<b>Setting Up the Basics of Microsoft Azure Platform </b><br />
Before proceeding create a Microsoft account and signup for azure service, it will require few steps before you can start using these services. Once done, go to the <a href="https://portal.azure.com/" target="_blank">Azure Portal</a>.

<b>How to create non Classic version of Azure Blob storage account?</b><br />
To create the storage account, go to new > Storage > Storage account.

<p align="center"><img src="Media/1.png?raw=true"></p>

Enter your name and select the details. To create a non-classic account, let the deployment model be Resource Manager (Default), once done press create. 

<p align="center"><img src="Media/2.png?raw=true"></p>

<b>How to create a container?</b><br />
To create container in the storage account, select the storage, and scroll down the left side bar, you will see the containers option under blob service.
Press Containers then add container from the top.

<p align="center"><img src="Media/3.png?raw=true"></p>

Now enter the name and select the access type (For Public or Private), press create.

<p align="center"><img src="Media/4.png?raw=true"></p>


<b>How to see the containers in the storage account?</b><br />
To see containers associated with that storage account, simply click the containers under blob service as done before. The main section will list down all the containers along with their details.

<p align="center"><img src="Media/5.png?raw=true"></p>

<b>How to upload data to container?</b><br />
To upload data to container press the container name (container1, see the last image), and then press upload.

<p align="center"><img src="Media/6.png?raw=true"></p>

Select the file to upload, select blob type and size, press upload.

<p align="center"><img src="Media/7.png?raw=true"></p>

<b>How to see items inside the containers?</b><br />
To see all the items associated with that containers, click the container section, and then name. It will list down all the items in that container.

<p align="center"><img src="Media/8.png?raw=true"></p>

<b>How to delete an item in a container?</b><br />
To delete item in a container, select the item and click delete from the right top corner.

<p align="center"><img src="Media/9.png?raw=true"></p>

<b>How to delete a container?</b><br />
To delete container, select the container and click the delete container button.

<p align="center"><img src="Media/10.png?raw=true"></p>

<b>How to delete the storage account?</b><br />
To delete the storage account, click overview and then press the delete button in the next window.

<p align="center"><img src="Media/11.png?raw=true"></p>

<b>Creating a simple program in Java using Eclipse on Azure platform</b><br />
Before creating a program in Java, we need to ensure that all the tools are installed correctly. For Azure tools we need the following:<br />
•	Eclipse IDE for Java EE Developers, Luna or later.<br />
•	Java Development Kit, 1.8 or later<br />
Supported Operating Systems:<br />
•	Windows 7 or later<br />
•	Ubuntu Linux Versions 12 or later<br />
•	Mac OS X Versions "Yosemite" and "El Captain"<br />

Azure tools for Eclipse can be installed from the help tab in the Eclipse.

<p align="center"><img src="Media/12.png?raw=true"></p>

You will need to enter http://dl.microsoft.com/eclipse in the “work with” text field, this will show the required tools that you need to download.

<p align="center"><img src="Media/13.png?raw=true"></p>

Press next and agree to the terms, it will take few minutes to download and install. Once done, you will need to restart the eclipse.

<b>Now to create your first program in Java using Azure tools.</b><br />
Create a Dynamic Web Project from the file tab. Enter the name, select the details and press finish.

<p align="center"><img src="Media/14.png?raw=true"></p>

Now right click on the project name and add a jsp page, it will prompt a new window asking for the name of the jsp file.

<p align="center"><img src="Media/15.png?raw=true"></p>

Now enter the following command in your jsp page.
<% out.println("Welcome to Azure!"); %>

You are done with the jsp, now its to make it work with Azure.
Right click the project and select Publish as Azure Web App in the Azure tab.

<p align="center"><img src="Media/16.png?raw=true"></p>

A new window will open asking for the Azure account credentials, fill it and press sign in.
The following window will appear, press new. 
<p align="center"><img src="Media/17.png?raw=true"></p>

Fill the details in the basic tab. If you don’t have app service plan or resource group you press the corresponding "new" button.
<p align="center"><img src="Media/18.png?raw=true"></p>

Then switch to JDK tab and do the following, then press Ok.
<p align="center"><img src="Media/19.png?raw=true"></p>

Now press OK in the following window.
<p align="center"><img src="Media/20.png?raw=true"></p>

You can now see your app published at Azure Activity Log.  

<p align="center"><img src="Media/22.png?raw=true" width="60%"></p>

Also, you can see the details of your azure account in the Azure Explorer tab. You can also delete, restart, stop or open the app in browser.

<p align="center"><img src="Media/21.png?raw=true"></p>

The browser result:
<p align="center"><img src="Media/23.png?raw=true"></p>

To update the app, simply make changes and publish the app at azure, it will take few seconds because you are already connected to your Azure account.
