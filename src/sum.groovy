// Read each line, then split by space
// Use a reverse order to approach this problem work from back to front
// So we can save many wasteful addition/comparison with brute force
/*
	   9           9         9      21
	 2   1       2   1    12   11
	1  5  7    10 10  10
  9  5  3  3
Path being: 9 + 2 + 5 + 5 = 21.
a = [['', 9],['',2,1],['',1,5,7],['',9,5,3,3]]

the answer is 14584
*/

/*** initialization ***/
filename = 'generated_triangle.txt'
a = []

f = new File(filename)
f.splitEachLine(' '){a << it}

for (int line=a.size()-2; line >= 0 ; line--){
	newlist=['']
	// We are starting from 1 since there is a space before the first number in the given data
	for (int num=1; num < a[line].size(); num++){
		def left= a[line][num].toInteger()+a[line+1][num].toInteger()  as int 
		def right = a[line][num].toInteger()+a[line+1][num+1].toInteger()  as int 
		newlist.add(Math.max(left, right))
	}
	a[line] = newlist
}

println "The greatest sum is: " + a[0][1]