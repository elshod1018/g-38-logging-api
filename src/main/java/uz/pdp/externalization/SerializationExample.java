package uz.pdp.externalization;

import lombok.*;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        User user = new User(1, "Name");
        String filename = "users.txt";
        try (FileOutputStream file = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(file)) {
            out.writeObject(user);
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
        try (FileInputStream file = new FileInputStream(filename);
             ObjectInputStream out = new ObjectInputStream(file)) {
            User user1 = (User) out.readObject();
            System.out.println(user1);
            System.out.println("Object has been serialized");
        } catch (Exception ex) {
            System.out.println("IOException is caught");
        }
    }
}

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class User implements Externalizable {
    private Integer age;
    private String name;

    @Override
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        if (age < 0) {
            throw new RuntimeException("Error");
        }
        objectOutput.writeObject(age);
        objectOutput.writeObject("name" + name);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        objectInput.readObject();
        this.name = (String) objectInput.readObject();
    }
}
