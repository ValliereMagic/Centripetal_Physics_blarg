package net.strangled.maladan

/**
 * MaladaN (R)
 */
class Main {
    static void main(String[] args) {
        if (args[0] == '--help' || args[0] == '-h') {
            Documentation.printInstructions()
        } else if (args[0] == '--orbital-radius' || args[0] == '-or') {
            LinkedList<String> data = args
            data.remove(0)
            println(OrbitalRadius.execute(data))
        }
    }
}
