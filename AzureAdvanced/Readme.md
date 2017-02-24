<b>Advanced Features of Microsoft Azure Platform </b><br />
Before proceeding create a Microsoft account and signup for azure service, it will require few steps before you can start using these services. Once done, go to the <a href="https://portal.azure.com/" target="_blank">Azure Portal</a>.

<b>How to create HDInsight cluster?</b><br />
To create HDInsight cluster, navigate to new > Intelligence + analytics > HDInsight.

<p align="center"><img src="Media/1.png?raw=true"></p>

Fill the details, choose password, resource group and press Cluster configuration, a window to the right will be expanded. Choose the cluster type from the drop down list and press select. Now press the next button.

<p align="center"><img src="Media/2.png?raw=true"></p>

Now it will ask for the storage account setting, fill the details and press next.

<p align="center"><img src="Media/3.png?raw=true"></p>

You will see a Cluster summary window, press create to deploy your cluster.

<p align="center"><img src="Media/4.png?raw=true"></p>

This will take few minutes.

<b>How to submit and execute Spark job script to cluster?</b><br />
In order to make a program for Spark using Scala, you need to download the Spark library from here.
We will create a simple word to count program in scala using basic function. Get <a href="https://github.com/MJFND/MicrosoftAzure/blob/master/AzureAdvanced/job.scala" target="_blank" >full code</a>.

The following line reads the fruits.txt from the blob storage, you can also see by excessing the directory through Portal.
<i>val textFile = sc.textFile("wasb:///example/data/fruits.txt") </i>

This command counts the occurrence of each word with the help of four functions flatMap, split, map and, reduceByKey.
<i>val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)</i>

Split: this function splits text on the desired criteria, in our case “ ”.<br />
Map: this function maps each word with 1.<br />
ReduceByKey: this function reduces on the basis of the key (word in our case), for example we have two same names available (Apple, 1) and (Apple, 1), this function will reduce it to (Apple, 2).<br />
FlatMap: It is similar to Map but it returns a list.

The following command is explained in the later part.
<i>counts.coalesce(1,true).saveAsTextFile("wasb:///example/data/fruitcount.txt")</i>

Once done with the code, right Click on the project name in the explorer and press Submit Spark Application to HDInsight. This will take few minutes to submit your job, you can see the job listed in the Spark History Server.

<p align="center"><img src="Media/5.png?raw=true"></p>

Or the alternate way is to upload the jar file directly using AzCopy.<br />
To execute the script, use a tool named “livy”. If you are using Python or Scala you can also run the script from the Jupytor NoteBook.

<b>How to transfer job results to blob? </b><br />
To store the results in a blob, simply use the following commands in your program. It will automatically store it at your desired location once executed.
<i>counts.coalesce(1,true).saveAsTextFile("wasb:///example/data/fruitcount.txt")</i>

Coalesce: this function simply saves the output in a single file otherwise the output could be saved in multiple files depending upon the type results.
You can see your file in the directory.

<p align="center"><img src="Media/6.png?raw=true"></p>

To see the output download the file named part-0000. The file contains the following:<br />
<i>(orange,1)<br />
(pineapple,1)<br />
(canary,1)<br />
(apple,1)<br />
(banana,1)<br />
(grape,1)<br />
(lemon,1)<br />
(strawberry,1)<br />
(melon,1)<br />
</i>
Get <a href="https://github.com/MJFND/MicrosoftAzure/blob/master/AzureAdvanced/part-00000" target="_blank" >the file</a>.

<b>How to delete HDInsight cluster?</b><br />
To delete the cluster, click on your cluster and press delete button present on top of the window.

<p align="center"><img src="Media/7.png?raw=true"></p>

