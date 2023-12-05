package com.gulaev;

import com.gulaev.book.BookItem;
import com.gulaev.book.OnlineBook;
import com.gulaev.employ.WarehouseEmployee;
import com.gulaev.employ.СashierEmployee;
import com.gulaev.enums.Genre;
import com.gulaev.enums.Stores;
import com.gulaev.enums.Tag;
import com.gulaev.enums.Warehouses;
import com.gulaev.file.FileReader;
import com.gulaev.interfaces.Employee;
import com.gulaev.interfaces.function.Calculator;
import com.gulaev.interfaces.function.Сonnector;
import com.gulaev.linkd.Linkd;
import com.gulaev.linkd.LinkdList;
import com.gulaev.service.BookRecommendationService;
import com.gulaev.service.BookService;
import com.gulaev.service.UserService;
import com.gulaev.user.LibraryUser;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

  private static final Logger LOGGER = LogManager.getLogger(Main.class);

  public static void main(String[] args) {

    //Create a bookItem pool
    BookItem bookItem1 = BookService.createNewBookItem("Nick",
        "An intriguing novel by Nick, delving into the complexities of human nature and the relentless pursuit of truth. With eloquent prose and engaging storytelling, this book captivates readers with its rich narrative and thought-provoking themes. Set in a world filled with suspense and mystery, the story unfolds, enthralling readers page by page.",
        "Book", 10, Genre.FANTASY, Arrays.asList(Tag.WAR, Tag.COMEDY), Warehouses.KYIV,
        Stores.KYIV);
    BookItem bookItem2 = new BookItem(2, "Title2", "John", "Description2", 20,
        Arrays.asList(Tag.HISTORY, Tag.WAR), Genre.MYSTERY, Warehouses.KYIV, Stores.KYIV);
    BookItem bookItem3 = new BookItem(3, "Title3", "Nick", "Description3", 30,
        Arrays.asList(Tag.COMEDY, Tag.HISTORY), Genre.MYSTERY, Warehouses.KYIV, Stores.KYIV);

    //Testing online book pool
    OnlineBook onlineBook = OnlineBook.builder().setTitle("Title").setId(1).setAuthor("Nithe")
        .setCover("not path").setDescription("Description").setGenre(Genre.FANTASY).setPrice(300)
        .setTags(Arrays.asList(Tag.DRAMA, Tag.HISTORY)).build();

    LibraryUser user = UserService.createNewLibraryUser("suser", "email@email.com", "John", "Doe",
        "Abc1234");

    user.setWishlist(Arrays.asList(bookItem1, bookItem2));
    user.setBoughtBooks(Arrays.asList(bookItem3));

    user = UserService.changePasswordToUser(user, "Abc1234", "Abc1235");

    Set<BookItem> recommendedBookItems = BookRecommendationService.findBookByPreferences(user);

    Linkd<Integer> integerLinkdList = new LinkdList<>();

    integerLinkdList.add(1);
    integerLinkdList.add(2);
    integerLinkdList.add(3);
    integerLinkdList.add(4);
    integerLinkdList.add(1, 4);

    LOGGER.info(integerLinkdList);

    try {
      System.out.println(FileReader.getWordsFromFile());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //Testng oun lambda functions
    Employee employee = new WarehouseEmployee();
    Employee employee1 = new СashierEmployee();
    Calculator<Employee, Employee> run2 = (Employee a, Employee b) ->
        a.calculateSalary(31) + b.calculateSalary(31);
    run2.calculate(employee, employee1);

    Сonnector<BookItem, BookItem, OnlineBook> connector = (a, b) -> {
      OnlineBook onlineBook1 = OnlineBook.builder()
          .setAuthor(a.getAuthor())
          .setDescription(b.getDescription())
          .setGenre(a.getGenre())
          .setTags(b.getTags())
          .setPrice(a.getPrice()).build();
      return onlineBook1;
    };
    connector.connect(bookItem1, bookItem2);

    //Testing lambda functions
    Consumer<Employee> comparable = e -> e.calculateSalary(12);
    comparable.accept(employee);
    Supplier<BookItem> bookItemSupplier = () -> {
      return new BookItem(2, "Title2", "John", "Description2", 20,
          Arrays.asList(Tag.HISTORY, Tag.WAR), Genre.MYSTERY, Warehouses.KYIV, Stores.KYIV);
    };
    bookItemSupplier.get();
    Function<BookItem, OnlineBook> squareFunction = bookItem -> {
      OnlineBook onlineBook1 = OnlineBook.builder()
          .setAuthor(bookItem.getAuthor())
          .setDescription(bookItem.getDescription())
          .setGenre(bookItem.getGenre())
          .setTags(bookItem.getTags())
          .setPrice(bookItem.getPrice()).build();
      return onlineBook1;
    };
    squareFunction.apply(bookItem1);

    BiPredicate<BookItem, OnlineBook> bookBiPredicate = (b, o) -> {
      if (b.getAuthor().equals(o.getAuthor()) && b.getDescription().equals(o.getDescription())) {
        return true;
      } else {
        return false;
      }
    };
    bookBiPredicate.test(bookItem1, onlineBook);

    //Reflection Testing
    Class<?> onlineBookClass = OnlineBook.class;

    // Extract information about fields
    Field[] fields = onlineBookClass.getDeclaredFields();
    System.out.println("Fields:");
    Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));

    // Extract information about constructors
    Constructor<?>[] constructors = onlineBookClass.getDeclaredConstructors();
    System.out.println("\nConstructors:");
    Arrays.stream(constructors).forEach(System.out::println);

    // Extract information about methods
    Method[] methods = onlineBookClass.getDeclaredMethods();
    System.out.println("\nMethods:");
    Arrays.stream(methods).forEach(method -> System.out.println(method.getName()));

    // Create an object using reflection
    Constructor<?> constructor = null;
    OnlineBook book = null;
    Method method = null;
    Integer discountedPrice = null;

    try {
      constructor = onlineBookClass.getDeclaredConstructor(
          Integer.class, String.class, String.class, String.class, Integer.class,
          List.class, Genre.class, File.class);

      constructor.setAccessible(true);
      book = (OnlineBook) constructor.newInstance(
          1, "Title", "Author", "Description", 100,
          List.of(Tag.NON_FICTION), Genre.FANTASY, new File("path/to/cover.jpg"));
      // Invoke a method using reflection
      method = onlineBookClass.getDeclaredMethod("getPriceWithDiscount", LibraryUser.class);
      method.setAccessible(true);
      discountedPrice = (Integer) method.invoke(book, new LibraryUser());

    } catch (RuntimeException | InvocationTargetException | NoSuchMethodException |
             InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }

    System.out.println("\nDiscounted Price: " + discountedPrice);

    // Print object details
    System.out.println("\nObject Details:");
    System.out.println(book);
  }

}
