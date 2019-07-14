# Sqlite-Java
Sqlite-Java

## image

![Screen Shot 2019-07-14 at 6 20 24 PM (2)](https://user-images.githubusercontent.com/33853565/61190057-1de50700-a664-11e9-8270-bf3e594e8145.png)


### Description

<p> This program demonstrate on how to use java JDBC API to connect to Sqlite database to perform adding, deleting, and modifying. It also allow the user to save the data as json too. </p>

### Output

Display all data in ArrayList after inserting:
{id:1name:johnsex:male}
{id:2name:john2sex:male}
{id:3name:john3sex:male}
{id:4name:john4sex:male}
{id:5name:john5sex:male}

Its time to store the data in SQLITES in student.db :
Display Data in database after insert from Arraylist:
Display Query
1 john male
2 john2 male
3 john3 male
4 john4 male
5 john5 male

Delete the Student Number 3: 
Display Data in database after deleting Student Number 3 
Display Query
1 john male
2 john2 male
4 john4 male
5 john5 male

Display ArrayList after deleting Student Number3 
{id:1name:johnsex:male}
{id:2name:john2sex:male}
{id:4name:john4sex:male}
{id:5name:john5sex:male}
UPDATE new data on student 3 with new name, and sex :
Display Data in database After updating Student Number 3
Display Query
1 john male
2 john2 male
4 john4 male
5 john5 male

Display ArrayList after updating Student Number 3
{id:1name:johnsex:male}
{id:2name:john2sex:male}
{id:4name:john4sex:male}
{id:3name:Cenasex:female}
{id:5name:john5sex:male}
Data has been saved as Json
