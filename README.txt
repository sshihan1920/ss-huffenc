Program Status/Algorithm Description:
The program I have created works and completes all tasks of the project. Below is a simple description of all the methods in my code. However a few notes are given below, please read.

*Name of each method is displayed in comment form above actual method (ex: //Linked List AddFirst Method)

*I didn’t explain the code that was used from the textbook/online textbook below because I felt that the functionality of those codes were already established. Instead citation and minor notes if needed are given 
Should note that all cited code is slightly modified to work alongside the rest of my program, still has all the same methods and their corresponding functionality as the code given in Sedgewick’s Textbook (page numbers cited). 

HTNode Methods:
Starts Line 11
Code Citation
Sedgewick, Robert. “Strings: Data Compression.” Algorithms, edited by Kevin Wayne, 4th ed., Princeton University, 2011, p. 828. 
Sum HTNode Creation Method
Creates a new HTNode using parameter int sum as value for the “freq” value of the Node (everything else is set to null)

Trie Methods:
Starts Line 45
Code Citation
Sedgewick, Robert. “Strings: Data Compression.” Algorithms, edited by Kevin Wayne, 4th ed., Princeton University, 2011, p. 828-835. 

MinPQ Class:
Starts Line 125
Code Citation
Sedgewick, Robert, and Kevin Wayne. “MinPQ.java.” Princeton University, The Trustees of Princeton University, algs4.cs.princeton.edu/24pq/MinPQ.java.html.

Non-Textbook HuffmanSubmit Methods:
Starts Line 283
Frequency HashMap Maker Method
Takes in a string (inputFileName) and creates a BinaryIn object (reader) that reads the file with the name of inputFileName 
Then using reader, a HashMap (charFreqMap) is created that maps an integer, representing the frequency of a character, as the value to each key of the map.
The keys of the map are all the unique characters in the input file. 
Then charFreqMap is returned
Convert HashMap to Character Array Method 
Takes in a HashMap parameter (map) and creates a character array (charArray).
Then fills in the indices of charArray with the key values of inputMap
Then charArray is returned
Convert HashMap to Integer Array Method 
Takes in a HashMap parameter (map) and creates an integer array (freqArray) of 256 indices.
Then fills in the indices of freqArray with the value values of inputMap, with each index corresponding to the same index of the ASCII table
Then freqArray is returned
Frequency Writer Method	
Takes in two parameters; int[] array freq and String outputFileName
Creates a BinaryOut named writer that works with the file named after outputFileName
Then writer uses freq to write out the binaryString representation of each char alongside the frequency of the char (in a specified format) onto the file named after outputFileName
Compress Method
Code Citation
Sedgewick, Robert. “Strings: Data Compression.” Algorithms, edited by Kevin Wayne, 4th ed., Princeton University, 2011, p. 836. 
Encode Method	
Three parameters: String inputFileName, String outputFileName, String freqFileName
Creates a new BinaryIn object named inReader which reads file named after inputFileName
Then inReader is used to create a String (inString) which then is used as a parameter for the Frequency HashMap Maker Method, the result of which returns a HashMap (map)
map is then used as a parameter for the Convert HashMap to Integer Array Method, returning an int array named inFreq
Lastly,
the Frequency Writer Method	is called with inFreq and freqFileName as parameters
Compress Method is called with inputFileName, outputFileName, and inFreq as parameters
Decode Method
Three parameters: String inputFileName, String outputFileName, String freqFileName
Creates a BinaryIn object (inReader) which reads file named after inputFileName, BinaryOut object (outWriter) which writes on file named after outputFileName, and Trie object (huff)
Uses Frequency HashMap Maker Method with inputFileName as parameter, returning HashMap called map
map is then used as a parameter for the Convert HashMap to Integer Array Method, returning an int array named freq
 Using huff, the build trie method (from Trie class) is called with freq as a parameter and the returned HTNode is called (root)
Finally, huff is used to call the expand method (From Trie class) with inReader and OutWriter as parameters.
Main Method
Creates a new HuffmanSubmitObject named Huffman
Huffman then uses the encode method with specified parameters (take out comment slashes/insert comment slashes to test the files you want)
Then Huffman is used for the decode method with specified parameters (again take out comment slashes/insert comment slashes to test the files you want)


Special Note about Output:
Output Files may not immediately appear on eclipse project files. In that case, to view the output files of my program, do the following steps:
Go to File > Properties (top left of screen on eclipse)
It will take you to a screen, click show in systems explorer
This will take you to project folder, click the Project Name 
Shows all files of project, click whatever file requires viewing

With all that being said, please contact me if you have any questions. My program should be working exactly as the project pdf specified  
