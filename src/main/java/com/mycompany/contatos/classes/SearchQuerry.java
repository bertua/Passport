package com.mycompany.contatos.classes;

/*
    Search querry
    Used to setore data from a search made by the user
*/

public class SearchQuerry {
    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }
    
    private String column;
    private String cell;
}
