// Mediator Pattern Example in Java
// Chat room where users send messages through a mediator

import java.util.*;

interface ChatRoom { void sendMessage(String message, User user); void addUser(User user); }

abstract class User {
    protected ChatRoom chatRoom;
    protected String name;
    public User(String name, ChatRoom room) { this.name = name; this.chatRoom = room; }
    public abstract void send(String message);
    public abstract void receive(String message, String from);
    public String getName() { return name; }
}

class ConcreteUser extends User {
    public ConcreteUser(String name, ChatRoom room) { super(name, room); }
    public void send(String message) { chatRoom.sendMessage(message, this); }
    public void receive(String message, String from) { System.out.println(name + " received: " + message + " (from " + from + ")"); }
}

class ConcreteChatRoom implements ChatRoom {
    private final List<User> users = new ArrayList<>();
    public void addUser(User user) { users.add(user); }
    public void sendMessage(String message, User sender) {
        for (User user : users)
            if (user != sender)
                user.receive(message, sender.getName());
    }
}

public class MediatorExample {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ConcreteChatRoom();
        User alice = new ConcreteUser("Alice", chatRoom);
        User bob = new ConcreteUser("Bob", chatRoom);
        User charlie = new ConcreteUser("Charlie", chatRoom);
        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);

        alice.send("Hello everyone!");
        bob.send("Hi Alice!");
    }
}
