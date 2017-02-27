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
How to do these four tasks? Follow this <a href="https://docs.microsoft.com/en-us/azure/storage/storage-powershell-guide-full#how-to-manage-azure-blobs" target="_blank">Guide</a>. 

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

<br /><b>MapReduce</b><br />
MapReduce is one of the most important part of Apache Hadoop framework. It allows users to process big amount of unstructured data across several computers with every node having its own storage.

<br /><b>Submitting a MapReduce job.</b><br />
Before submitting a job, we need to setup the required files path with the help of the following command.
```
$wordCountJobDefinition = New-AzureRmHDInsightMapReduceJobDefinition `
     -JarFile "File_path" `
     -ClassName "Class_name" `
     -Arguments `
         "Argument1", `
         "Argument2"
```
File_path: the jar file path e.g wasb:///example/jars/hadoop-mapreduce-examples.jar
ClassName: name of the class e.g wordcount
Argument1: the input file path e.g wasb:///example/data/gutenberg/davinci.txt
Argument2: the output file path e.g wasb:///example/data/WordCountOutput

Now submitting the job.
```
$cred=Get-Credential -Message "<credentials>"
$wordCountJob = Start-AzureRmHDInsightJob `
     -ClusterName clusterName `
     -JobDefinition $wordCountJobDefinition `
     -HttpCredential $cred
```
Credentials: enter login details for the cluster
clusterName: name of the cluster

Now the job is being executed, in order to wait for the job use the following commands.
```
Wait-AzureRmHDInsightJob `
     -ClusterName clusterName `
     -JobId $wordCountJob.JobId `
     -HttpCredential $cred
```
clusterName: name of the cluster

<br /><b>Transferring results to a blob storage.</b><br />
In order to store the results to blob, we need to define the storage and key.
```
$context = New-AzureStorageContext `
     -StorageAccountName storage_name `
     -StorageAccountKey $storagekey
```  
storage_name: name of the storage
$storagekey: already assigned the storage key earlier

Now storing the results to blob.
```
Get-AzureStorageBlobContent `
     -Blob 'example/data/WordCountOutput/part-r-00000' `
     -Container container_name `
     -Destination dest_file`
     -Context $context
```
container_name: name of the container in which you want to save
dest_file: destination file name

<br /><b>Deleting HDInsight Cluster.</b><br />
```
Remove-AzureRmHDInsightCluster -ClusterName <Cluster_Name>
```
Cluster_Name: name of the cluster you want to delete
