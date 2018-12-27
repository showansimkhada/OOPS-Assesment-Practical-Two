//Student name: Showan Simkhada
//Student ID: 17459655
//Pledge of Honor: I pledge by honor that this program is solely my own work.

package application;

import java.util.ArrayList;
import java.util.List;

public class Question_No4
{

	public static void main(String[] args) 
	{
		// creating the list books
		List<Book> books = new ArrayList<>();
		books.add(new Book("Them", 1000));
		books.add(new Book("Now", 2000));
		books.add(new Book("After", 2500));
		System.out.printf("Total number of books: %d \n", books.size());
		System.out.printf("Total number of pages: %d \n", Recursion.calcTotalPages(books)); 
	}
}

class Recursion
{
	public static int calcTotalPages(List<Book> booklist)
	{
		// assuming total pages of three books
		int total = 0;
		// if book list is empty or book list size is zero return 0;
		if (booklist == null || booklist.size() == 0)
		{
			return 0;
		}
		else
		{
			int firstbookpage = booklist.get(0).getNumOfPages();
			// creating the sub list from the book list
			List<Book> subList = booklist.subList(1, booklist.size());
			total = firstbookpage + calcTotalPages(subList);
		}
		return total;
	}
}

class Book
{
	private String title;
	private int numOfPages;
	// creating the constructor with two parameters
	Book(String title, int numOfPages)
	{
		this.title = title;
		this.numOfPages = numOfPages;
	}
	
	// creating the getters and setters for the title and number of pages
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	
	
}
