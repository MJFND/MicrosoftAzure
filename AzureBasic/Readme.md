Before proceeding create a Microsoft account and signup for azure service, it will require few steps before you can start using these services. Once done, go to the portal.azure.com.

<b/>How to create non Classic version of Azure Blob storage account?</b></br>
To create the storage account, go to new>Storage>New Storage account.

![Alt text](/MicrosoftAzure/AzureBasic/media/1.jpg?raw=true)

Enter your name and select the details. To create a non-classic account, let the deployment model be Resource Manager (Default), once done press create. 

![Alt text](media/2.png?raw=true)

How to create a container?
To create container in the storage account, select the storage, and scroll down the left side bar, you will see the containers option under blob service.

![Alt text](media/3.png?raw=true)

Press Containers then add container from the top.

![Alt text](media/4.jpg?raw=true)

Now enter the name and select the access type (For Public or Private), press create.

How to see the containers in the storage account?
To see containers associated with that storage account, simply click the containers under blob service as done before. The main section will enlist all the containers along with their details.

How to upload data to container?
To upload data to container press the container name (container1, see the last image), and then press upload.
Select the file to upload, select blob type and size, press upload.

How to see items inside the containers?
To see all the items associated with that containers, click the container section, and then name. It will list down all the items in that container.

How to delete an item in a container?
To delete item in a container, select the item and click delete from the right top corner.

How to delete a container?
To delete container, select the container and click the delete container button.

How to delete the storage account?
To delete the storage account, click overview and then press the delete button in the next window.

Creating a simple program in Java using Eclipse on Azure platform
Before creating a program in Java, we need to ensure that all the tools are installed correctly. For Azure tools we need the following:
•	Eclipse IDE for Java EE Developers, Luna or later.
•	Java Development Kit, 1.8 or later
Supported Operating Systems:
•	Windows 7 or later
•	Ubuntu Linux Versions 12 or later
•	Mac OS X Versions "Yosemite" and "El Captain"

Azure tools for Eclipse can be installed from the help tab in the Eclipse.
You will need to enter http://dl.microsoft.com/eclipse in the “work with” text field, this will show the required tools that you need to download.
Press next and agree to the terms, it will take few minutes to download and install. Once done, you will need to restart the eclipse.

Now to create your first program in Java using Azure tools.
Create a Dynamic Web Project from the file tab. Enter the name, select the details and press finish.
Now right click on the project name and add a jsp page, it will prompt a new window asking for the name of the jsp file.

Now enter the following command in your jsp page.
<body><b><% out.println("Welcome to Azure!"); %></b></body>

You are done with the normal process, now its to make it work with Azure.
Right click the project and select Publish as Azure Web App in the Azure tab.
A new window will open asking for the Azure account credentials, fill it and press sign in.
The following window will appear, click new. 

Fill the details in the basic tab. If you don’t have service plan or resource you press the corresponding new button.

Then switch to JDK tab and do the following.

Now press OK.

You can now see your app published at Azure. Also, you can see the details of your azure account in the Azure Explorer tab. 

You can also delete, restart, stop or open the app in browser.


The browser result:


To update the app, simple make changes and publish the app at azure, it will take few seconds because you are already connected to your Azure account.
