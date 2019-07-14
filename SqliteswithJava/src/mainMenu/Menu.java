package mainMenu;

import com.google.gson.Gson;
import datasource.DataBase;
import student.Student;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private DataBase dataBase = new DataBase();
    private ArrayList<Student> list = new ArrayList<>();
    public Menu(){};
    public void Menu() {
        //create arraylist as the storage container
        //to keep track of data.
        Student student1 = new Student();
        //student1
        student1.setId(1);
        student1.setName("john");
        student1.setSex("male");
        list.add(0, student1);

        //student2
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("john2");
        student2.setSex("male");
        //add the object2 in to database.
        list.add(1, student2);

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("john3");
        student3.setSex("male");
        //add the object3 in to database.
        list.add(2, student3);

        Student student4 = new Student();
        student4.setId(4);
        student4.setName("john4");
        student4.setSex("male");
        //add the object4 in to database.
        list.add(3, student4);

        Student student5 = new Student();
        student5.setId(5);
        student5.setName("john5");
        student5.setSex("male");
        //add the object5 in to database.
        list.add(4, student5);

        System.out.println("Display all data in ArrayList after inserting:");
        displayArrayList();
        System.out.println("Its time to store the data in SQLITES in student.db :");
        //insert all the data in consist in arraylist
        //into the query
        //run the insert once if you run it more than
        //once the same data will be inserted into databases.
        //which mean 5 become 10 10 become 20.
        insertItemsToDatabase(list);
        //display item in the database after insert
        System.out.println("Display Data in database after insert from Arraylist:");
        displayItemFromDatabase();
        //delete the student 3
        int id = 3;
        System.out.println("Delete the Student Number 3: ");
        deleteItemFromDatabase(id);
        System.out.println("Display Data in database after deleting Student Number 3 ");
        displayItemFromDatabase();

        System.out.println("Display ArrayList after deleting Student Number3 ");
        displayArrayList();

        //create newstudnet
        Student newStudent = new Student();
        newStudent.setId(3);
        newStudent.setName("Cena");
        newStudent.setSex("female");
        list.add(id, newStudent);

        System.out.println("UPDATE new data on student 3 with new name, and sex :");
        updateDatabase(id, list);
        System.out.println("Display Data in database After updating Student Number 3");
        displayItemFromDatabase();

        System.out.println("Display ArrayList after updating Student Number 3");
        displayArrayList();
        //always close the connection after you open.
        close();

        System.out.println("Data has been saved as Json");
        try{
            saveData();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public void displayArrayList(){
        for(int i=0;i<list.size(); i++){
            System.out.println(list.get(i).toString());
        }
    }
    public void saveData() throws IOException{
        Gson json = new Gson();
        BufferedWriter bufferedWriter = null;
        try{
            FileWriter fileWriter = new FileWriter("/Users/darayuthhang/Desktop/student.json");
            bufferedWriter = new BufferedWriter(fileWriter);
            json.toJson(list, bufferedWriter);

            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (FileNotFoundException e){
            throw new FileNotFoundException("File not found");
        } catch (IOException e){
            throw new IOException("File cannot be opened");
        }
    }
    public void insertItemsToDatabase(ArrayList<Student> list){
        try{
            for(int i=0;i<list.size();i++){
                //you do not to insert the id
                //because the database will take care of it
                Student data = list.get(i);
                //insert name, and sex into sqlites.
                dataBase.insertQuery(data.getName(), data.getSex());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void deleteItemFromDatabase(int id){
        //id -
        dataBase.deleteQuery(id);
        //remove the item from list
        //so that that arraylist is balance
        //with the database.
        int arryListId = id - 1;
        list.remove(arryListId);
    }
    public void displayItemFromDatabase(){
        dataBase.displayQuery();
    }
    public void updateDatabase(int id, ArrayList<Student> modifyStudent){
        //create the new object in order to hold the same object.
        int arryListId = id - 1;
        Student newStudent = modifyStudent.get(arryListId);
        dataBase.UpdateQuery(newStudent.getId(), newStudent.getName(), newStudent.getSex() );
    }
    public void close(){
        try{
            dataBase.closeConnection();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
