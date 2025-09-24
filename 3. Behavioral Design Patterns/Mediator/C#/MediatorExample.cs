// Mediator Pattern Example in C#
// Chat room where users send messages through a mediator

using System;
using System.Collections.Generic;

namespace MediatorExample
{
    interface IChatRoom { void SendMessage(string message, User user); void AddUser(User user); }

    abstract class User
    {
        protected IChatRoom chatRoom;
        public string Name { get; }
        public User(string name, IChatRoom room) { Name = name; chatRoom = room; }
        public abstract void Send(string message);
        public abstract void Receive(string message, string from);
    }

    class ConcreteUser : User
    {
        public ConcreteUser(string name, IChatRoom room) : base(name, room) {}
        public override void Send(string message) { chatRoom.SendMessage(message, this); }
        public override void Receive(string message, string from) { Console.WriteLine($"{Name} received: {message} (from {from})"); }
    }

    class ConcreteChatRoom : IChatRoom
    {
        private readonly List<User> users = new();
        public void AddUser(User user) { users.Add(user); }
        public void SendMessage(string message, User sender)
        {
            foreach (var user in users)
                if (user != sender)
                    user.Receive(message, sender.Name);
        }
    }

    class Program
    {
        static void Main()
        {
            var chatRoom = new ConcreteChatRoom();
            var alice = new ConcreteUser("Alice", chatRoom);
            var bob = new ConcreteUser("Bob", chatRoom);
            var charlie = new ConcreteUser("Charlie", chatRoom);
            chatRoom.AddUser(alice);
            chatRoom.AddUser(bob);
            chatRoom.AddUser(charlie);

            alice.Send("Hello everyone!");
            bob.Send("Hi Alice!");
        }
    }
}
