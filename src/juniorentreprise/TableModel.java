/*
 * Classe TableModel
 * Elle nous servira pour afficher le contenu de la base de données dans les JTable
 */
package juniorentreprise;

/**
 *
 * @author Arthur
 */
import javax.swing.table.AbstractTableModel;
import java.util.Vector;
 
public class TableModel extends AbstractTableModel{
 
    protected Vector data;            //données
    protected Vector columnNames ;    //noms de colonnes

       /** Creates a new instance of TableModelC
     * @param columnNames
     * @param data */
    public TableModel(Vector columnNames,Vector data) {
        this.columnNames=columnNames;
        this.data=data; 
    }
     
    @Override
    public int getRowCount() {
        return data.size()/getColumnCount();
    }
    @Override
    public int getColumnCount() {
        return columnNames.size();
    }
    /**
     * noms des colonnes
     * @param columnIndex
     * @return 
     */
    @Override
    public String getColumnName(int columnIndex) {
        String colName="";
        if (columnIndex <= getColumnCount())
            colName=(String)columnNames.elementAt(columnIndex);
        return colName;
    }
     /**
     * type de contenu d'une colonne : ici il s'agit toujours de chaînes
     * de caractères.
     * @param c
     * @return 
     */
    @Override
    public Class getColumnClass(int c){
       return getValueAt(0,c).getClass();
    }
   /**
     * possibilité d'édition des données
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      return true;
    }
    /**
     * contenu d'une cellule
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.elementAt((rowIndex*getColumnCount())+columnIndex);
    }
    /**
     * changement du contenu d'une cellule
     * @param aValue
     * @param rowIndex
     * @param columnIndex
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data.setElementAt(aValue, (rowIndex*getColumnCount())+columnIndex); 
    }

    public void saveVectors() {
        saveAs();
    }

    public void saveAs()  {

    }
 
}
