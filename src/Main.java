import exceptions.NotConfirmedPasswordException;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        validateUser("Chupakabra86", "qwerty123456", "qwerty123456");
    }

    public static boolean validateLogin(String login) {
        if (!login.matches("[a-zA-Z0-9_]+") || login.length() > 20) {
            throw new WrongLoginException();
        }
        return true;
    }
    public static boolean validatePassword(String password) {
        if (!password.matches("[a-zA-Z0-9_]+") || password.length() > 20) {
            throw new WrongPasswordException();
        }
        return true;
    }
    public static boolean confirmPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new NotConfirmedPasswordException();
        }
        return true;
    }
    public static void validateUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException, NotConfirmedPasswordException {
        try {
            System.out.println("Проверка..");
            validateLogin(login);
            validatePassword(password);
            confirmPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Логин не соответствует требованиям!");
        } catch (WrongPasswordException e) {
            System.out.println("Пароль не соответствует требованиям!");
        } catch (NotConfirmedPasswordException e) {
            System.out.println("Пароль не совпадает с проверочным!");
        } finally {
            System.out.println("Проверка закончена");
        }
    }
}