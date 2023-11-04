package com.example.digilibrevission.data

import androidx.annotation.DrawableRes
import com.example.digilibrevission.R
import kotlinx.coroutines.delay

data class Book(
    val title : String,
    val author : String,
    val otherInfo : String,
    @DrawableRes val cover : Int
)

data class BookPenalty(
    val title : String,
    val author : String,
    @DrawableRes val cover : Int,
    val penaltyPrice : String,
    val date : String
)

object DataSource {

    private val books = listOf(
        Book("The Alchemist", "Paulo Coelho", "2 days left", R.drawable.the_alchemist_cover),
        Book("The Power of Habit", "Charles Duhigg", "5 days left", R.drawable.the_power_of_habit_cover),
        Book("Educated", "Tara Westover", "3 days left", R.drawable.educated_cover),
        Book("Atlas of the Heart", "Brene Brown", "7 days left", R.drawable.atlas_of_the_heart_cover),
        Book("Crime and Punishment", "Fyodor Dostoevsky", "6 days left", R.drawable.crime_and_punishment_cover),
        Book("Thinking, Fast and Slow", "Daniel Kahneman", "10 days left", R.drawable.thinking_fast_and_slow_cover),
        Book("The People We Keep", "Allison Larkin", "9 days left", R.drawable.the_people_we_keep_cover),
        Book("Freedom", "Jonathan Franzen", "1 day left", R.drawable.freedom_cover),
    )

    private val booksPenalty = books.map {book ->
        BookPenalty(
            title = book.title,
            author = book.author,
            cover = book.cover,
            penaltyPrice = "Rp. 12.000",
            date = "12 September 2022"
        )
    }

    private val historyBooks : List<Book> = books.map {
        it.copy(otherInfo = "12 September 2022")
    }

    suspend fun getBooks() : List<Book>{
        delay(2000)
        return books
    }

    fun searchBook(query : String) : List<Book>{
        return if(query.isEmpty()){
            return emptyList()
        }else{
            books.filter { it.title.toLowerCase().contains(query) }
        }
    }

    suspend fun getHistoryBooks() : List<Book>{
        delay(2000)
        return historyBooks
    }
    fun searchHistory(query : String) : List<Book>{
        return if(query.isEmpty()){
            return emptyList()
        }else{
            historyBooks.filter { it.title.toLowerCase().contains(query) }
        }
    }

    suspend fun getPenalties() : List<BookPenalty>{
        delay(2000)
        return booksPenalty
    }

    fun searchPenalties(query : String) : List<BookPenalty>{
        return if(query.isEmpty()){
            return emptyList()
        }else{
            booksPenalty.filter { it.title.toLowerCase().contains(query) }
        }
    }

}