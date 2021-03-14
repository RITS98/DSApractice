import java.io.*;
class Book
{
String author, title;
Book(String author, String title)
{
	this.author = author;
	this.title = title;
}
}
public class Library
{
	Book book;
	Library(Book book)
	{
		this.book = book;
	}

	public static void main(String args[])
	{
		Book b = new Book("Shakespear","The Merchant Of Venice");
		Library library = new Library(b);
		System.out.println(library.book.author);
		System.out.println(library.book.title);
	}
}
