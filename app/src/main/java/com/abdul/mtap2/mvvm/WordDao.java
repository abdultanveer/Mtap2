package com.abdul.mtap2.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.abdul.mtap2.model.Word;

import java.util.List;

//CRUD ---
@Dao
public interface WordDao {

   //insert into Word {uid,title} values {5,"abdul"}
   @Insert
   void insert(Word word);

   @Query("SELECT * from Word")
   LiveData<List<Word>> getAllWords(); //once i wrap this list<word> into live data, the data becomes observable

  /* @Update
   public void updateWords(Word... words);

   @Query("DELETE FROM Word")
   void deleteAll();

INSERT INTO Word (uid, title)VALUES (5, "abdul");

   @Query("SELECT * FROM Word WHERE title LIKE :word ")
   public List<Word> findWord(String word);*/

}
