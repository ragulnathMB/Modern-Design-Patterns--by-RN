// Mediator Pattern Example in JavaScript
// Chat room where users send messages through a mediator

class ChatRoom {
  sendMessage(message, user) {}
  addUser(user) {}
}

class User {
  constructor(name, chatRoom) { this.name = name; this.chatRoom = chatRoom }
  send(message) {}
  receive(message, from) {}
}

class ConcreteUser extends User {
  send(message) { this.chatRoom.sendMessage(message, this) }
  receive(message, from) { console.log(`${this.name} received: ${message} (from ${from})`) }
}

class ConcreteChatRoom extends ChatRoom {
  constructor() { super(); this.users = [] }
  addUser(user) { this.users.push(user) }
  sendMessage(message, sender) {
    for (const user of this.users)
      if (user !== sender)
        user.receive(message, sender.name)
  }
}

;(function main() {
  const chatRoom = new ConcreteChatRoom()
  const alice = new ConcreteUser('Alice', chatRoom)
  const bob = new ConcreteUser('Bob', chatRoom)
  const charlie = new ConcreteUser('Charlie', chatRoom)
  chatRoom.addUser(alice)
  chatRoom.addUser(bob)
  chatRoom.addUser(charlie)

  alice.send('Hello everyone!')
  bob.send('Hi Alice!')
})()
