package com.abdul.mtap2;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.abdul.mtap2.model.Word;

import java.util.List;

//CRUD ---
@Dao
public interface WordDao {

   //insert into Word {uid,tile} values {1,"abdul"}
   @Insert
   void insert(Word word);
   @Update
   public void updateWords(Word... words);

   @Query("DELETE FROM Word")
   void deleteAll();

   @Query("SELECT * from Word ORDER BY title ASC")
   List<Word> getAllWords();

   @Query("SELECT * FROM Word WHERE title LIKE :word ")
   public List<Word> findWord(String word);

}
