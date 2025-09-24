// Command Pattern Example in Kotlin
// Remote executes commands on Light and Stereo

interface Command { fun execute(); fun undo() }

class Light { fun on() = println("Light ON"); fun off() = println("Light OFF") }
class Stereo { fun on() = println("Stereo ON"); fun off() = println("Stereo OFF") }

class LightOnCommand(private val l: Light) : Command { override fun execute() = l.on(); override fun undo() = l.off() }
class LightOffCommand(private val l: Light) : Command { override fun execute() = l.off(); override fun undo() = l.on() }
class StereoOnCommand(private val s: Stereo) : Command { override fun execute() = s.on(); override fun undo() = s.off() }
class StereoOffCommand(private val s: Stereo) : Command { override fun execute() = s.off(); override fun undo() = s.on() }

class RemoteButton(private var cmd: Command) { fun set(c: Command){ cmd = c }; fun press() = cmd.execute(); fun pressUndo() = cmd.undo() }

fun main(){ val light = Light(); val stereo = Stereo(); val btn = RemoteButton(LightOnCommand(light)); btn.press(); btn.pressUndo(); btn.set(StereoOnCommand(stereo)); btn.press(); btn.pressUndo() }
