package net.strangled.maladan

/**
 * MaladaN (R)
 */
class Main {
    static gravityConstant = 6.67 * 10**-11
    static cMassOfEarth = 5.96 * 10**24

    static void main(String[] args) {
        if (args[0] == '--help' || args[0] == '-h') {
            Documentation.printInstructions()
        } else if (args[0] == '--orbital-radius' || args[0] == '-or') {
            println(OrbitalRadius.execute(formatData(args)))
        } else if (args[0] == '--calc-mass-central' || args[0] == '-cMass') {
            println(CentralMass.execute(formatData(args)))
        }
    }

    static LinkedList<String> formatData(String[] args) {
        LinkedList<String> data = args
        data.remove(0)
        return data
    }
}
