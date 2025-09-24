// Command Pattern – JavaScript Template

class Command { execute(){} undo(){} }

class Receiver { action(){ /* do something */ } undoAction(){ /* undo something */ } }

class ConcreteCommand extends Command {
  constructor(r){ super(); this.r = r }
  execute(){ this.r.action() }
  undo(){ this.r.undoAction() }
}

class Invoker { constructor(){ this.cmd = null } set(c){ this.cmd = c } run(){ if(this.cmd) this.cmd.execute() } undo(){ if(this.cmd) this.cmd.undo() } }

;(function main(){ const inv = new Invoker(); inv.set(new ConcreteCommand(new Receiver())); inv.run(); inv.undo() })()
