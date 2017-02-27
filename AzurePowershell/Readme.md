<h1><b>Managing Azure Services using Powershell</b></h1>
Azure Powershell is a tool that allows users to manage all Azure features directly from their computers. It helps to manage the Azure services using a command line interface.
<br />

<br /><b>Downloading Azure PowerShell.</b><br />
Incase you need to download the Power Shell, follow this <a href="https://github.com/Azure/azure-powershell/releases/tag/v3.6.0-February2017" target="_blank">Guide</a>.


<br /><b>HDInsight</b><br /> 
Microsoft Azure HDInsight Azure HD Insight is a service that provides Hadoop/Spark/HBase based clusters that run over Azure Cloud Platform.  These clusters provide solutions to manage, analyze and visualize the reports on big data.

Before proceeding following Azure Services are required:<br /> 
•	Azure Log In<br /> 
•	Azure Resource Group<br /> 
•	Azure Storage Account<br /> 
•	Azure Blob Container<br /> 
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
Replace all the placeholders present within <> with the required/desired options.

<p align="center"><img src="Media/1.png?raw=true"></p>

<h1><br /><b>MapReduce</b></h1>
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
<i>File_path</i>: the jar file path e.g wasb:///example/jars/hadoop-mapreduce-examples.jar<br />
<i>ClassName</i>: name of the class e.g wordcount<br />
<i>Argument1</i>: the input file path e.g wasb:///example/data/gutenberg/davinci.txt<br />
<i>Argument2</i>: the output folder path e.g wasb:///example/data/WordCountOutput<br />

Now submitting the job.
```
$cred=Get-Credential -Message "credentials"
$wordCountJob = Start-AzureRmHDInsightJob `
     -ClusterName clusterName `
     -JobDefinition $wordCountJobDefinition `
     -HttpCredential $cred
```
<i>Credentials</i>: enter login details for the cluster<br />
<i>clusterName</i>: name of the cluster

<p align="center"><img src="Media/2.png?raw=true"></p>

Now the job is being executed, in order to wait for the job use the following commands.
```
Wait-AzureRmHDInsightJob `
     -ClusterName clusterName `
     -JobId $wordCountJob.JobId `
     -HttpCredential $cred
```
<i>clusterName</i>: name of the cluster

<p align="center"><img src="Media/3.png?raw=true"></p>

<br /><b>Transferring results to a blob storage.</b><br />
In order to store the results to blob, we need to define the storage and key.
```
$context = New-AzureStorageContext `
     -StorageAccountName storage_name `
     -StorageAccountKey $storagekey
```  
<i>storage_name</i>: name of the storage<br />
<i>$storagekey</i>: already assigned the storage key earlier

Now storing the results to blob.
```
Get-AzureStorageBlobContent `
     -Blob file_path `
     -Container container_name `
     -Destination dest_file`
     -Context $context
```
<i>file_path</i>: the path of the output file, e.g example/data/WordCountOutput/part-r-00000<br />
<i>container_name</i>: name of the container in which you want to save<br />
<i>dest_file</i>: destination file name

<p align="center"><img src="Media/4.png?raw=true"></p>

Following is the ouput present in the file path-r-0000.

<p align="center"><img src="Media/5.png?raw=true"></p>

<br /><b>Deleting HDInsight Cluster.</b><br />
```
Remove-AzureRmHDInsightCluster -ClusterName Cluster_Name
```
<i>Cluster_Name</i>: name of the cluster you want to delete

<p align="center"><img src="Media/6.png?raw=true"></p>

