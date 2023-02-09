import Admin.Admin;
import Devices.*;
import Characteristic.*;
import com.mysql.cj.protocol.Resultset;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Devices> devices = new ArrayList<>();
        Basket basket = new Basket();
        System.out.println("Welcome");
        System.out.println("What are you want?" + "\n" +
                "1. Show all available products;\n" +
                "2. Make purchase;\n" +
                "3. Show my basket;\n" +
                "4. Log in as Admin\n" +
                "0. Exit");
        int selection = sc.nextInt();
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        ResultSet resultSet= null;
        ResultSet resultSet1 = null;
        ResultSet resultSet2 = null;
        ResultSet resultSet3 = null;
        ResultSet resultSet4 = null;
        while(true) {
            switch (selection) {
                case 1:
                    try (Connection conn = DriverManager.getConnection(DBEngine.url, DBEngine.user, DBEngine.password)) {
                        Statement statement = conn.createStatement();
                        resultSet = statement.executeQuery("SELECT* FROM laptop");
                        System.out.println("All available laptops: ");
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String os = resultSet.getString(2);
                            String type = resultSet.getString(3);
                            String characteristic = resultSet.getString(4);
                            int number = resultSet.getInt(5);
                            int price = resultSet.getInt(6);
                            String brand = resultSet.getString(7);
                            System.out.printf("%d. Os: %s; Type: %s; Brand: %s; Characteristic: %s; Price: %d tenge; Count: %s; \n", id, os, type, brand, characteristic, price, number);
                        }
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("All available keyboards: ");
                        resultSet = statement.executeQuery("Select * FROM keyboard");
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String model = resultSet.getString(3);
                            String brand = resultSet.getString(4);
                            String Interface = resultSet.getString(6);
                            String type_of_buttons = resultSet.getString(5);
                            double weight = resultSet.getDouble(8);
                            int price = resultSet.getInt(2);
                            int count = resultSet.getInt(7);
                            System.out.printf("%d. Model: %s; Brand: %s; Interface: %s; Type of buttons: %s; Weight: %f grams; Price: %d tenge; Count: %d\n", id, model, brand, Interface, type_of_buttons, weight, price, count);
                        }
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("All available mouses: ");
                        resultSet = statement.executeQuery("Select* FROM mouse");
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String model = resultSet.getString(3);
                            String brand = resultSet.getString(6);
                            String connection_type = resultSet.getString(9);
                            int buttons = resultSet.getInt(8);
                            double weight = resultSet.getDouble(4);
                            String Sensitivity = resultSet.getString(5);
                            int count = resultSet.getInt(2);
                            int price = resultSet.getInt(7);
                            System.out.printf("%d. Model: %s; Brand: %s; Connection type: %s; Buttons count: %d; Weight: %f; Sensitivity: %s; Price: %d tenge; Count: %d\n", id, model, brand, connection_type, buttons, weight, Sensitivity, count, price);
                        }
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("All available processors: ");
                        resultSet = statement.executeQuery("SELECT * FROM processor");
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String model = resultSet.getString(2);
                            String brand = resultSet.getString(7);
                            String type = resultSet.getString(9);
                            int countNucleus = resultSet.getInt(5);
                            double hz = resultSet.getDouble(4);
                            int storage = resultSet.getInt(8);
                            int price = resultSet.getInt(2);
                            int count = resultSet.getInt(6);
                            System.out.printf("%d. Model: %s; Brand: %s; Type: %s; Count of nucleus: %d; Hz: %f; Storage: %d; Price: %d tenge; Count: %d\n", id, model, brand, type, countNucleus, hz, storage, price, count);
                        }
                        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("All available monitors: ");
                        resultSet = statement.executeQuery("SELECT * FROM screen");
                        while (resultSet.next()) {
                            int id = resultSet.getInt(1);
                            String model = resultSet.getString(8);
                            String brand = resultSet.getString(7);
                            String matrix = resultSet.getString(4);
                            String quality = resultSet.getString(5);
                            double diagonal = resultSet.getDouble(9);
                            int hz = resultSet.getInt(3);
                            int price = resultSet.getInt(2);
                            int count = resultSet.getInt(6);
                            System.out.printf("%d. Model: %s; Brand: %s; Matrix: %s; Quality: %s; Diagonal: %f; Hz: %d; Price: %d tenge; Count: %d\n", id, model, brand, matrix, quality, diagonal, hz, price, count);
                        }

                    } catch (Exception ex) {
                        System.out.println("Connection failed...");
                        System.out.println(ex);
                    }
                    break;
                case 0:
                    System.out.print("Have a nice day!");
                    System.exit(1);
                    break;
                case 2:
                    try (Connection conn = DriverManager.getConnection(DBEngine.url, DBEngine.user, DBEngine.password)) {
                        Statement statement = conn.createStatement();
                        Statement statement1 = conn.createStatement();
                        System.out.println("Hello! What do you want?\n" +
                                "1. Monitor\n" +
                                "2. Mouse\n" +
                                "3. Keyboard\n" +
                                "4. Processor\n" +
                                "5. Laptop\n");
                        int select = sc.nextInt();
                        switch (select) {
                            case 1:
                                resultSet1 = statement.executeQuery("SELECT * FROM screen");
                                System.out.println("Enter product's id:");
                                int product_id1 = sc.nextInt();
                                while (resultSet1.next()) {
                                    if (resultSet1.getInt(1) == product_id1) {
                                        Statement statement2 = conn.createStatement();
                                        statement2.executeUpdate("UPDATE screen SET amount = amount - 1");
                                        int id = resultSet1.getInt(1);
                                        String model = resultSet1.getString(8);
                                        String brand = resultSet1.getString(7);
                                        String matrix = resultSet1.getString(4);
                                        String quality = resultSet1.getString(5);
                                        double diagonal = resultSet1.getDouble(9);
                                        int hz = resultSet1.getInt(3);
                                        int price = resultSet1.getInt(2);
                                        int count = resultSet1.getInt(6);
                                        Devices screen = new Monitor(id, price, 1, brand, model, hz, diagonal, matrix, quality);
                                        boolean flag = false;
                                        for (Devices device : basket.getDevices()) {
                                            if (device instanceof Monitor && device.getId() == product_id1) {
                                                flag = true;
                                            }
                                        }
                                        if (flag == false) {
                                            devices.add(screen);
                                            basket.addDevice(screen);
                                        } else {
                                            for (int i = 0; i < basket.getDevices().size(); i++) {
                                                if (basket.getDevices().get(i).getId() == product_id1 && basket.getDevices().get(i) instanceof Monitor) {
                                                    basket.getDevices().get(i).setCount(screen.getCount() + 1);
                                                }
                                            }


                                        }
                                    }
                                }
                                statement.executeUpdate("DELETE FROM screen WHERE amount <=0");
                                System.out.println("Added");
                                break;
                            case 2:
                                resultSet1 = statement.executeQuery("SELECT * FROM mouse");
                                System.out.println("Enter product's id:");
                                int product_id2 = sc.nextInt();
                                while (resultSet1.next()) {
                                    if (resultSet1.getInt(1) == product_id2) {
                                        statement.executeUpdate("UPDATE mouse SET amount = amount -1");
                                        int id = resultSet1.getInt(1);
                                        String model = resultSet1.getString(3);
                                        String brand = resultSet1.getString(6);
                                        String connection_type = resultSet1.getString(9);
                                        int buttons = resultSet1.getInt(8);
                                        double weight = resultSet1.getDouble(4);
                                        String Sensitivity = resultSet1.getString(5);
                                        int count = resultSet1.getInt(7);
                                        int price = resultSet1.getInt(2);
                                        Devices mouse = new Mouse(id, price, 1, brand, model, weight, buttons, Sensitivity, connection_type);
                                        boolean flag = false;
                                        for (Devices device : basket.getDevices()) {
                                            if (device instanceof Mouse && device.getId() == product_id2) {
                                                flag = true;
                                            }
                                        }
                                        if (flag == false) {
                                            devices.add(mouse);
                                            basket.addDevice(mouse);
                                        } else {
                                            for (int i = 0; i < basket.getDevices().size(); i++) {
                                                if (basket.getDevices().get(i).getId() == product_id2 && basket.getDevices().get(i) instanceof Mouse) {
                                                    basket.getDevices().get(i).setCount(mouse.getCount() + 1);
                                                }
                                            }
                                        }
                                    }
                                }
                                statement1.executeUpdate("DELETE FROM mouse WHERE amount <=0");
                                System.out.println("Added");
                                break;
                            case 3:
                                resultSet1 = statement.executeQuery("SELECT * FROM keyboard");
                                System.out.println("Enter product's id:");
                                int product_id3 = sc.nextInt();
                                while (resultSet1.next()) {
                                    if (resultSet1.getInt(1) == product_id3) {
                                        Statement statement2 = conn.createStatement();
                                        statement2.executeUpdate("UPDATE keyboard SET amount = amount -1");
                                        int id = resultSet1.getInt(1);
                                        String model = resultSet1.getString(3);
                                        String brand = resultSet1.getString(4);
                                        String Interface = resultSet1.getString(6);
                                        String type_of_buttons = resultSet1.getString(5);
                                        double weight = resultSet1.getDouble(8);
                                        int price = resultSet1.getInt(2);
                                        int count = resultSet1.getInt(7);
                                        Devices keyboard = new Keyboard(id, price, 1, brand, model, Interface, type_of_buttons, weight);
                                        boolean flag = false;
                                        for (Devices device : basket.getDevices()) {
                                            if (device instanceof Keyboard && device.getId() == product_id3) {
                                                flag = true;
                                            }
                                        }
                                        if (flag == false) {
                                            devices.add(keyboard);
                                            basket.addDevice(keyboard);
                                        } else {
                                            for (int i = 0; i < basket.getDevices().size(); i++) {
                                                if (basket.getDevices().get(i).getId() == product_id3 && basket.getDevices().get(i) instanceof Keyboard) {
                                                    basket.getDevices().get(i).setCount(keyboard.getCount() + 1);
                                                }
                                            }
                                        }
                                    }
                                }
                                statement1.executeUpdate("DELETE FROM keyboard WHERE amount <=0");
                                System.out.println("Added");
                                break;
                            case 4:
                                resultSet1 = statement.executeQuery("SELECT * FROM processor");
                                System.out.println("Enter product's id:");
                                int product_id4 = sc.nextInt();
                                while (resultSet1.next()) {
                                    if (resultSet1.getInt(1) == product_id4) {
                                        Statement statement2 = conn.createStatement();
                                        statement2.executeUpdate("UPDATE processor SET amount = amount -1");
                                        int id = resultSet1.getInt(1);
                                        String model = resultSet1.getString(3);
                                        String brand = resultSet1.getString(7);
                                        String type = resultSet1.getString(9);
                                        int countNucleus = resultSet1.getInt(5);
                                        double hz = resultSet1.getDouble(4);
                                        int storage = resultSet1.getInt(8);
                                        int price = resultSet1.getInt(2);
                                        int count = resultSet1.getInt(6);
                                        Devices processor = new Processor(id, price, 1, brand, model, hz, countNucleus, storage, type);
                                        boolean flag = false;
                                        for (Devices device : basket.getDevices()) {
                                            if (device instanceof Processor && device.getId() == product_id4) {
                                                flag = true;
                                            }
                                        }
                                        if (flag == false) {
                                            devices.add(processor);
                                            basket.addDevice(processor);
                                        } else {
                                            for (int i = 0; i < basket.getDevices().size(); i++) {
                                                if (basket.getDevices().get(i).getId() == product_id4 && basket.getDevices().get(i) instanceof Processor) {
                                                    basket.getDevices().get(i).setCount(processor.getCount() + 1);
                                                }
                                            }
                                        }
                                    }
                                }
                                statement1.executeUpdate("DELETE FROM processor WHERE amount <=0");
                                System.out.println("Added");
                                break;
                            case 5:
                                resultSet1 = statement.executeQuery("SELECT * FROM laptop");
                                System.out.println("Enter product's id:");
                                int product_id5 = sc.nextInt();
                                while (resultSet1.next()) {
                                    if (resultSet1.getInt(1) == product_id5) {
                                        Statement statement2 = conn.createStatement();
                                        statement2.executeUpdate("UPDATE laptop SET amount = amount -1");
                                        int id = resultSet1.getInt(1);
                                        String os = resultSet1.getString(2);
                                        String type = resultSet1.getString(3);
                                        String characteristic = resultSet1.getString(4);
                                        int number = resultSet1.getInt(5);
                                        int price = resultSet1.getInt(6);
                                        String brand = resultSet1.getString(7);
                                        Devices laptop = new Laptop(id, price, 1, brand, os, type, characteristic);
                                        boolean flag = false;
                                        for (Devices device : basket.getDevices()) {
                                            if (device instanceof Laptop && device.getId() == product_id5) {
                                                flag = true;
                                            }
                                        }
                                        if (flag == false) {
                                            devices.add(laptop);
                                            basket.addDevice(laptop);
                                        } else {
                                            for (int i = 0; i < basket.getDevices().size(); i++) {
                                                if (basket.getDevices().get(i).getId() == product_id5 && basket.getDevices().get(i) instanceof Laptop) {
                                                    basket.getDevices().get(i).setCount(laptop.getCount() + 1);
                                                }
                                            }
                                        }
                                    }
                                }
                                statement1.executeUpdate("DELETE FROM laptop WHERE amount <=0");
                                System.out.println("Added");
                                break;
                        }
                    } catch (Exception ex) {
                        System.out.println("Connection failed...");
                        System.out.println(ex);
                    }
                    break;
                case 3:
                    System.out.println("This is your check:");
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println(basket.show());
                    System.out.println("Full cost: " + basket.buy(devices));
                    System.out.println("---------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Enter login:");
                    String login = sc.next();
                    System.out.println("Enter password:");
                    String password = sc.next();
                    Admin admin = new Admin(login, password);
                    if (admin.forAdmin(login, password)) {
                        System.out.println("What are you want?" + "\n" +
                                "1. Edit products;\n" +
                                "2. Add new product;\n" +
                                "3. Remove products;\n" +
                                "4. Exit from admin;");
                        int selects = sc.nextInt();
                        while (true) {
                            switch (selects) {
                                case 1:
                                    try (Connection conn = DriverManager.getConnection(DBEngine.url, DBEngine.user, DBEngine.password)) {
                                        Statement statement = conn.createStatement();
                                        System.out.println("Hello! What do you want?\n" +
                                                "1. Monitor\n" +
                                                "2. Mouse\n" +
                                                "3. Keyboard\n" +
                                                "4. Processor\n" +
                                                "5. Laptop\n");
                                        int admin_sel = sc.nextInt();
                                        switch (admin_sel) {
                                            case 1:
                                                resultSet2 = statement.executeQuery("SELECT * FROM screen");
                                                while (resultSet2.next()) {
                                                    int id = resultSet2.getInt(1);
                                                    String model = resultSet2.getString(8);
                                                    String brand = resultSet2.getString(7);
                                                    String matrix = resultSet2.getString(4);
                                                    String quality = resultSet2.getString(5);
                                                    double diagonal = resultSet2.getDouble(9);
                                                    int hz = resultSet2.getInt(3);
                                                    int price = resultSet2.getInt(2);
                                                    int count = resultSet2.getInt(6);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Matrix: %s; Quality: %s; Diagonal: %f; Hz: %d; Price: %d tenge; Count: %d\n", id, model, brand, matrix, quality, diagonal, hz, price, count);
                                                }
                                                System.out.print("Which monitor? (id) ");
                                                int monitor_id = sc.nextInt();
                                                resultSet2 = statement.executeQuery("SELECT * FROM screen");
                                                while (resultSet2.next()) {
                                                    if (resultSet2.getInt(1) == monitor_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + monitor_id;
                                                        statement.executeUpdate(sql);
                                                        System.out.print("ID: ");
                                                        int id = sc.nextInt();
                                                        sc.nextLine();
                                                        System.out.print("Model: ");
                                                        String model = sc.next();
                                                        System.out.print("Brand: ");
                                                        String brand = sc.next();
                                                        System.out.print("Matrix: ");
                                                        String matrix = sc.next();
                                                        System.out.print("Quality: ");
                                                        String quality = sc.next();
                                                        System.out.print("Diagonal: ");
                                                        double diagonal = sc.nextDouble();
                                                        System.out.print("HZ: ");
                                                        int hz = sc.nextInt();
                                                        System.out.print("Price: ");
                                                        int price = sc.nextInt();
                                                        System.out.print("Count: ");
                                                        int count = sc.nextInt();
                                                        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO screen(id, Price, Hz, matrix, quality, amount, brend, model, Screen_diagonal) Values (?, ?,?,?,?,?,?,?,?)");
                                                        preparedStatement.setInt(1, id);
                                                        preparedStatement.setInt(2, price);
                                                        preparedStatement.setDouble(3, hz);
                                                        preparedStatement.setString(4, matrix);
                                                        preparedStatement.setString(5, quality);
                                                        preparedStatement.setInt(6, count);
                                                        preparedStatement.setString(7, brand);
                                                        preparedStatement.setString(8, model);
                                                        preparedStatement.setDouble(9, diagonal);
                                                        preparedStatement.executeUpdate();
                                                    }
                                                }
                                                break;
                                            case 2:
                                                resultSet2 = statement.executeQuery("Select* FROM mouse");
                                                while (resultSet2.next()) {
                                                    int id = resultSet2.getInt(1);
                                                    String model = resultSet2.getString(3);
                                                    String brand = resultSet2.getString(6);
                                                    String connection_type = resultSet2.getString(9);
                                                    int buttons = resultSet2.getInt(8);
                                                    double weight = resultSet2.getDouble(4);
                                                    String Sensitivity = resultSet2.getString(5);
                                                    int count = resultSet2.getInt(2);
                                                    int price = resultSet2.getInt(7);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Connection type: %s; Buttons count: %d; Weight: %f; Sensitivity: %s; Price: %d tenge; Count: %d\n", id, model, brand, connection_type, buttons, weight, Sensitivity, count, price);
                                                }
                                                System.out.print("Which mouse? (id) ");
                                                int mouse_id = sc.nextInt();
                                                resultSet2 = statement.executeQuery("SELECT * FROM mouse");
                                                while (resultSet2.next()) {
                                                    if (resultSet2.getInt(1) == mouse_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + mouse_id;
                                                        statement.executeUpdate(sql);
                                                        System.out.print("ID: ");
                                                        int id = sc.nextInt();
                                                        System.out.print("Model: ");
                                                        String model = sc.next();
                                                        System.out.print("Brand: ");
                                                        String brand = sc.next();
                                                        System.out.print("Connection type: ");
                                                        String connection_type = sc.next();
                                                        System.out.print("Buttons: ");
                                                        int buttons = sc.nextInt();
                                                        System.out.print("Weight: ");
                                                        double weight = sc.nextDouble();
                                                        System.out.print("Sensitivity: ");
                                                        String sens = sc.next();
                                                        System.out.print("Count: ");
                                                        int count = sc.nextInt();
                                                        System.out.print("Price: ");
                                                        int price = sc.nextInt();
                                                        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO mouse(id, Price, model, weight, sensitivity, brend,amount, Buttons,Connection_type) Values (?, ?,?,?,?,?,?,?,?)");
                                                        preparedStatement.setInt(1, id);
                                                        preparedStatement.setInt(2, price);
                                                        preparedStatement.setString(3, model);
                                                        preparedStatement.setDouble(4, weight);
                                                        preparedStatement.setString(5, sens);
                                                        preparedStatement.setString(6, brand);
                                                        preparedStatement.setInt(7, count);
                                                        preparedStatement.setInt(8, buttons);
                                                        preparedStatement.setString(9, connection_type);
                                                    }
                                                }
                                                break;
                                            case 3:
                                                resultSet2 = statement.executeQuery("Select * FROM keyboard");
                                                while (resultSet2.next()) {
                                                    int id = resultSet2.getInt(1);
                                                    String model = resultSet2.getString(3);
                                                    String brand = resultSet2.getString(4);
                                                    String Interface = resultSet2.getString(6);
                                                    String type_of_buttons = resultSet2.getString(5);
                                                    double weight = resultSet2.getDouble(8);
                                                    int price = resultSet2.getInt(2);
                                                    int count = resultSet2.getInt(7);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Interface: %s; Type of buttons: %s; Weight: %f grams; Price: %d tenge; Count: %d\n", id, model, brand, Interface, type_of_buttons, weight, price, count);
                                                }
                                                System.out.print("Which keyboard? (id) ");
                                                int keyboard_id = sc.nextInt();
                                                resultSet2 = statement.executeQuery("SELECT * FROM keyboard");
                                                while (resultSet2.next()) {
                                                    if (resultSet2.getInt(1) == keyboard_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + keyboard_id;
                                                        statement.executeUpdate(sql);
                                                        System.out.print("ID: ");
                                                        int id = sc.nextInt();
                                                        System.out.print("Model: ");
                                                        String model = sc.next();
                                                        System.out.print("Brand: ");
                                                        String brand = sc.next();
                                                        System.out.print("Interface: ");
                                                        String inter = sc.next();
                                                        System.out.print("Type of buttons: ");
                                                        String buttons = sc.next();
                                                        System.out.print("Weight: ");
                                                        double weight = sc.nextDouble();
                                                        System.out.print("Count: ");
                                                        int count = sc.nextInt();
                                                        System.out.print("Price: ");
                                                        int price = sc.nextInt();
                                                        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO keyboard(id, price, model, brend, type_of_buttons, Interface,amount,weight) Values (?, ?,?,?,?,?,?,?)");
                                                        preparedStatement.setInt(1, id);
                                                        preparedStatement.setInt(2, price);
                                                        preparedStatement.setString(3, model);
                                                        preparedStatement.setString(4, brand);
                                                        preparedStatement.setString(5, buttons);
                                                        preparedStatement.setString(6, inter);
                                                        preparedStatement.setInt(7, count);
                                                        preparedStatement.setDouble(8, weight);
                                                    }
                                                }
                                                break;
                                            case 4:
                                                resultSet2 = statement.executeQuery("SELECT * FROM processor");
                                                while (resultSet2.next()) {
                                                    int id = resultSet2.getInt(1);
                                                    String model = resultSet2.getString(2);
                                                    String brand = resultSet2.getString(7);
                                                    String type = resultSet2.getString(9);
                                                    int countNucleus = resultSet2.getInt(5);
                                                    double hz = resultSet2.getDouble(4);
                                                    int storage = resultSet2.getInt(8);
                                                    int price = resultSet2.getInt(2);
                                                    int count = resultSet2.getInt(6);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Type: %s; Count of nucleus: %d; Hz: %f; Storage: %d; Price: %d tenge; Count: %d\n", id, model, brand, type, countNucleus, hz, storage, price, count);
                                                }
                                                System.out.print("Which processor? (id) ");
                                                int processor_id = sc.nextInt();
                                                resultSet2 = statement.executeQuery("SELECT * FROM processor");
                                                while (resultSet1.next()) {
                                                    if (resultSet1.getInt(1) == processor_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + processor_id;
                                                        statement.executeUpdate(sql);
                                                        System.out.print("ID: ");
                                                        int id = sc.nextInt();
                                                        System.out.print("Model: ");
                                                        String model = sc.next();
                                                        System.out.print("Brand: ");
                                                        String brand = sc.next();
                                                        System.out.print("Type: ");
                                                        String type = sc.next();
                                                        System.out.print("Count of nucleus: ");
                                                        int count_of_nucleus = sc.nextInt();
                                                        System.out.print("HZ: ");
                                                        double hz = sc.nextDouble();
                                                        System.out.print("Storage: ");
                                                        int storage = sc.nextInt();
                                                        System.out.print("Count: ");
                                                        int count = sc.nextInt();
                                                        System.out.print("Price: ");
                                                        int price = sc.nextInt();
                                                        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO processor(id, price, model, Ghz, countNucleus,amount,brend, storage,kind) Values (?, ?,?,?,?,?,?,?,?)");
                                                        preparedStatement.setInt(1, id);
                                                        preparedStatement.setInt(2, price);
                                                        preparedStatement.setString(3, model);
                                                        preparedStatement.setDouble(4, hz);
                                                        preparedStatement.setInt(5, count_of_nucleus);
                                                        preparedStatement.setString(7, brand);
                                                        preparedStatement.setInt(6, count);
                                                        preparedStatement.setInt(8, storage);
                                                        preparedStatement.setString(9, type);
                                                    }
                                                }
                                                break;
                                            case 5:
                                                resultSet2 = statement.executeQuery("SELECT* FROM laptop");
                                                System.out.println("All available laptops: ");
                                                while (resultSet2.next()) {
                                                    int id = resultSet2.getInt(1);
                                                    String os = resultSet2.getString(2);
                                                    String type = resultSet2.getString(3);
                                                    String characteristic = resultSet2.getString(4);
                                                    int number = resultSet2.getInt(5);
                                                    int price = resultSet2.getInt(6);
                                                    String brand = resultSet2.getString(7);
                                                    System.out.printf("%d. Os: %s; Type: %s; Brand: %s; Characteristic: %s; Price: %d tenge; Count: %s; \n", id, os, type, brand, characteristic, price, number);
                                                }
                                                System.out.print("Which laptop? (id) ");
                                                int laptop_id = sc.nextInt();
                                                resultSet2 = statement.executeQuery("SELECT* FROM laptop");
                                                while (resultSet1.next()) {
                                                    if (resultSet1.getInt(1) == laptop_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + laptop_id;
                                                        statement.executeUpdate(sql);
                                                        System.out.print("Id: ");
                                                        int id = sc.nextInt();
                                                        System.out.print("OS: ");
                                                        String os = sc.next();
                                                        System.out.print("Type: ");
                                                        String type = sc.next();
                                                        System.out.print("Characteristic: ");
                                                        String characteristic = sc.next();
                                                        System.out.print("Count: ");
                                                        int count = sc.nextInt();
                                                        System.out.print("Price: ");
                                                        int price = sc.nextInt();
                                                        System.out.print("Brand: ");
                                                        String brand = sc.next();
                                                        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO laptop(id, OS, kind, Characteristic, amount, price, brand) Values (?, ?,?,?,?,?,?)");
                                                        preparedStatement.setInt(1, id);
                                                        preparedStatement.setString(2, os);
                                                        preparedStatement.setString(3, type);
                                                        preparedStatement.setString(4, characteristic);
                                                        preparedStatement.setInt(5, count);
                                                        preparedStatement.setString(7, brand);
                                                        preparedStatement.setInt(6, price);
                                                    }
                                                }
                                                break;
                                        }
                                    } 
                                    catch (Exception ex) {
                                        System.out.println("Good");
                                    }
                                    break;
                                case 2://adding
                                    try (Connection conn = DriverManager.getConnection(DBEngine.url, DBEngine.user, DBEngine.password)) {
                                        Statement statement = conn.createStatement();
                                        System.out.println("Hello! What do you want?\n" +
                                                "1. Monitor\n" +
                                                "2. Mouse\n" +
                                                "3. Keyboard\n" +
                                                "4. Processor\n" +
                                                "5. Laptop\n" +
                                                "6. Create pc\n");
                                        int admin_sel = sc.nextInt();
                                        switch (admin_sel) {
                                            case 1:
                                                resultSet3 = statement.executeQuery("SELECT * FROM screen");
                                                while (resultSet3.next()) {
                                                    int id = resultSet3.getInt(1);
                                                    String model = resultSet3.getString(8);
                                                    String brand = resultSet3.getString(7);
                                                    String matrix = resultSet3.getString(4);
                                                    String quality = resultSet3.getString(5);
                                                    double diagonal = resultSet3.getDouble(9);
                                                    int hz = resultSet3.getInt(3);
                                                    int price = resultSet3.getInt(2);
                                                    int count = resultSet3.getInt(6);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Matrix: %s; Quality: %s; Diagonal: %f; Hz: %d; Price: %d tenge; Count: %d\n", id, model, brand, matrix, quality, diagonal, hz, price, count);
                                                }
                                                System.out.print("ID: ");
                                                int id = sc.nextInt();
                                                sc.nextLine();
                                                System.out.print("Model: ");
                                                String model = sc.next();
                                                System.out.print("Brand: ");
                                                String brand = sc.next();
                                                System.out.print("Matrix: ");
                                                String matrix = sc.next();
                                                System.out.print("Quality: ");
                                                String quality = sc.next();
                                                System.out.print("Diagonal: ");
                                                double diagonal = sc.nextDouble();
                                                System.out.print("HZ: ");
                                                int hz = sc.nextInt();
                                                System.out.print("Price: ");
                                                int price = sc.nextInt();
                                                System.out.print("Count: ");
                                                int count = sc.nextInt();
                                                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO screen(id, Price, Hz, matrix, quality, amount, brend, model, Screen_diagonal) Values (?, ?,?,?,?,?,?,?,?)");
                                                preparedStatement.setInt(1, id);
                                                preparedStatement.setInt(2, price);
                                                preparedStatement.setDouble(3, hz);
                                                preparedStatement.setString(4, matrix);
                                                preparedStatement.setString(5, quality);
                                                preparedStatement.setInt(6, count);
                                                preparedStatement.setString(7, brand);
                                                preparedStatement.setString(8, model);
                                                preparedStatement.setDouble(9, diagonal);
                                                preparedStatement.executeUpdate();
                                                break;
                                            case 2:
                                                resultSet3 = statement.executeQuery("SELECT * FROM screen");
                                                while (resultSet3.next()) {
                                                    id = resultSet3.getInt(1);
                                                    model = resultSet3.getString(3);
                                                    brand = resultSet3.getString(6);
                                                    String connection_type = resultSet3.getString(9);
                                                    int buttons = resultSet3.getInt(8);
                                                    double weight = resultSet3.getDouble(4);
                                                    String Sensitivity = resultSet3.getString(5);
                                                    count = resultSet3.getInt(2);
                                                    price = resultSet3.getInt(7);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Connection type: %s; Buttons count: %d; Weight: %f; Sensitivity: %s; Price: %d tenge; Count: %d\n", id, model, brand, connection_type, buttons, weight, Sensitivity, count, price);
                                                }
                                                System.out.print("ID: ");
                                                id = sc.nextInt();
                                                System.out.print("Model: ");
                                                model = sc.next();
                                                System.out.print("Brand: ");
                                                brand = sc.next();
                                                System.out.print("Connection type: ");
                                                String connection_type = sc.next();
                                                System.out.print("Buttons: ");
                                                int buttons = sc.nextInt();
                                                System.out.print("Weight: ");
                                                double weight = sc.nextDouble();
                                                System.out.print("Sensitivity: ");
                                                String sens = sc.next();
                                                System.out.print("Count: ");
                                                count = sc.nextInt();
                                                System.out.print("Price: ");
                                                price = sc.nextInt();
                                                preparedStatement = conn.prepareStatement("INSERT INTO mouse(id, Price, model, weight, sensitivity, brend,amount, Buttons,Connection_type) Values (?, ?,?,?,?,?,?,?,?)");
                                                preparedStatement.setInt(1, id);
                                                preparedStatement.setInt(2, price);
                                                preparedStatement.setString(3, model);
                                                preparedStatement.setDouble(4, weight);
                                                preparedStatement.setString(5, sens);
                                                preparedStatement.setString(6, brand);
                                                preparedStatement.setInt(7, count);
                                                preparedStatement.setInt(8, buttons);
                                                preparedStatement.setString(9, connection_type);
                                                break;
                                            case 3:
                                                resultSet2 = statement.executeQuery("Select * FROM keyboard");
                                                while (resultSet2.next()) {
                                                    id = resultSet2.getInt(1);
                                                    model = resultSet2.getString(3);
                                                    brand = resultSet2.getString(4);
                                                    String Interface = resultSet2.getString(6);
                                                    String type_of_buttons = resultSet2.getString(5);
                                                    weight = resultSet2.getDouble(8);
                                                    price = resultSet2.getInt(2);
                                                    count = resultSet2.getInt(7);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Interface: %s; Type of buttons: %s; Weight: %f grams; Price: %d tenge; Count: %d\n", id, model, brand, Interface, type_of_buttons, weight, price, count);
                                                }
                                                System.out.print("ID: ");
                                                id = sc.nextInt();
                                                System.out.print("Model: ");
                                                model = sc.next();
                                                System.out.print("Brand: ");
                                                brand = sc.next();
                                                System.out.print("Interface: ");
                                                String inter = sc.next();
                                                System.out.print("Type of buttons: ");
                                                String buttonsT = sc.next();
                                                System.out.print("Weight: ");
                                                weight = sc.nextDouble();
                                                System.out.print("Count: ");
                                                count = sc.nextInt();
                                                System.out.print("Price: ");
                                                price = sc.nextInt();
                                                preparedStatement = conn.prepareStatement("INSERT INTO keyboard(id, price, model, brend, type_of_buttons, Interface,amount,weight) Values (?, ?,?,?,?,?,?,?)");
                                                preparedStatement.setInt(1, id);
                                                preparedStatement.setInt(2, price);
                                                preparedStatement.setString(3, model);
                                                preparedStatement.setString(4, brand);
                                                preparedStatement.setString(5, buttonsT);
                                                preparedStatement.setString(6, inter);
                                                preparedStatement.setInt(7, count);
                                                preparedStatement.setDouble(8, weight);

                                                break;
                                            case 4:
                                                resultSet2 = statement.executeQuery("SELECT * FROM processor");
                                                while (resultSet2.next()) {
                                                    id = resultSet2.getInt(1);
                                                    model = resultSet2.getString(2);
                                                    brand = resultSet2.getString(7);
                                                    String type = resultSet2.getString(9);
                                                    int countNucleus = resultSet2.getInt(5);
                                                    double Ghz = resultSet2.getDouble(4);
                                                    int storage = resultSet2.getInt(8);
                                                    price = resultSet2.getInt(2);
                                                    count = resultSet2.getInt(6);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Type: %s; Count of nucleus: %d; GHz: %f; Storage: %d; Price: %d tenge; Count: %d\n", id, model, brand, type, countNucleus, Ghz, storage, price, count);
                                                }
                                                System.out.print("ID: ");
                                                id = sc.nextInt();
                                                System.out.print("Model: ");
                                                model = sc.next();
                                                System.out.print("Brand: ");
                                                brand = sc.next();
                                                System.out.print("Type: ");
                                                String type = sc.next();
                                                System.out.print("Count of nucleus: ");
                                                int count_of_nucleus = sc.nextInt();
                                                System.out.print("HZ: ");
                                                double Ghz = sc.nextDouble();
                                                System.out.print("Storage: ");
                                                int storage = sc.nextInt();
                                                System.out.print("Count: ");
                                                count = sc.nextInt();
                                                System.out.print("Price: ");
                                                price = sc.nextInt();
                                                preparedStatement = conn.prepareStatement("INSERT INTO processor(id, price, model, Ghz, countNucleus,amount,brend, storage,kind) Values (?, ?,?,?,?,?,?,?,?)");
                                                preparedStatement.setInt(1, id);
                                                preparedStatement.setInt(2, price);
                                                preparedStatement.setString(3, model);
                                                preparedStatement.setDouble(4, Ghz);
                                                preparedStatement.setInt(5, count_of_nucleus);
                                                preparedStatement.setString(7, brand);
                                                preparedStatement.setInt(6, count);
                                                preparedStatement.setInt(8, storage);
                                                preparedStatement.setString(9, type);
                                                break;
                                            case 5:
                                                resultSet = statement.executeQuery("SELECT* FROM laptop");
                                                System.out.println("All available laptops: ");
                                                while (resultSet.next()) {
                                                    id = resultSet.getInt(1);
                                                    String os = resultSet.getString(2);
                                                    type = resultSet.getString(3);
                                                    String characteristic = resultSet.getString(4);
                                                    int number = resultSet.getInt(5);
                                                    price = resultSet.getInt(6);
                                                    brand = resultSet.getString(7);
                                                    System.out.printf("%d. Os: %s; Type: %s; Brand: %s; Characteristic: %s; Price: %d tenge; Count: %s; \n", id, os, type, brand, characteristic, price, number);
                                                }
                                                System.out.print("Id: ");
                                                id = sc.nextInt();
                                                System.out.print("OS: ");
                                                String os = sc.next();
                                                System.out.print("Type: ");
                                                type = sc.next();
                                                System.out.print("Characteristic: ");
                                                String characteristic = sc.next();
                                                System.out.print("Count: ");
                                                count = sc.nextInt();
                                                System.out.print("Price: ");
                                                price = sc.nextInt();
                                                System.out.print("Brand: ");
                                                brand = sc.next();
                                                preparedStatement = conn.prepareStatement("INSERT INTO laptop(id, OS, kind, Characteristic, amount, price, brand) Values (?, ?,?,?,?,?,?)");
                                                preparedStatement.setInt(1, id);
                                                preparedStatement.setString(2, os);
                                                preparedStatement.setString(3, type);
                                                preparedStatement.setString(4, characteristic);
                                                preparedStatement.setInt(5, count);
                                                preparedStatement.setString(7, brand);
                                                preparedStatement.setInt(6, price);
                                                break;
                                        }
                                    } 
                                    catch (Exception ex) {
                                        System.out.println("Good");
                                    }
                                    break;
                                case 3:
                                    try (Connection conn = DriverManager.getConnection(DBEngine.url, DBEngine.user, DBEngine.password)) {
                                        Statement statement = conn.createStatement();
                                        System.out.println("Hello! What do you want?\n" +
                                                "1. Monitor\n" +
                                                "2. Mouse\n" +
                                                "3. Keyboard\n" +
                                                "4. Processor\n" +
                                                "5. Laptop\n" +
                                                "6. Create pc\n");
                                        int admin_sel = sc.nextInt();
                                        switch (admin_sel) {
                                            case 1:
                                                resultSet4 = statement.executeQuery("SELECT * FROM screen");
                                                while (resultSet4.next()) {
                                                    int id = resultSet4.getInt(1);
                                                    String model = resultSet4.getString(8);
                                                    String brand = resultSet4.getString(7);
                                                    String matrix = resultSet4.getString(4);
                                                    String quality = resultSet4.getString(5);
                                                    double diagonal = resultSet4.getDouble(9);
                                                    int hz = resultSet4.getInt(3);
                                                    int price = resultSet4.getInt(2);
                                                    int count = resultSet4.getInt(6);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Matrix: %s; Quality: %s; Diagonal: %f; Hz: %d; Price: %d tenge; Count: %d\n", id, model, brand, matrix, quality, diagonal, hz, price, count);
                                                }
                                                System.out.print("Which monitor? (id) ");
                                                int monitor_id = sc.nextInt();
                                                resultSet4 = statement.executeQuery("SELECT * FROM screen");
                                                while (resultSet4.next()) {
                                                    if (resultSet4.getInt(1) == monitor_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + monitor_id;
                                                        statement.executeUpdate(sql);
                                                    }
                                                }
                                                break;
                                            case 2:
                                                resultSet4 = statement.executeQuery("Select* FROM mouse");
                                                while (resultSet4.next()) {
                                                    int id = resultSet4.getInt(1);
                                                    String model = resultSet4.getString(3);
                                                    String brand = resultSet4.getString(6);
                                                    String connection_type = resultSet4.getString(9);
                                                    int buttons = resultSet4.getInt(8);
                                                    double weight = resultSet4.getDouble(4);
                                                    String Sensitivity = resultSet4.getString(5);
                                                    int count = resultSet4.getInt(2);
                                                    int price = resultSet4.getInt(7);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Connection type: %s; Buttons count: %d; Weight: %f; Sensitivity: %s; Price: %d tenge; Count: %d\n", id, model, brand, connection_type, buttons, weight, Sensitivity, count, price);
                                                }
                                                System.out.print("Which mouse? (id) ");
                                                int mouse_id = sc.nextInt();
                                                resultSet4 = statement.executeQuery("SELECT * FROM mouse");
                                                while (resultSet4.next()) {
                                                    if (resultSet4.getInt(1) == mouse_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + mouse_id;
                                                        statement.executeUpdate(sql);
                                                    }
                                                }
                                                break;
                                            case 3:
                                                resultSet4 = statement.executeQuery("Select * FROM keyboard");
                                                while (resultSet4.next()) {
                                                    int id = resultSet4.getInt(1);
                                                    String model = resultSet4.getString(3);
                                                    String brand = resultSet4.getString(4);
                                                    String Interface = resultSet4.getString(6);
                                                    String type_of_buttons = resultSet4.getString(5);
                                                    double weight = resultSet4.getDouble(8);
                                                    int price = resultSet4.getInt(2);
                                                    int count = resultSet4.getInt(7);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Interface: %s; Type of buttons: %s; Weight: %f grams; Price: %d tenge; Count: %d\n", id, model, brand, Interface, type_of_buttons, weight, price, count);
                                                }
                                                System.out.print("Which keyboard? (id) ");
                                                int keyboard_id = sc.nextInt();
                                                resultSet4 = statement.executeQuery("SELECT * FROM keyboard");
                                                while (resultSet4.next()) {
                                                    if (resultSet4.getInt(1) == keyboard_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + keyboard_id;
                                                        statement.executeUpdate(sql);
                                                    }
                                                }
                                                break;
                                            case 4:
                                                resultSet4 = statement.executeQuery("SELECT * FROM processor");
                                                while (resultSet4.next()) {
                                                    int id = resultSet4.getInt(1);
                                                    String model = resultSet4.getString(2);
                                                    String brand = resultSet4.getString(7);
                                                    String type = resultSet4.getString(9);
                                                    int countNucleus = resultSet4.getInt(5);
                                                    double hz = resultSet4.getDouble(4);
                                                    int storage = resultSet4.getInt(8);
                                                    int price = resultSet4.getInt(2);
                                                    int count = resultSet4.getInt(6);
                                                    System.out.printf("%d. Model: %s; Brand: %s; Type: %s; Count of nucleus: %d; Hz: %f; Storage: %d; Price: %d tenge; Count: %d\n", id, model, brand, type, countNucleus, hz, storage, price, count);
                                                }
                                                System.out.print("Which processor? (id) ");
                                                int processor_id = sc.nextInt();
                                                resultSet4 = statement.executeQuery("SELECT * FROM processor");
                                                while (resultSet4.next()) {
                                                    if (resultSet4.getInt(1) == processor_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + processor_id;
                                                        statement.executeUpdate(sql);
                                                    }
                                                }
                                                break;
                                            case 5:
                                                resultSet4 = statement.executeQuery("SELECT* FROM laptop");
                                                System.out.println("All available laptops: ");
                                                while (resultSet4.next()) {
                                                    int id = resultSet4.getInt(1);
                                                    String os = resultSet4.getString(2);
                                                    String type = resultSet4.getString(3);
                                                    String characteristic = resultSet4.getString(4);
                                                    int number = resultSet4.getInt(5);
                                                    int price = resultSet4.getInt(6);
                                                    String brand = resultSet4.getString(7);
                                                    System.out.printf("%d. Os: %s; Type: %s; Brand: %s; Characteristic: %s; Price: %d tenge; Count: %s; \n", id, os, type, brand, characteristic, price, number);
                                                }
                                                System.out.print("Which laptop? (id) ");
                                                int laptop_id = sc.nextInt();
                                                resultSet4 = statement.executeQuery("SELECT* FROM laptop");
                                                while (resultSet4.next()) {
                                                    if (resultSet4.getInt(1) == laptop_id) {
                                                        String sql = "DELETE FROM screen WHERE id = " + laptop_id;
                                                        statement.executeUpdate(sql);
                                                    }
                                                }
                                                break;
                                        }
                                    }catch (Exception ex) {
                                        System.out.println("Good");
                                    }
                                case 4:
                                    repeat();
                                    break;

                                default:
                                    System.out.print("Nothing have chosen.");
                            }
                            System.out.println("What are you want?" + "\n" +
                                    "1. Edit products;\n" +
                                    "2. Add new product;\n" +
                                    "3. Remove products;\n" +
                                    "4. Exit from admin;");
                            selects = sc.nextInt();
                        }
                    }
                    else
                        System.out.print("Go away, you are not admin.");
                    break;
                default:
                    System.out.print("Nothing have chosen.");
                }
            System.out.println("What are you want?" + "\n" +
                    "1. Show all available products;\n" +
                    "2. Make purchase;\n" +
                    "3. Show my basket;\n" +
                    "4. Log in as Admin\n" +
                    "0. Exit");
            selection = sc.nextInt();
            }
        }
        public static void repeat() throws SQLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        main(new String[]{"[Ljava.lang.String;@66a29884"});
        }
    }
