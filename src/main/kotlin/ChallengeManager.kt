import challengetypes.NoCraftingTable
import org.bukkit.plugin.Plugin

private var plugin: Plugin? = null
private var currentTime: Int = 0

private var currentGame: Game = Game(plugin!!)

fun setPlugin(plugin1: Plugin){
    plugin = plugin1
}

fun startTimer(): Boolean{
    currentGame = Game(plugin!!)
    return currentGame.start()
}

fun stopTimer(): Boolean {
    return currentGame.stop()
}

fun shortInteger(duration: Int): String {
    var duration = duration
    var string = ""
    var hours = 0
    var minutes = 0
    var seconds = 0

    if (duration / 60 / 60 / 24 >= 1) {
        duration -= duration / 60 / 60 / 24 * 60 * 60 * 24
    }
    if (duration / 60 / 60 >= 1) {
        hours = duration / 60 / 60
        duration -= duration / 60 / 60 * 60 * 60
    }
    if (duration / 60 >= 1) {
        minutes = duration / 60
        duration -= duration / 60 * 60
    }
    if (duration >= 1) seconds = duration
    string = if (hours <= 9) {
        string + "0" + hours + ":"
    } else {
        "$string$hours:"
    }
    string = if (minutes <= 9) {
        string + "0" + minutes + ":"
    } else {
        "$string$minutes:"
    }
    string = if (seconds <= 9) {
        string + "0" + seconds
    } else {
        string + seconds
    }
    return string
}