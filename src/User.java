public class User {
    private String username;
    private String password;

    public User(String username, String password){
        if (username.length() > 50) {
            throw new IllegalArgumentException(
                    "Username is too long, try something shorter"
            );
        }
        if (!username.contains("@")) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        if (username.lastIndexOf(".") == -1) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        int atIndex = username.indexOf("@");
        int dotIndex = username.lastIndexOf(".");

        if (dotIndex <= atIndex + 1 ||
                dotIndex >= username.length() - 2) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        String suffix = username.substring(dotIndex + 1);

        if (!suffix.matches("[a-zA-Z]{2,}")) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        String firstPart = username.substring(0, atIndex);

        if (!firstPart.matches("[a-zA-Z0-9._%+-]+")) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        String secondPart = username.substring(atIndex + 1, dotIndex);

        if (!secondPart.matches("[a-zA-Z0-9][a-zA-Z0-9.-]*")) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        if (username.indexOf("@") != username.lastIndexOf("@")) {
            throw new IllegalArgumentException(
                    "Please enter a valid Email as username"
            );
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException(
                    "Your password is too short, add more characters"
            );
        }

        if (password.length() > 12) {
            throw new IllegalArgumentException(
                    "Your password is too long, try a shorter one"
            );
        }

        if (!password.matches("[a-zA-Z0-9!@#$%^&*()]+")) {
            throw new IllegalArgumentException(
                    "Please enter a valid password"
            );
        }

        if (!password.matches(".*[a-zA-Z].*") ||
                !password.matches(".*[0-9].*") ||
                !password.matches(".*[!@#$%^&*()].*")) {

            throw new IllegalArgumentException(
                    "Please enter a valid password"
            );
        }


        this.username = username;
        this.password = password;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return username + " " + password;
    }

}
