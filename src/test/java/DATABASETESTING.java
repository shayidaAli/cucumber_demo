import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DATABASETESTING {

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Test
    public void testingDB() throws SQLException {

        //creating a connection to the database using jdbc

        connection = DriverManager.getConnection("jdbc:postgresql://room-reservation-qa.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/hr",
                "hr",
                "hr");

        //to create statement and allow scroll back and forward (TYPE_SCROLL_INSENSITIVE)
        // then from statement we will create result set that will receive data based on query
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //write SQL query
        String sql="select * from employees";

        //we are running query (command)
        resultSet = statement.executeQuery(sql);

        //information about the data base -->meta data

        ResultSetMetaData mt=resultSet.getMetaData(); //getting resultset related information
        System.out.println(mt.toString());

        //get column count
        int count = mt.getColumnCount();
        System.out.println(count);


        //create a list which will hold column names
        List<String> columns = new ArrayList<>();

            //to loop through columns
            for(int i =1; i<=count;i++) {
                //we are adding columns one my one based on the index of column, starting from 1
                columns.add(mt.getColumnName(i));
            }

        System.out.println(columns.toString());

    }
}
