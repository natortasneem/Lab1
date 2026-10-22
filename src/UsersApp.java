
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UsersApp {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        try {
            File file = new File("users.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {

                String line = reader.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");

                if (parts.length == 2) {

                    String username = parts[0];
                    String password = parts[1];

                    try {
                        User user = new User(username, password);
                        users.add(user);

                    } catch (IllegalArgumentException e) {
                        // Invalid user: skip this line
                    }
                }
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            return;
        }

        // Sort valid users by username
        Collections.sort(users,
                (u1, u2) -> u1.getName().compareTo(u2.getName())
        );

        // Print valid users
        for (User user : users) {
            System.out.println(user);
        }
    }
}
