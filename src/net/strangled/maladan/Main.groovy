package net.strangled.maladan

/**
 * MaladaN (R)
 */
class Main {
    static gravityConstant = 6.67e-11
    static cMassOfEarth = 5.96e24
    static errorMessage = "Either incorrect number of arguments, or parameters not supported."

    static void main(String[] args) {
        if (args) {
            if (args[0] == '--help' || args[0] == '-h') {
                Documentation.printInstructions()
            } else if (args[0] == '--orbital-radius' || args[0] == '-or') {
                println(OrbitalRadius.execute(formatData(args)))
            } else if (args[0] == '--calc-mass-central' || args[0] == '-cMass') {
                println(CentralMass.execute(formatData(args)))
            } else if (args[0] == '--centripetal-acceleration' || args[0] == '-cacc') {
                println(CentripetalAcceleration.execute(formatData(args)))
            }
        } else {
            println(errorMessage)
        }
    }

    static LinkedList<String> formatData(String[] args) {
        LinkedList<String> data = args
        data.remove(0)
        return data
    }

    static earthAssumption() {
        println('Assuming earth as object being orbited')
    }
}
