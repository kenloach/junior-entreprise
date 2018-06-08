/*
 * Classe TableFromDatabase
 * Elle nous servira pour afficher le contenu de la base de données dans les JTable
 */
package juniorentreprise;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableFromDatabase
{

    public TableFromDatabase(){
        
    }
    /**
     *
     * @param nomTable
     * @return
     */
    public JTable createTable(String nomTable)
    {
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();

        try
        {
            //  Connect to an Access Database

            String driver = "com.mysql.jdbc.Driver";
            // if using ODBC Data Source name
            String url =
               "jdbc:mysql://iutdoua-web.univ-lyon1.fr:3306/p1702775";
            String userid = "p1702775";
            String password = "296054";

            Class.forName( driver );
            Connection connection = DriverManager.getConnection( url, userid, password );

            //  Read data from a table

            String sql = "Select * from "+nomTable;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data
        

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };

        JTable table = new JTable( model );
        table.setEnabled(false);
        return table;
        /*
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
        
        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        */
    }

    /*public static void main(String[] args)
    {
        TableFromDatabase frame = new TableFromDatabase("Etudiant");
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }*/
}

