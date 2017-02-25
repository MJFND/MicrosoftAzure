<h1><b>Managing Azure Services using Azure CLI</b><h1><br />
Azure CLI is a cross-platform command line tool that allows users to manage all Azure features directly from their computers. Azure CLI can create, modify delete clusters, storage accounts and other required services.<br />

<br /><b>Setting up Azure CLI</b><br />
Before Procceding, you need to install the Azure CLI, follow this <a href="https://docs.microsoft.com/en-us/azure/xplat-cli-install" target="_blank">Guide</a>.
<br />
<br />
<b>Azure CLI will require you to login to your Azure account, type the following command.</b><br />
```
azure login -u myUserName@contoso.onmicrosoft.com
```
You will be prompted to type the password.
Once you have logged in, now you can manage Azure services.


<br /><b>In order to create a resource group switch to resource manager mode.</b><br />
Resource group contains all the resources for Azure solution. <a href="https://docs.microsoft.com/en-us/azure/azure-resource-manager/resource-group-overview" target="_blank">Learn More</a>
```
azure config mode arm
```

<br /><b>Create a resource group with the following command. </b><br />
```
azure group create groupname location.
```
<i>Groupname</i>: a unique name for that group.<br />
<i>Location</i>: location for the group. <br />
To get the list of location.<br />
```
azure location list
```

<br /><b>Creating a Storage account.</b><br />
```
azure storage account create -g groupname --sku-name RAGRS -l location --kind Storage storagename
```
<i>Groupname</i>: the name of the group you created in the last step.<br />
<i>Location</i>: the location you picked in the last step.<br />
<i>Storagename</i>: a unique name for your storage account.<br />
For help on the storage account:
```
azure storage account create –h
```

<br /><b>Retrieving Key for Storage account.</b><br />
```
azure storage account keys list -g groupname storagename
```
<i>Groupname</i>: the group name of the resource.<br />
<i>Storagename</i>: the name of the storage.<br />

<br /><b>Creating a container. </b><br />
A container is a part of Storage account, it is like a folder that keeps the Blobs. It is used to maange the data easily. While blob is a file of any type or size.<br />
```
azure storage container create -n container_name
```
<i>container_name</i>: replace with your desired name.<br />
To set access to that container use:<br />
```
--public-access off/blob/container
```
<i>Off</i>: Container data is private to the account owner.<br />
<i>blob</i>: Public read access for blobs.<br />
<i>container</i>: Public read and list access to the entire container.<br />

<br /><b>Listing down all the containers in the storage account.</b><br />
```
azure storage container list
```
<br /><b>Uploading Blob to a container.</b><br />
```
azure storage blob upload -f local_file_path -c container_name -n blob_name
```
<i>local_file_path</i>: the file path you want to upload from your pc.<br />
<i>container_name</i>: name of the container where you want to upload the blob<br />
<i>blob_name: the</i> name of the blob<br />

<br /><b>Listing Down all the items in the container.</b><br />
```
azure storage blob list container-name
```
<i>container-name</i>: replace it to the name of the container.

<br /><b>Deleting an item in a container.</b><br />
```
azure storage blob delete container_name blob_name
```
<i>container_name</i>: name of the container <br />
<i>blob_name</i>: name of the file you want to delete <br />

<br /><b>Deleting a container in the storage account.</b><br />
```
azure storage delete container_name
```
<i>container_name: name of the container you want to delete.

<br /><b>Deleting the storage account.</b><br />
```
azure storage account delete name
```
<i>name</i>: name of the account you want to delete.

