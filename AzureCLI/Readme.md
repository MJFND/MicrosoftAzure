<b>Managing Azure Services using Azure CLI</b><br />
Azure CLI is a cross-platform command line tool that allows users to manage all Azure features directly from the personal computers. Azure CLI can create, modify delete clusters, storage accounts and other required services.

<b>Azure CLI will require you to login to your Azure account, type the following command.</b><br />
```
azure login -u myUserName@contoso.onmicrosoft.com
```
You will be prompted to type the password.
Once you have logged in, now you can manage Azure services.

<b>In order to create a resource group switch to resource manager mode.</b><br />
```
azure config mode arm
```

<b>Create a resource group with the following command. Resource group contains all the resources for Azure solution. <a href="https://docs.microsoft.com/en-us/azure/azure-resource-manager/resource-group-overview" target="_blanl">Learn More</a></b><br />
```
azure group create groupname location.
```
Groupname: a unique name for that group.<br />
Location: location for the group. <br />
To get the list of location.<br />
azure location list<br />

<b>Creating a Storage account.</b><br />
```
azure storage account create -g groupname --sku-name RAGRS -l location --kind Storage storagename
```
Groupname: the name of the group you created in the last step.<br /><br />
Location: the location you picked in the last step.<br />
Storagename: a unique name for your storage account.<br />
For help on the storage account:
```
azure storage account create –h
```

<b>Retrieving Key for Storage account.</b><br />
```
azure storage account keys list -g groupname storagename
```
Replace the following parameters:
Groupname: the group name of the resource.<br />
Storagename: the name of the storage.<br />

<b>Creating a container. A container is a part of Storage account, it is like a folder that keeps the Blobs. While blob can keep all types of data.</b><br />
```
azure storage container create -n container_name
```
Replace container_name with your desired name.<br />
To set access to that container use:<br />
--public-access off/blob/container<br />
Off: Container data is private to the account owner.<br />
blob: Public read access for blobs.<br />
container: Public read and list access to the entire container.<br />

<b>Listing down all the containers in the storage account.</b><br />
```
azure storage container list
```
<b>Uploading Blob to a container.</b><br />
```
azure storage blob upload -f local_file_path -c container_name -n blob_name
```
local_file_path: the file path you want to upload from your pc.<br />
container_name: name of the container where you want to upload the blob<br />
blob_name: the name of the blob<br />

<b>Listing Down all the items in the container.</b><br />
```
azure storage blob list container-name
```
container-name: replace it to the name of the container.

<b>Deleting an item in a container.</b><br />
```
azure storage blob delete container_name blob_name
```
container_name: name of the container <br />
blob_name: name of the file you want to delete <br />

<b>Deleting a container in the storage account.</b><br />
```
azure storage delete container_name
```
container_name: name of the container you want to delete.

<b>Deleting the storage account.</b><br />
```
azure storage account delete name
```
name: name of the account you want to delete.

