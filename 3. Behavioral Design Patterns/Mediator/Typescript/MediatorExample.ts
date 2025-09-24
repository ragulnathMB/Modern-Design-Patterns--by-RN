// Mediator Pattern Example in TypeScript
// Chat room where users send messages through a mediator

interface ChatRoom {
  sendMessage(message: string, user: User): void
  addUser(user: User): void
}

abstract class User {
  constructor(public name: string, protected chatRoom: ChatRoom) {}
  abstract send(message: string): void
  abstract receive(message: string, from: string): void
}

class ConcreteUser extends User {
  send(message: string): void { this.chatRoom.sendMessage(message, this) }
  receive(message: string, from: string): void { console.log(`${this.name} received: ${message} (from ${from})`) }
}

class ConcreteChatRoom implements ChatRoom {
  private users: User[] = []
  addUser(user: User): void { this.users.push(user) }
  sendMessage(message: string, sender: User): void {
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

export {}
