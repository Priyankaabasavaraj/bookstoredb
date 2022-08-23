package booksoredb;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

		public class BookStoreDb {
			private static Connection connection = null;
			private static Scanner scanner = new Scanner(System.in);

			public static void main(String[] args) {
				BookStoreDb id = new BookStoreDb();
				
				try {
					
				Class.forName("com.mysql.cj.jdbc.Driver");
				String dbURL = "jdbc:mysql://localhost:3306/bookstore";
				String username = "root";
				String password = "Priyanka&34";

				connection = DriverManager.getConnection(dbURL, username, password);
				System.out.println("Enter your choice:");
				System.out.println("Enter 1 to add books");
				System.out.println("Enter 2 for Exit!!!!");
				int choice = Integer.parseInt(scanner.nextLine());
				
				switch(choice) {
				case 1:
					id.InsertBook();
					break;	

				case 2:
					System.out.println("Thank you!!!!!!!!!!!! please exit............");
					break;
				 default : System.out.println("Please enter a valid number");
			      break;
				}
				}
			
				catch(Exception e) {
					throw new RuntimeException("Something went wrong");
					
				}
				

			}
			
			public void InsertBook() throws SQLException {
				
				String sql = "insert into book(book_name,author_name,genre,price) values (?,?,?,?)";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				
				System.out.println("Enter book name");
				preparedStatement.setString(1,scanner.nextLine());
				
				System.out.println("Enter author name");
				preparedStatement.setString(2,scanner.nextLine());
				
				System.out.println("Enter genre");
				preparedStatement.setString(3,scanner.nextLine());
				
				System.out.println("Enter price");
				preparedStatement.setInt(4,Integer.parseInt(scanner.nextLine()));

				 int rows = preparedStatement.executeUpdate(); 
				 if(rows>0) {
					 System.out.println("Record inserted successfully...");
				 }
			}
		}