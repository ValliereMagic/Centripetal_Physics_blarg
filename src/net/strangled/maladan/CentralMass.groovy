package net.strangled.maladan

/**
 * MaladaN (R)
 */
class CentralMass {
    static execute(LinkedList<String> info) {
        Options options = new Options(info)
        if (options.getVelocity() && options.getOrbitalRadius() && !options.getFrequency() && !options.getaC() && !options.getPeriod() && !options.getcMass()) {
            return velocityAndRadius(options.getVelocity(), options.getOrbitalRadius())
        } else if (!options.getVelocity() && options.getOrbitalRadius() && !options.getFrequency() && !options.getaC() && options.getPeriod() && !options.getcMass()) {
            return periodAndRadius(options.getPeriod(), options.getOrbitalRadius())
        } else if (!options.getVelocity() && options.getOrbitalRadius() && options.getFrequency() && !options.getaC() && !options.getPeriod() && !options.getcMass()) {
            return frequencyAndRadius(options.getFrequency(), options.getOrbitalRadius())
        } else if (!options.getVelocity() && options.getOrbitalRadius() && !options.getFrequency() && options.getaC() && !options.getPeriod() && !options.getcMass()) {
            return aCAndRadius(options.getaC(), options.getOrbitalRadius())
        } else {
            return "Either not enough data supplied, or parameters not supported."
        }
    }

    static velocityAndRadius(double velocity, double radius) {
        return answerFormatter((radius * (velocity)**2) / Main.gravityConstant)
    }

    static periodAndRadius(double period, double radius) {
        return answerFormatter(((radius)**3 * 4 * (Math.PI)**2) / (Main.gravityConstant * (period)**2))
    }

    static frequencyAndRadius(double frequency, double radius) {
        return answerFormatter(((radius)**3 * 4 * (Math.PI)**2 * (frequency)**2) / (Main.gravityConstant))
    }

    static aCAndRadius(double aC, double radius) {
        return answerFormatter(((radius)**3 * aC) / (Main.gravityConstant))
    }

    static answerFormatter(double answer) {
        return "The Central Object's mass is: " + answer + " kilograms."
    }
}
