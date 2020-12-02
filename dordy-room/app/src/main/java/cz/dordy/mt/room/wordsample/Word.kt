package cz.dordy.mt.room.wordsample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey





//@Entity(tableName = "word_table") Each @Entity class represents a SQLite table. Annotate your class declaration to indicate that it's an entity. You can specify the name of the table if you want it to be different from the name of the class. This names the table "word_table".
@Entity(tableName = "word_table")
class Word(

    @PrimaryKey(autoGenerate = true) val id: Int,

    @ColumnInfo(name = "word") val word: String

)