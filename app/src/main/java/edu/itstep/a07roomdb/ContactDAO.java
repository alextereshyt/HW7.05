package edu.itstep.a07roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDAO {

    @Query("SELECT * FROM contact")
    List<Contact> getAll();

    @Query("SELECT * FROM contact where id = :id")
    Contact getById(long id);

    @Insert
    void add(Contact... contacts);

    @Update
    void update(Contact... contacts);

    @Delete
    void remove(Contact... contacts);

    @Query("DELETE FROM contact where id = :id")
    void removeById(long id);

}
