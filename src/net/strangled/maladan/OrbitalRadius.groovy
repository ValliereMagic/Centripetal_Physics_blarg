package net.strangled.maladan

/**
 * MaladaN(R)
 */
class OrbitalRadius {
    static execute(LinkedList<String> info) {
        Options options = new Options(info)
        if (options.getPeriod() && !options.getVelocity() && !options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            return periodOnly(options.getPeriod())
        } else if (options.getPeriod() && options.getVelocity() && !options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            return periodAndVelocity(options.getPeriod(), options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            return frequencyAndVelocity(options.getFrequency(), options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && !options.getFrequency() && options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            return aCAndVelocity(options.getaC(), options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && !options.getFrequency() && !options.getaC() && !options.getcMass() && !options.getOrbitalRadius()) {
            return velocityOnly(options.getVelocity())
        } else if (!options.getPeriod() && options.getVelocity() && !options.getFrequency() && !options.getaC() && options.getcMass() && !options.getOrbitalRadius()) {
            return velocityAndCentralMass(options.getVelocity(), options.getcMass())
        } else if (options.getPeriod() && !options.getVelocity() && !options.getFrequency() && !options.getaC() && options.getcMass() && !options.getOrbitalRadius()) {
            return periodAndCentralMass(options.getPeriod(), options.getcMass())
        }
        else {
            return "Either not enough data supplied, or parameters not supported."
        }
    }

    static periodOnly(double period) {
        earthAssumption()
        return answerFormatter(Math.cbrt((Main.gravityConstant * Main.cMassOfEarth * ((period)**2) / (4 * (Math.pow(Math.PI, 2))))))
    }
    static periodAndVelocity(double period, double velocity) {
        return answerFormatter(velocity * period) / (2 * (Math.PI))
    }
    static frequencyAndVelocity(double frequency, double velocity) {
        return answerFormatter(velocity * (1 / frequency) / (2 * (Math.PI)))
    }
    static aCAndVelocity(double aC, double velocity) {
        return answerFormatter((velocity**2 / aC))
    }
    static velocityOnly(double velocity) {
        earthAssumption()
        return answerFormatter(Math.sqrt((Main.gravityConstant * Main.cMassOfEarth) / (velocity)**2))
    }
    static velocityAndCentralMass(double velocity, double cMass) {
        return answerFormatter(Math.sqrt((Main.gravityConstant * cMass) / (velocity)**2))
    }
    static periodAndCentralMass(double period, double cMass) {
        return answerFormatter(Math.cbrt((Main.gravityConstant * cMass * ((period)**2) / (4 * (Math.pow(Math.PI, 2))))))
    }

    static answerFormatter(double answer) {
        return "The orbital radius is: " + answer + " meters."
    }
    static earthAssumption() {
        println('Assuming earth as object being orbited')
    }
}
