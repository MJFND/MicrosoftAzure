<h1><b>Managing Azure Services using Powershell</b></h1>
Azure Powershell is a tool that allows users to manage all Azure features directly from their computers. It helps to manage the Azure services using a command line interface.
<br />

<br /><b>Downloading Azure PowerShell.</b><br />
Incase you need to download the Power Shell, follow this <a href="https://github.com/Azure/azure-powershell/releases/tag/v3.6.0-February2017" target="_blank">Guide</a>.


<br /><b>HDInsight</b><br /> 
Microsoft Azure HDInsight Azure HD Insight is a service that provides Hadoop/Spark/HBase based clusters that run over Azure Cloud Platform.  These clusters provide solutions to manage, analyze and visualize the reports on big data.

Before proceeding following Azure Services are required:<br /> 
•	Azure Log In<br /> 
•	Azure resource group<br /> 
•	Azure Storage account<br /> 
•	Azure Blob container<br /> 
How to create? Follow this <a href="https://docs.microsoft.com/en-us/azure/storage/storage-powershell-guide-full#how-to-manage-azure-blobs" target="_blank">Guide</a>. 

<br /><b>Creating HDInsight Cluster.</b><br />
The following command stores the key in the storagekey variable.
```
$storagekey = (Get-AzureRmStorageAccountKey -Name effendistorage -ResourceGroupName mygroup)[0].Value
```

The following command creates a cluster. You will be prompted to type a unique username and password for each of the first two statements.
```
$credentials = Get-Credential -Message <user_credential>  -UserName "admin"
$sshCredentials = Get-Credential -Message <ssh_credential>  

New-AzureRmHDInsightCluster `
    -ClusterName <clusterName> `
    -ResourceGroupName <resourceGroupName> `
    -HttpCredential $credentials `
    -Location <location>`
    -DefaultStorageAccountName <storage_account> `
    -DefaultStorageAccountKey $storagekey `
    -DefaultStorageContainer <container_name> `
    -ClusterSizeInNodes <cluster_size> `
    -ClusterType <cluster_type> `
    -OSType <ostype> `
    -Version "3.4" `
    -SshCredential $sshCredentials
```

Replace all the names present between <> with the required/desired options.

<br /><b>Deleting HDInsight Cluster.</b><br />
```
Remove-AzureRmHDInsightCluster -ClusterName <Cluster_Name>
```
Cluster_Name: name of the cluster you want to delete
