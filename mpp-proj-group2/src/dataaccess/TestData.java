package dataaccess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.LibraryMember;

/**
 * This class loads data into the data repository and also
 * sets up the storage units that are used in the application.
 * The main method in this class must be run once (and only
 * once) before the rest of the application can work properly.
 * It will create three serialized objects in the dataaccess storage
 * folder.
 * 
 *
 */
public class TestData {
	
	public static void initData(){
		main(new String[]{});
	}
	public static void main(String[] args) {
		TestData td = new TestData();
		td.bookData();
		td.libraryMemberData();
		td.userData();
		td.authorData();
		td.recordData();
		DataAccess da = new DataAccessFacade();

		System.out.println(da.readBooksMap());
		System.out.println(da.readUserMap());
	}
	///create books
	public void bookData() {
		allBooks.get(0).addCopy();
		allBooks.get(0).addCopy();
		allBooks.get(1).addCopy();
		allBooks.get(3).addCopy();
		allBooks.get(2).addCopy();
		allBooks.get(2).addCopy();
		DataAccessFacade.loadBookMap(allBooks);
	}
	
	public void userData() {
		DataAccessFacade.loadUserMap(allUsers);
	}

	public void recordData() {
		DataAccessFacade.loadRecordMap(new ArrayList<>());
	}

	//create library members
	public void libraryMemberData() {
		LibraryMember libraryMember = new LibraryMember("1001", "Alexander", "Kisekka", "641-223-2245", addresses.get(4));
		members.add(libraryMember);
		libraryMember = new LibraryMember("1002", "Tony", "Otim", "702-998-2414", addresses.get(5));
		members.add(libraryMember);
		
		libraryMember = new LibraryMember("1003", "Davies", "Wabuluka", "451-234-8811", addresses.get(6));
		members.add(libraryMember);
		
		libraryMember = new LibraryMember("1004", "Jamal", "Kasule", "641-472-2871", addresses.get(7));
		members.add(libraryMember);

		libraryMember = new LibraryMember("1005", "Jones", "Mariam", "641-223-2210", addresses.get(4));
		members.add(libraryMember);
		libraryMember = new LibraryMember("1006", "Hadijah", "Hajat", "732-978-2560", addresses.get(5));
		members.add(libraryMember);

		libraryMember = new LibraryMember("1007", "Sam", "Kazibwe", "451-234-8810", addresses.get(6));
		members.add(libraryMember);

		libraryMember = new LibraryMember("1008", "Mathew", "Luwaga", "0702-6987-523", addresses.get(7));
		members.add(libraryMember);
		
		DataAccessFacade.loadMemberMap(members);	
	}
	
	///////////// DATA //////////////
	List<LibraryMember> members = new ArrayList<LibraryMember>();
	@SuppressWarnings("serial")
	
	List<Address> addresses = new ArrayList<Address>() {
		{
			add(new Address("102 N. Main", "Texas", "52556","TX"));
			add(new Address("33 Frontera Drive", "RoundRock",  "65434","TX"));
			add(new Address("23 Kimathi Ave", "Kampala",  "41234", "Georgia"));
			add(new Address("1 N. Baton", "Baton Rouge", "33556","LA"));
			add(new Address("5001 Venice Dr.", "Los Angeles", "93736","CA"));
			add(new Address("1435 Channing Ave", "Palo Alto", "94301","CA"));
			add(new Address("42 Dogwood Dr.", "Fairfield", "52556", "IA"));
			add(new Address("501 Central", "Mountain View", "94707" ,"CA"));
		}
	};
	@SuppressWarnings("serial")
	public List<Author> allAuthors = new ArrayList<Author>() {
		{
			add(new Author("Joe", "Thomas", "641-445-2123", addresses.get(0), "A happy man is he."));
			add(new Author("Sandra", "Thomas", "641-445-2123", addresses.get(0), "A happy wife is she."));
			add(new Author("Nirmal", "Pugh", "641-919-3223", addresses.get(1), "Thinker of thoughts."));
			add(new Author("Andrew", "Cleveland", "976-445-2232", addresses.get(2), "Author of childrens' books."));
			add(new Author("Sarah", "Connor", "123-422-2663", addresses.get(3), "Known for her clever style."));
		}
	};

	public void authorData() {
		DataAccessFacade.loadAuthorMap(allAuthors);
	}

	@SuppressWarnings("serial")
	List<Book> allBooks = new ArrayList<Book>() {
		{
			add(new Book("23-11451", "The Big Fish", 21, Arrays.asList(allAuthors.get(0), allAuthors.get(1))));
			add(new Book("28-12331", "Antartica", 7, Arrays.asList(allAuthors.get(2))));
			add(new Book("99-22223", "Thinking Java", 21, Arrays.asList(allAuthors.get(3))));
			add(new Book("48-56882", "Jimmy's First Day of School", 7, Arrays.asList(allAuthors.get(4))));		
		}
	};
	
	@SuppressWarnings("serial")
	List<User> allUsers = new ArrayList<User>() {
		{
			add(new User("101", "xyz", Auth.LIBRARIAN));
			add(new User("102", "abc", Auth.ADMIN));
			add(new User("103", "111", Auth.BOTH));
		}
	};
}
