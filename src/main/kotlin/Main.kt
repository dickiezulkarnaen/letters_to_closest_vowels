import kotlin.math.absoluteValue
import kotlin.system.exitProcess

fun main() = start()

fun start() {
    val name = readLine()
    if (name?.lowercase() == "q") { // Exit
        exitProcess(0)
    } else {
        if (!name.isNullOrEmpty()) {
            for (element in name) {
                val position = alphabet.indexOf(element.lowercase())
                val closest = getClosestFromVowels(position)
                print(alphabet[closest])
            }
        }
        println()
        start() // Repeat
    }
}

fun getClosestFromVowels(position: Int): Int {
    val vowels = arrayOf(0, 4, 8, 14, 20)
    val closest: Int
    if (vowels.contains(element = position)) { // Check if given position is a vowel
        closest = position
    } else if (position >= vowels[vowels.lastIndex]) { // Check if given position is after last vowel (U)
        closest = vowels[vowels.lastIndex]
    } else {
        val difference = arrayOf(0, 0, 0, 0, 0)
        for (index in vowels.indices) {
            val diff = vowels[index] - position // Check diff each index
            difference[index] = diff.absoluteValue
        }

        // Get lowest value from difference and get the index, then get value from vowels by obtained index
        closest = vowels[difference.indexOf(difference.min())]
    }
    return closest
}

const val alphabet = "abcdefghijklmnopqrstuvwxyz"