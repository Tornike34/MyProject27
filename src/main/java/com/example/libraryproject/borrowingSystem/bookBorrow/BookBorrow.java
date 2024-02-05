package com.example.libraryproject.borrowingSystem.bookBorrow;

import javax.xml.crypto.Data;

public class BookBorrow {
    private String status;
    private Data dataOfExportBook;
    private Data dataOfImportBook;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getDataOfExportBook() {
        return dataOfExportBook;
    }

    public void setDataOfExportBook(Data dataOfExportBook) {
        this.dataOfExportBook = dataOfExportBook;
    }

    public Data getDataOfImportBook() {
        return dataOfImportBook;
    }

    public void setDataOfImportBook(Data dataOfImportBook) {
        this.dataOfImportBook = dataOfImportBook;
    }

    public BookBorrow(String status, Data dataOfExportBook, Data dataOfImportBook) {
        this.status = status;
        this.dataOfExportBook = dataOfExportBook;
        this.dataOfImportBook = dataOfImportBook;
    }

    @Override
    public String toString() {
        return "BookBorrow{" +
                "status='" + status + '\'' +
                ", dataOfExportBook=" + dataOfExportBook +
                ", dataOfImportBook=" + dataOfImportBook +
                '}';
    }
}
